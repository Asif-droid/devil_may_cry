package objects;

import framework.gameobj;
import framework.obj_id;
import framework.texture;
import game_dev1.game;

import java.awt.*;
import java.util.LinkedList;

public class door extends gameobj {
    public texture tex= game.gettex();
    public door(float x, float y, obj_id id) {
        super(x, y, id);
        life=2;
    }

    @Override
    public void tick(LinkedList<gameobj> obj) {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(tex.temp_bim[2],(int)x,(int)y,71,74,null);

    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle((int)x,(int)y,60,70);
    }
}
