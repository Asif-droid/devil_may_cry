package game_dev1;

import javax.swing.*;
import java.awt.*;

public class window
{
    public  window(int h,int w,String title,game g)
    {

        g.setPreferredSize(new Dimension(h,w));
        g.setMaximumSize(new Dimension(h,w));
        g.setMinimumSize(new Dimension(h,w));
        JFrame fram=new JFrame(title);
        fram.add(g);
        fram.pack();
        fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fram.setResizable(false);
        fram.setVisible(true);
        g.start();


    }

}
