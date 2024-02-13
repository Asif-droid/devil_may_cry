package framework;

import game_dev1.handaler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyInput extends KeyAdapter {
    handaler hand=new handaler();
    public  static int jmpc=0;
    //player p;
    public keyInput(handaler hand){
        this.hand=hand;

    }
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
        for(int i=0;i<hand.obj.size();i++){

                gameobj tempobj=hand.obj.get(i);
                if(tempobj.getid()==obj_id.player){
                    if(key==KeyEvent.VK_SPACE){
                        tempobj.hit=true;
                    }

                    if(key==KeyEvent.VK_D&&tempobj.life>10){
                        tempobj.right=true;
                        tempobj.left=false;
                        if(tempobj.isFalling()){
                            tempobj.velx+=3;
                            if(tempobj.velx>=6){
                                tempobj.velx=6f;
                            }
                        }
                        else {
                            tempobj.velx += 1.5;
                            if (tempobj.velx >= 3.5f) tempobj.velx = 3.5f;
                        }
                    }
                    if(key==KeyEvent.VK_A&&tempobj.life>10){
                        tempobj.right=false;
                        tempobj.left=true;
                        if(tempobj.isFalling()){
                            tempobj.velx-=3;
                            if(tempobj.velx<=-6){
                                tempobj.velx=-6f;
                            }
                        }
                        else {
                            tempobj.velx -= 1.5;
                            if (tempobj.velx <= -3.5f) tempobj.velx = -3.5f;
                        }
                    }
                    if(jmpc==2){
                        //tempobj.setVely(0);
                        jmpc=0;


                        tempobj.jump=false;
                        tempobj.falling=true;}
                    if(!(tempobj.isFalling())&&(jmpc<2)){
                        if(key==KeyEvent.VK_W) {
                            jmpc++;

                            System.out.println("w is pressed");
                            tempobj.vely -= 5.8;
                            if (tempobj.vely <= -10.5) tempobj.vely = -10.5f;
                            tempobj.jump = true;
                           // tempobj.falling=false;//have to see
                        }
                    }
                }
        }


    }
    public void keyReleased(KeyEvent e){
        int  key=e.getKeyCode();
        for(int i=0;i<hand.obj.size();i++){
            gameobj tempobj= hand.obj.get(i);
            if(tempobj.getid()==obj_id.player){
                if(key==KeyEvent.VK_D){
                    tempobj.setVelx(0);
                }
                if(key==KeyEvent.VK_SPACE){
                    tempobj.hit=false;
                }
                if(key==KeyEvent.VK_A){
                    tempobj.setVelx(0);
                }
                if(key==KeyEvent.VK_W){
                    tempobj.setVely(0);

                    jmpc=0;
                    tempobj.jump=false;
                    tempobj.falling=true;
                }

            }
        }
    }
}
