package game_dev1;

import framework.background;
import framework.keyInput;
import framework.obj_id;
import framework.texture;
import objects.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class game extends Canvas implements Runnable
{
    private boolean running=false;
    private Thread thread;
    handaler hand;
    public static int height=800;
    public static  int weidth=600;
    public  int getW()
    {
        return weidth;
    }
    public int getH()
    {
        return height;
    }
    public camera cam=new camera(0,0);
    public BufferedImage level=null;
    public static texture tex;



    private void init()
    {
        tex=new texture();
        //BufferedImageLoader loader=new BufferedImageLoader();
        //level=loader.loadimage("/level.png");
       // loadimage(level);

        hand=new handaler();
        hand.addobj(new background(0,0,obj_id.bg));
        hand.addobj(new key(2300,150,obj_id.key));
        hand.addobj(new door(1492,116,obj_id.door));

        //hand.addobj(new enemy(900,350,obj_id.enemy));
        //hand.addobj(new bulets(900,350,obj_id.bullet));
       // hand.addobj(new enemy(900,490,obj_id.enemy));
        //hand.addobj(new bulets(900,200,obj_id.bullet,hand.obj.get(2)));
        //System.out.println(obj_id.bullet);
       // hand.addobj(new block(50,500,obj_id.block));
        hand.create_enemy(1450,110);
        hand.create_enemy(2000,170);
        hand.addobj(new demonboss(2200,300,obj_id.boss));
        hand.addobj(new demonboss(1800,100,obj_id.boss));
        hand.addobj(new bulets(2200,300,obj_id.bullet,hand.obj.get(5)));
        hand.addobj(new bulets(1800,100,obj_id.bullet,hand.obj.get(6)));
        hand.createlevel();

        hand.addobj(new temp_block(1920,425,obj_id.temp_block,'h','a'));
        hand.addobj(new temp_block(1925,533,obj_id.temp_block,'h','b'));
        //hand.addobj(new bulets(900,200,obj_id.bullet,hand.obj.get(2)));
        hand.addobj(new player(35,100,obj_id.player));

        this.addKeyListener(new keyInput(hand));

    }

    public  synchronized void  start()
    {
        if(running)
            return;
        running= true;
        thread=new Thread(this);
        thread.start();
    }

    @Override

    public void run() {
        init();
        this.requestFocus();
        long lastTime=System.nanoTime();
        double amontTick=60.0;
        double ns=1000000000/amontTick;
        double delta=0;
        long timer=System.currentTimeMillis();
        int update =0;
        int frame=0;
        while(running)
        {
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while (delta>=1)
            {
                tick();
                update++;
                delta--;
            }
            render();
            frame++;
            if(System.currentTimeMillis()-timer>1000)
            {
                timer+=1000;
                System.out.println("frames"+frame+"ticks"+update);
                frame=0;
                update=0;
            }

        }


        System.out.println("game is] on");
    }

private  void tick()
{
    hand.tick();
    for(int i=0;i<hand.obj.size();i++)
    {

        if(hand.obj.get(i).getid()==obj_id.player){
            cam.tick(hand.obj.get(i));
        }
    }

}
private  void render()
{
   BufferStrategy bs=this.getBufferStrategy();
   if(bs==null)
   {
       this.createBufferStrategy(3);
       return;
   }
   Graphics g=bs.getDrawGraphics();
   Graphics m=bs.getDrawGraphics();
   Graphics2D g2d=(Graphics2D) g;
   g.setColor(Color.black);
   m.setColor(Color.red);

   //g.fillRect(0,0,getWidth(),getHeight());
   // g.drawImage(,0,0,null);
   //m.fillOval(100,100,400,400);

   //bs.show();
   //m.dispose();
    g2d.translate(cam.getX(),cam.getY());
    hand.render(g);
   g.dispose();
   //g2d.translate(-cam.getX(),-cam.getY());

   bs.show();
}
private  void loadimage(BufferedImage image)
{
    int w=image.getWidth();
    int h=image.getHeight();
    System.out.println(w+" "+h);
   /*for(int i=0;i<h;i++){
        for(int j=0;j<w;j++){
            int pixl=image.getRGB(i,j);
            int r=(pixl>>16)&0xff;
            int g=(pixl>>8)&0xff;
            int b=(pixl)&0xff;
            if(r==255&&g==255&&b==255){
                hand.addobj(new block(i*32,j*32,obj_id.block));
            }
        }
    }*/
}
public static texture gettex(){
        return tex;
}
    public  static  void main(String args[])
    {

        new window(height,weidth,"devil may cry",new game());
    }
}
