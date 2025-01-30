import java.awt.GridLayout;

import javax.swing.*;

public class Interface{
    JFrame frame;
    JPanel mazePanel;

    public Interface()
    {
        frame = new JFrame();
        mazePanel = new JPanel();

        JLabel space = new JLabel("");
        JButton b1 = new JButton("Simpel");    
        JButton b2 = new JButton("Freistehend");    
        JButton b3 = new JButton("Komplex");    
        JButton b4 = new JButton("Groß"); 

        mazePanel.add(space);mazePanel.add(b1);mazePanel.add(b2);mazePanel.add(b3);mazePanel.add(b4);

        mazePanel.setLayout(new GridLayout(5, 1, 20, 0));
        mazePanel.setSize(400,600);
        frame.add(mazePanel);
        frame.setLayout(null);
        frame.setSize(2000, 1000);
        frame.setVisible(true);
    }

    public void ShowMaze(int[][] m, int[] start)
    {
        //maze size over 500 by 500 area
        @SuppressWarnings("unused")
        int[] blockSize = new int[]{ 500 /m.length , 500 / m[0].length};
        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j < m[0].length; j++)
            {
                //frame.getContentPane().add(new Square(10, 10, 100, 100));
            }
        }
    }
}
