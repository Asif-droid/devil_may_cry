package game_dev1;

import java.awt.*;
import java.awt.desktop.AppReopenedEvent;
import java.awt.image.BufferedImage;

public class animation {
    private int speed;
    private int frames;
    private int index=0;
    private int current=0;
    private BufferedImage image[];
    private BufferedImage currentimg;
    public animation(int speed,BufferedImage...args){
        this.speed=speed;
        image=new BufferedImage[args.length];
        frames=args.length;
        for(int i=0;i<frames;i++){
            image[i]=args[i];
        }
    }
    public void runNimation(){
        index++;
        if(index>speed){
            index=0;
            nextframe();
        }
    }
    public void nextframe(){
        for(int i=0;i<frames;i++) {
            if (current == i) {
                currentimg = image[i];
            }
        }
            current++;
            if(current>frames)
            {
                current=0;}


    }
    public void draw(Graphics g, int x, int y){
        g.drawImage(currentimg,(int)x,(int)y,null);
    }
    public void draw(Graphics g,int x,int y,int scaleX,int scaleY){
        g.drawImage(currentimg,(int)x,(int)y,scaleX,scaleY,null);
    }

}
