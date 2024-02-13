package framework;

import java.awt.image.BufferedImage;

public class sprites {
    private BufferedImage image;
    sprites(BufferedImage image){
        this.image=image;

    }
    public BufferedImage subimage(int col,int row,int width,int height){
        BufferedImage img=image.getSubimage((col*width)-width,(row*height)-height,width,height);
        return img;
    }
    public BufferedImage picsubimage(int x,int y,int weidth,int height)
    {
        BufferedImage img=image.getSubimage(x,y,weidth,height);
        return img;
    }
}
