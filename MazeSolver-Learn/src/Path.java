import java.awt.*;
import javax.swing.*;

public class Path extends JPanel{
    int[] cor1;
    int width;
    int height;

    public Path(int[] c1, int w, int h)
    {
        cor1 = c1;
        width = w / 2;
        
    }

    public void paint(Graphics g)
    {


        g.setColor(new Color(1f, 0.22f, 0.39f, 0.5f));
        g.fillOval(0, 0, width, width );
    }
}
