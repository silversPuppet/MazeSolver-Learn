import java.awt.*;

import javax.swing.*;



public class Square extends JPanel{
    int x;
    int y;
    int width;
    int height;
    boolean wall;

    public Square(int newX, int newY, int newW, int newH, boolean w)
    {
        x = newX;
        y = newY;
        width = newW;
        height = newH;
        wall = w;
    }

    public void paintComponent(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if(wall)
        {
            g.setColor(Color.BLACK);
        }
        else
        {
            g.setColor(Color.white);
        }
        g.drawRect(x, y, width, height);
        
        g2d.dispose();
    }


}
