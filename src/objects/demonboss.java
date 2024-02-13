package objects;

import framework.gameobj;
import framework.obj_id;
import framework.texture;
import game_dev1.animation;
import game_dev1.game;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class demonboss extends gameobj
{
    public texture tex= game.gettex();
    public animation demn;
    public float initx;
    public Random rand=new Random();
    int term=0;
    public demonboss(float x, float y, obj_id id) {
        super(x, y, id);
        demn=new animation(5,tex.demnboss[0],tex.demnboss[1],tex.demnboss[2],tex.demnboss[3]);
        initx=x;
        life=30;
    }


    @Override
    public void tick(LinkedList<gameobj> obj) {
        //System.out.println(rand.nextInt(10));
        if(term<100){
            hit=true;
        }
        else{
            hit=false;
        }
        if(right){
            y-=1;
            if(y<50){
             right=false;
             left=true;
            }
        }
        else if(left){
            y+=1;
            if(y>300){
                right=true;
                left=false;
            }
        }
        term++;
        if(term==200){
            term=0;
        }
        demn.runNimation();

    }

    @Override
    public void render(Graphics g) {
        if(tk_hit){
            g.drawImage(tex.demnboss[4],(int)x,(int)y,null);

        }
        else{
             demn.draw(g,(int)x,(int)y);
        }
        /*Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.red);
       g2d.draw(getbounds());*/

    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle((int)x-20,(int)y,100,150);
    }
}
