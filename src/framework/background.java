package framework;

import game_dev1.game;

import java.awt.*;
import java.util.LinkedList;

public class background extends  gameobj{
    texture tex= game.gettex();
    public background(float x, float y, obj_id id) {
        super(x, y, id);
    }

    @Override
    public void tick(LinkedList<gameobj> obj) {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(tex.back_ground[0],0,0,null);
        g.drawImage(tex.back_ground[1],795,0,null);
        g.drawImage(tex.back_ground[2],1590,0,null);

    }

    @Override
    public Rectangle getbounds() {
        return null;
    }
}
