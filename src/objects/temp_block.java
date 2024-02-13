package objects;

import framework.gameobj;
import framework.obj_id;
import framework.texture;
import game_dev1.game;

import java.awt.*;
import java.util.LinkedList;

public class temp_block extends gameobj {
    public char d;
    char type;
    public  float initx;
    public float inity;
    int p;
    public texture tex= game.gettex();
    public temp_block(float x, float y, obj_id id,char d,char type) {

        super(x, y, id);
        this.d=d;
        this.type=type;
        initx=x;
        inity=y;
        velx=.5f;
        vely=.5f;
    }

    @Override
    public void tick(LinkedList<gameobj> obj) {
        if(type=='a'){
            p=120;
        }
        if(type=='b'){
            p=100;
        }
        if(d=='h'){
           x+=velx;
        }
        else if (d == 'v') {
            y+=vely;
        }
        if(right){
            velx=.5f;
            vely=.5f;
            if(x-initx>p||y-inity>150){
                right=false;
                left=true;
            }
        }
        else if(left){
            vely=-.5f;
            velx=-.5f;
            if(initx-x>p||inity-y>150){
                right=true;
                left=false;
            }
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(tex.temp_bim[0],(int)x,(int)y+20,null);

    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle((int)x-30,(int)y+20,90,30);
    }


}
