package game_dev1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageLoader {
    public BufferedImage image;
    public BufferedImage loadimage(String path){
        System.out.println(path);
        try {
            image= ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
