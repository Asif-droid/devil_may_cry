package framework;

import java.awt.*;
import java.util.LinkedList;

public abstract  class gameobj {
    protected  float x,y;
    protected obj_id id;
    protected float velx=0,vely=0;
    public boolean falling=true;
    public boolean jump=false;
    public boolean hit=false;
    public  boolean tk_hit=false;
    public boolean right=true;
    public boolean left=false;
    public float life=10;
    public int count=0;


    public  gameobj(float x,float y,obj_id id)
    {
        this.x=x;
        this.y=y;
        this.id=id;
    }
    public abstract void tick(LinkedList<gameobj> obj);
    public abstract void render(Graphics g);
    public abstract Rectangle getbounds();
    public void setX(float x)
    {
        this.x=x;
    }
    public void sety(float y){
        this.y=y;
    }
    public float getX()
    {
        return  x;

    }

    public float getY() {
        return y;
    }

    public void setVelx(float velx) {
        this.velx = velx;
    }

    public void setVely(float vely) {
        this.vely = vely;
    }

    public float getVelx() {
        return velx;
    }

    public float getVely() {
        return vely;
    }

    public boolean isFalling() {
        return falling;
    }

    public boolean isJump() {
        return jump;
    }

    public obj_id getid()
    {
        return id;
    }
    public boolean isHit(){
        return  hit;
    }
}
