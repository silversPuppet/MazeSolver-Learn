import java.awt.*;
import javax.swing.*;

public class Interface{
    JFrame frame;
    JPanel mazeOptPanel;
    JPanel mazePanel;


    public Interface()
    {
        frame = new JFrame();
        mazeOptPanel = new JPanel();

        JLabel space = new JLabel("");
        JButton b1 = new JButton("Simpel");    
        JButton b2 = new JButton("Freistehend");    
        JButton b3 = new JButton("Komplex");    
        JButton b4 = new JButton("Groß"); 

        mazeOptPanel.add(space);mazeOptPanel.add(b1);mazeOptPanel.add(b2);mazeOptPanel.add(b3);mazeOptPanel.add(b4);

        JLabel mpHead = new JLabel("Labyrinth Arten");
        mpHead.setBounds(90,10, 300, 100);
        mpHead.setFont(new Font("Calibri", Font.BOLD, 30));

        mazeOptPanel.setLayout(new GridLayout(5, 1, 20, 0));
        mazeOptPanel.setSize(400,600);

        frame.add(mpHead);
        frame.add(mazeOptPanel);
        
        frame.setLayout(null);
        frame.setSize(2000, 1000);
        frame.setVisible(true);
        
    }

    public void ShowMaze(int[][] m)
    {
        Grid mGraph = new Grid(500, 500, m);
         mGraph.setLayout(null);
         mGraph.setBounds(500, 100, 500, 500);
        frame.add(mGraph);
    }

}
