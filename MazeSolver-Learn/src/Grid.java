
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grid extends JPanel{
    int width;
    int height;
    int[][] maze;

    public Grid(int w, int h, int[][] m) 
    {
        setSize(width = w, height = h);
        maze = m;
    }
    
    public void paint(Graphics g)
    {
        width = getSize().width;
        height = getSize().height;

        int rowH = width / maze[0].length;
        int colH = height / maze.length;
        for(int i = 0; i <  maze.length; i++)
        {
            for(int j = 0; j < maze[i].length; j++)
            {
                
                switch (maze[i][j]) {
                    case 1:
                        g.fillRect(j * rowH, i * colH, rowH,colH);
                        break;

                    case 2:
                        g.setColor(Color.decode("#09BC8A"));
                        g.fillRect(j * rowH, i * colH, rowH,colH);
                        g.setColor(Color.decode("#201A23"));
                        break;

                    case 3:
                        g.setColor(Color.decode("#a491d3"));
                        g.fillRect(j * rowH, i * colH, rowH,colH);
                        g.setColor(Color.decode("#201A23"));
                        break;
                
                    default:
                        g.drawRect(j * rowH, i * colH, rowH,colH);
                        break;
                    
                }
            }
            
        }
        
    }
    
}
