package objects;

import framework.gameobj;
import framework.obj_id;
import framework.texture;
import game_dev1.game;

import java.awt.*;
import java.util.LinkedList;

public class bulets extends gameobj
{
    texture tex= game.gettex();
    public float gravity=.85f;
    public float inity;
    public gameobj host;


    public bulets(float x, float y, obj_id id,gameobj host) {
        super(x, y, id);
        falling=false;
        //velx=-2;
        inity=y;
        this.host=host;

    }

    @Override
    public void tick(LinkedList<gameobj> obj) {
        if(host.hit){
            velx=-2;
        }
        else{
            velx=0;
        }
        if(velx!=0&&y-inity<500){
            //count=10;
            x+=velx;
            y+=gravity;

        }

        else{
            //count=0;
            velx=0;
            /*for(int i=0;i<obj.size();i++)
            {

                gameobj tempobj=obj.get(i);
                if(tempobj.getid()==obj_id.enemy){
                    x=tempobj.getX()-30;
                    y=tempobj.getY()+15;
                }
            }*/
            x=host.getX()-30;
            y=host.getY()+15;

        }
        if(host.life<5){
            life=-1;
        }






    }

    @Override
    public void render(Graphics g) {
        if(velx!=0)
        {
            g.drawImage(tex.bullet[1],(int)x,(int)y,null);
        }
        g.drawImage(tex.bullet[0],(int)x,(int)y,null);

    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle((int)x,(int)y,50,30);
    }
}
