package objects;

import java.awt.*;

public class collision {

    public boolean is_collide(Rectangle rect1,Rectangle rect2){
        if(rect1.intersects(rect2)){
            return  true;
        }
        return false;

    }

}
