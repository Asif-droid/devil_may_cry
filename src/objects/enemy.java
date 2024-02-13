package objects;

import framework.gameobj;
import framework.obj_id;
import framework.texture;
import game_dev1.animation;
import game_dev1.game;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class enemy extends gameobj
{
    Random rand1=new Random();

    texture tex= game.gettex();
    private animation enemywalk;
    private animation enemyattack;
    private animation enemy_b;
    private animation enemy_battak;
    private float intix;
    public collision c;

    public enemy(float x, float y, obj_id id) {
        super(x, y, id);
        life=50;
        enemy_battak=new animation(18,tex.enemy_b[8],tex.enemy_b[5],tex.enemy_b[6],tex.enemy_b[7],tex.enemy_b[8]);
        enemy_b=new animation(7,tex.enemy_b[1],tex.enemy_b[2],tex.enemy_b[3],tex.enemy_b[4]);
        enemywalk=new animation(7,tex.enemy[1],tex.enemy[2],tex.enemy[3],tex.enemy[4]);
        enemyattack=new animation(18,tex.enemy[8],tex.enemy[5],tex.enemy[6],tex.enemy[7],tex.enemy[8]);
        velx=2;
        intix=x;
    }
    boolean tag=true;
    public boolean hit=false;


    @Override
    public void tick(LinkedList<gameobj> obj) {

        if(right){
            x+=velx;
            if(x-intix>100){right=false;
            left=true;}
        }
        else if(left) {
            x-=velx;
            if(x-intix<-100){right=true;
            left=false;
            }
        }
        /*for(int i=0;i<obj.size();i++){
            gameobj tem=obj.get(i);
            if(tem.getid()==obj_id.player){
                if(c.is_collide(getbounds(),tem.getbounds())){
                    life--;
                }
            }

        }*/
        enemywalk.runNimation();
        enemyattack.runNimation();
        enemy_b.runNimation();
        enemy_battak.runNimation();




    }

    @Override
    public void render(Graphics g) {
        if(velx!=0){
            if(left) {
                enemywalk.draw(g, (int) x, (int) y, 60, 85);
            }
            else if(right){
                enemy_b.draw(g, (int) x, (int) y, 60, 85);
            }


        }
        else if(velx==0){
            if(left) {
                enemyattack.draw(g, (int) x, (int) y + 10);
            }
            else if(right){
                enemy_battak.draw(g,(int)x,(int)y+10);
            }

            //g.drawImage(tex.enemy[8],(int)x,(int)y,70,100,null);
        }
        /*Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.red);
       g2d.draw(getbounds());*/


    }

    @Override
    public Rectangle getbounds() {
        if(left) {
            return new Rectangle((int) x -10, (int) y+10, 100, 100);
        }
        else if(right){
            return new Rectangle((int)x,(int)y+10,100,100);
        }
        else {
            return new Rectangle((int)x,(int)y,2,2);
        }

    }
}
