import java.awt.Graphics;


public class Square{
    int x;
    int y;
    int width;
    int height;

    public Square(int newX, int newY, int newW, int newH)
    {
        x = newX;
        y = newY;
        width = newW;
        height = newH;
    }

    public void paintComponent(Graphics g)
    {
        g.drawRect(x, y, width, height);
    }


}
