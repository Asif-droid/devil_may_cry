
package game_dev1;

import framework.gameobj;
import framework.obj_id;
import objects.block;
import objects.bulets;
import objects.enemy;

import java.awt.*;
import java.util.LinkedList;

public class handaler {
    public LinkedList<gameobj> obj = new LinkedList<gameobj>();
    private gameobj tempobj;
   // private enemy en[]=new enemy[2];



    public void tick() {

        for (int i = 0; i < obj.size(); i++) {
            tempobj = obj.get(i);
            if(tempobj.life<=0){
                //System.out.println(tempobj.getid());
                removeobj(tempobj);
            }
            else{
                //System.out.println(tempobj.getid());
                tempobj.tick(obj);
            }

        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < obj.size(); i++) {
            tempobj = obj.get(i);
            tempobj.render(g);
        }
    }

    public void addobj(gameobj obj) {
        this.obj.add(obj);

    }

    public void removeobj(gameobj obj) {
        this.obj.remove(obj);

    }

    public void createlevel() {

        for (int i = 0; i <= 2450; i += 16)//horijontal
        {
            addobj(new block(0+i, -40, obj_id.block));
            if (i < 650)
                addobj(new block(i, 535 - 16, obj_id.block));
            if (i < 500)
                addobj(new block(i + 120, 170, obj_id.block));
            if (i < 50) {
                addobj(new block(i + 815, 245, obj_id.block));
                addobj(new block(1100+i,570,obj_id.block));
                addobj(new block(1375+i,570,obj_id.block));
                if (i < 20){
                    addobj(new block(2300+i,200,obj_id.block));
                    addobj(new block(1180 + i, 225, obj_id.block));
                }
            }

            if (i < 200) {

                addobj(new block(1900+i,250,obj_id.block));
                addobj(new block(2230+i,430,obj_id.block));
                addobj(new block(2170+i,500,obj_id.block));
                addobj(new block(2100+i,570,obj_id.block));
                //trial
                addobj(new block(1375+i,195,obj_id.block));
                addobj(new block(i + 900, 410, obj_id.block));
                addobj(new block(i + 1250, 370, obj_id.block));
                if (i < 150)
                {
                    addobj(new block(1595+i,443,obj_id.block));
                    addobj(new block(1595+i,195,obj_id.block));
                    addobj(new block(1450+i,495,obj_id.block));
                    addobj(new block(1120 + i, 300, obj_id.block));
                }
            }

            if (i < 70)//vertical line
            {
                addobj(new block(820, 350 - i, obj_id.block));
                addobj(new block(2360,150-i,obj_id.block));
                addobj(new block(1595,120-i,obj_id.block));
                addobj(new block(1070,500-i,obj_id.block));
            }
            if(i<500){
                addobj(new block(2360,500-i,obj_id.block));
            }
        }

        for (int i = 0; i < 180; i += 5)//aligned line
        {
                addobj(new block(630 + i, 550 - i - 40, obj_id.block));

        }
    }
    public void create_enemy(int x,int y){
        addobj(new enemy(x,y,obj_id.enemy));
        //addobj(new bulets(x,y,obj_id.bullet));
    }

}
