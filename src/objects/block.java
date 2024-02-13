package objects;

import framework.gameobj;
import framework.obj_id;
import framework.texture;
import game_dev1.BufferedImageLoader;
import game_dev1.game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class block extends gameobj {
    texture tex= game.gettex();
    public block(float x, float y, obj_id id)
    {
        super(x,y,id);
    }

   /* BufferedImageLoader loader=new BufferedImageLoader();
    BufferedImage block=loader.loadimage("/blocks.png");
*/
    @Override
    public void tick(LinkedList<gameobj> obj) {

    }

    @Override
    public void render(Graphics g) {
      // g.drawImage(tex.block,(int)x,(int)y,null);

    }
    public Rectangle getbounds()
    {

        return  new Rectangle((int )x,(int)y,16,16);
    }

}
