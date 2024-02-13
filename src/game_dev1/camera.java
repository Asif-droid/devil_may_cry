package game_dev1;

import framework.gameobj;

public class camera {
    private float x,y;
    public camera(){
        x=y=0;
    }
    public  camera(float x,float y)
    {
        this.x=x;
        this.y=y;
    }
    public void tick(gameobj player)
    {
      if(player.getVelx()>0&&player.getX()>340&&x>-1600){
          x-=player.getVelx();
      }
      else if(player.getVelx()<0&&player.getX()<2000&&x<0){
          x-=player.getVelx();
      }
      if(x<-1600)x=-1599;

    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
