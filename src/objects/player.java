package objects;

import framework.gameobj;
import framework.obj_id;
import framework.texture;
import game_dev1.animation;
import game_dev1.game;
import game_dev1.handaler;

import java.awt.*;
import java.util.LinkedList;

public class player extends gameobj {
    texture tex= game.gettex();
    private int height =100;
    private int weidth=70;
    private final int max_speed=10;
    private float gravity= .15f;
    public float str_jm_pos=500;
    private animation playerwalk;
    private animation playerjump;
    private animation playerB_w;
    private animation player_f;
    private animation player_f_b;
    private animation jumping;
    private  animation b_jumping;
    private animation fight_r;
    private animation fight_l;
    private animation jump_fight_r;
    private animation jump_fight_l;
    private boolean h_k=false;
    //public int bullet=obj_id.bullet;
    public boolean bulet=false;
    public collision c=new collision();
    public player(float x, float y, obj_id id) {
        super(x, y, id);
        life=50;
        falling=true;
        jump_fight_l=new animation(4,tex.player_jump[19],tex.player_jump[20],tex.player_jump[21],
                tex.player_jump[22],tex.player_jump[23],tex.player_jump[24],tex.player_jump[25],tex.player_jump[26],
                tex.player_jump[23]);
        jump_fight_r=new animation(4,tex.player_jump[10],tex.player_jump[11],tex.player_jump[12],
                tex.player_jump[13],tex.player_jump[14],tex.player_jump[15],tex.player_jump[16],tex.player_jump[17],
                tex.player_jump[18]);
        fight_l=new animation(6,tex.player_action[12],tex.player_action[13],tex.player_action[14],
                tex.player_action[15],tex.player_action[16],tex.player_action[17],tex.player_action[18],
                tex.player_action[19],tex.player_action[18],tex.player_action[17],
                tex.player_action[19],tex.player_action[20],tex.player_action[21],tex.player_action[22],tex.player_action[23]);

        fight_r=new animation(6,tex.player_action[0],tex.player_action[1],tex.player_action[2],
                tex.player_action[3],tex.player_action[4],tex.player_action[5],tex.player_action[6],
                tex.player_action[7],tex.player_action[6],tex.player_action[5],
                tex.player_action[8],tex.player_action[9],tex.player_action[10],tex.player_action[11]);
        b_jumping=new animation(5,tex.player_jump[8],tex.player_jump[9]);
        jumping=new animation(5,tex.player_jump[6],tex.player_jump[7]);
        player_f=new animation(12,tex.player[9],tex.player[9],tex.player[10],tex.player[11]);
        player_f_b=new animation(12,tex.playerB_w[9],tex.playerB_w[9],tex.playerB_w[10],tex.playerB_w[11]);
        playerwalk=new animation(7,tex.player[1],tex.player[2],tex.player[3],tex.player[4],tex.player[5],tex.player[6],tex.player[8],tex.player[7]);
        playerjump=new animation(10,tex.player_jump[0]);
        playerB_w=new animation(7,tex.playerB_w[1],tex.playerB_w[2],tex.playerB_w[3],tex.playerB_w[4],tex.playerB_w[5],tex.playerB_w[6],tex.playerB_w[8],tex.playerB_w[7]);

    }
    handaler hand=new handaler();


    public void tick(LinkedList<gameobj> obj) {
        x+=velx;
        y+=vely;
        tk_hit=false;
        if(life<8&&life>5){
            if(right){
                x-=.5;

            }
            else if(left){
                x+=.5;
            }
        }
        if(x<50)x=50;
        if(isFalling()||isJump())
        {
            vely+=gravity;
            if(vely>max_speed)vely=max_speed;
        }
        //System.out.println(obj.size());


        for(int i=0;i<obj.size();i++)//collision
        {
            gameobj tempobj=obj.get(i);
            if(tempobj.getid()==obj_id.key){
                if(c.is_collide(getbounds(),tempobj.getbounds())){
                    tempobj.life=-1;
                    h_k=true;
                }
            }
            if(tempobj.getid()==obj_id.door){
                if(c.is_collide(getbounds(),tempobj.getbounds())){
                    if(h_k){
                       tempobj.life=-1;
                    }
                }
            }
            if(tempobj.getid()==obj_id.temp_block){
                if(c.is_collide(getbounds(),tempobj.getbounds())){
                    vely=0;
                    y=tempobj.getY()-70;
                    if(velx==0)
                        x=tempobj.getX();
                    falling=false;

                }
                else{
                    jump = true;
                }
            }
            if(tempobj.getid()==obj_id.boss){
                System.out.println(i);
                if(c.is_collide(getbounds_top(),tempobj.getbounds())){
                    if(hit){
                        tempobj.life-=.5f;
                        tempobj.tk_hit=true;
                        tk_hit=false;
                    }
                    else{
                      life-=.25;
                      tk_hit=true;
                      tempobj.tk_hit=false;
                    }
                }
                else {
                    tempobj.tk_hit=false;
                }

            }

            if(tempobj.getid()==obj_id.enemy){
               // System.out.println(i);
                if(left){

                if(c.is_collide(getbounds_top(),tempobj.getbounds())){
                    tempobj.hit=true;

                    //velx=0;
                    //x=tempobj.getX()-280;
                    bulet=true;
                    if(life>6)
                        tempobj.setVelx(0);
                    if(!hit)
                       life-=.15;
                    if(hit){
                        tempobj.tk_hit=true;
                        tempobj.life-=1.5;
                    }
                    else{
                        tempobj.tk_hit=false;
                        tk_hit=true;
                    }
                }
                else {
                    if(life<10)
                    {
                        life-=.25;
                        tempobj.setVelx(2);
                    }
                    bulet=false;
                    tempobj.hit=false;
                    tk_hit=false;

                    tempobj.setVelx(2);
                }
                }
                else if(right){
                    if(c.is_collide(getbounds_top(),tempobj.getbounds())){

                        //velx=0;
                        //x=tempobj.getX()-280;
                        tempobj.hit=true;
                        bulet=true;
                        if(life>6)
                            tempobj.setVelx(0);
                       if(!hit)
                           life-=.15;
                       if(hit){
                           tempobj.tk_hit=true;
                        tempobj.life-=1.5;
                       }
                       else{
                           tk_hit=true;
                           tempobj.tk_hit=false;
                       }
                    }
                    else {
                        if(life<10)
                        {
                            tempobj.setVelx(2);
                            life-=.25;
                        }
                        bulet=false;
                        //hit=false;
                        tk_hit=false;

                        tempobj.setVelx(2);
                        tempobj.hit=false;
                    }
                }
            }
            if(tempobj.getid()==obj_id.bullet){

                if(c.is_collide(getbounds_top(),tempobj.getbounds())){
                    //x-=10;
                    tempobj.setVelx(0);
                    life-=.05f;
                    tk_hit=true;

                }
                else {
                    tk_hit=false;
                }

            }
            if (tempobj.getid()==obj_id.block){
                if(getbounds().intersects(tempobj.getbounds())){
                    vely=0;
                    y=tempobj.getY()-90;
                    falling=false;
                    str_jm_pos=getY();
                    //System.out.println(falling);
                }
                else {
                    jump=true;

                }
                if(tempobj.getbounds().intersects(getbounds_top())){
                    vely=0;
                    y=tempobj.getY()+50;
                    falling=true;
                }
                if(tempobj.getbounds().intersects(getbounds_left()))
                {
                    setVelx(0);
                    x=tempobj.getX()+30;
                }
                if(tempobj.getbounds().intersects(getbounds_right()))
                {
                    setVelx(0);
                    x=tempobj.getX()-80;
                }
            }
        }
        playerwalk.runNimation();
        playerB_w.runNimation();
        player_f.runNimation();
        player_f_b.runNimation();
        jumping.runNimation();
        b_jumping.runNimation();
        fight_r.runNimation();
        fight_l.runNimation();
        jump_fight_r.runNimation();
        jump_fight_l.runNimation();
        //System.out.println(life);

    }
    public void render(Graphics g) {

         if(vely<0) {
            if(right) {
                if(hit){
                    jump_fight_r.draw(g,(int)x+10,(int)y);
                }
                else if(velx>0){
                    jumping.draw(g,(int)x,(int)y);

                }
                else {
                    if (vely > -2 && !(isFalling())) {
                        g.drawImage(tex.player_jump[0], (int) x, (int) y + 35, null);
                    } else
                        g.drawImage(tex.player_jump[1], (int) x, (int) y,  null);

                }
            }
            else if(left){
                if(hit){
                    jump_fight_l.draw(g,(int)x-10,(int)y);
                }
               else if(velx<0){
                    b_jumping.draw(g,(int)x,(int)y);

                }
                else {
                    if (vely > -2 && !(isFalling())) {
                        g.drawImage(tex.player_jump[3], (int) x, (int) y + 35, null);
                    } else
                        g.drawImage(tex.player_jump[4], (int) x, (int) y, null);


                }
            }
        }
        else if(velx!=0&&!isFalling()){
            if(velx>0){
                if(hit){
                    fight_r.draw(g,(int)x,(int)y+10);

                }
                else{
                    playerwalk.draw(g,(int)x,(int)y);
                }
            }
            else{
                if(hit){
                    fight_l.draw(g,(int)x,(int)y+10);
                }
                else{
                    playerB_w.draw(g,(int)x,(int)y);
                }
            }
        }
        else if (isFalling()){
            if(right){
                if(hit){
                    jump_fight_r.draw(g,(int)x+10,(int)y);
                }
                else
                   g.drawImage(tex.player_jump[2],(int)x,(int)y,null);
            }
            else if(left){
                if(hit){
                    jump_fight_l.draw(g,(int)x-10,(int)y);
                }
                else
                    g.drawImage(tex.player_jump[5],(int)x,(int)y,null);

            }
        }
        else if(life<10&&life>5){
            if(right){
                player_f.draw(g,(int)x,(int)y);

            }
            else if(left){
                player_f_b.draw(g,(int)x,(int)y);

            }
        }
        else if(life<=5){
            if(right)
                g.drawImage(tex.player[11],(int)x-10,(int)y,null);
        else if(left)
            g.drawImage(tex.playerB_w[11],(int)x+110,(int)y,null);
        }
        else {
            if(right){
                if(hit)
                    fight_r.draw(g,(int)x,(int)y+10);
                else{
                    if(tk_hit){
                        g.drawImage(tex.player[12],(int)x,(int)y,null);
                    }
                    else{
                        g.drawImage(tex.player[0], (int) x, (int) y, null);
                    }
                }
            }
            else if(left){
                if(hit){
                    fight_l.draw(g,(int)x,(int)y+10);
                }
                else {
                    if(tk_hit){
                        g.drawImage(tex.playerB_w[12],(int)x,(int)y,null);
                    }else{
                        g.drawImage(tex.playerB_w[0], (int) x, (int) y, null);
                    }
                }
            }
        }
        g.setColor(Color.green);
        g.fillRect((int)x,10,(int)life,10);
        /*Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.BLACK);
       g2d.draw(getbounds());
        g2d.draw(getbounds_top());
        g2d.draw(getbounds_left());
        g2d.draw(getbounds_right());*/

    }

    public Rectangle getbounds() {

        return new Rectangle((int)x+20,(int)y+50,(int)weidth-40,(int)height-60);
    }
    public Rectangle getbounds_top() {

        return new Rectangle((int)x+20,(int)y+20,(int)weidth-40,(int)height-35);
    }
    public Rectangle getbounds_left() {

        return new Rectangle((int)x,(int)y+30,(int)weidth-60,(int)height-70);
    }
    public Rectangle getbounds_right() {

        return new Rectangle((int)x+60,(int)y+30,(int)weidth-60,(int)height-70);
    }
}
