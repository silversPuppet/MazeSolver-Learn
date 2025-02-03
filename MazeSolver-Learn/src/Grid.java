import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class Grid extends JPanel{
    int width;
    int height;
    int[][] maze;

    ArrayList<int[]> cords;
    int curPCount = 0;


    public Grid(int w, int h, int[][] m, ArrayList<int[]> c, int speed) 
    {
        setSize(width = w, height = h);
        maze = m;

        cords = c;
        width = w / 2;
        m = maze;

        for(int i = 0; i < cords.size(); i++)
        {
            System.out.println(cords.get(i)[0] + " " + cords.get(i)[1]);
        }

        Timer timer = new Timer(speed, new ActionListener() {  // 500ms delay
            @Override
            public void actionPerformed(ActionEvent e) {
                curPCount++;   // Increase the number of path spaces
                // Repaint the panel to show the update
                System.out.println("DEBUG" + curPCount);
                repaint();
                if (curPCount >= cords.size()) {  // Stop after reaching all cords
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

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
        float sphereSize = (int) (rowH + colH) / 2.75f ;
        g.setColor(new Color(1f, 0.22f, 0.39f, 0.5f));
        for(int i = 0; i < curPCount; i++)
        {
            
            g.fillOval(cords.get(i)[0] * rowH + rowH/(rowH / 5), cords.get(i)[1] * colH + colH/(colH / 10),(int) sphereSize , (int) sphereSize);
            //System.out.println(cords.get(i)[0] + " " + cords.get(i)[1]);
        }
        
    }
    
}
