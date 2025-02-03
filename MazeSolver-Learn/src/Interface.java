import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Interface{
    JFrame frame;
    JPanel mazeOptPanel;
    JPanel mazePanel;
    JPanel solveOptPanel;
    int[][] curM;
    Interface gui = this;

    int waitTime;

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
        

        JLabel spHead = new JLabel("Algorithmus Arten");
        spHead.setBounds(1150,10, 300, 100);
        spHead.setFont(new Font("Calibri", Font.BOLD, 30));

        solveOptPanel = new JPanel();

        JLabel space2 = new JLabel("");
        JButton sb1 = new JButton("LinkeHand");    
        sb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                HandOnWall h = new HandOnWall();
                h.Solve(curM, gui);
            }
        });
        JButton sb2 = new JButton("Tremaux");    
        JButton sb3 = new JButton("Rekursiv");    

        solveOptPanel.add(space2);solveOptPanel.add(sb1);solveOptPanel.add(sb2);solveOptPanel.add(sb3);

        solveOptPanel.setLayout(new GridLayout(5, 1, 20, 0));
        solveOptPanel.setSize(400,600);
        solveOptPanel.setLocation(1100, 50);

        frame.add(mpHead);
        frame.add(mazeOptPanel);

        frame.add(spHead);
        frame.add(solveOptPanel);
        
        frame.setLayout(null);
        frame.setSize(2000, 1000);
        frame.setVisible(true);   
    }

    public void ShowMaze(int[][] m)
    {
        curM = m;
        Grid mGraph = new Grid(500, 500, m);
         mGraph.setLayout(null);
         mGraph.setBounds(500, 100, 500, 500);
        frame.add(mGraph);
    }

    public void drawPath(int[][] m, int[] cord)
    {
        Path p = new Path(cord, 500 / m[0].length , 500 / m.length);
        p.setLayout(null);
        p.setBounds(515 + cord[0] * 500 /m[0].length,125 + cord[1] *  500 /m.length, 500 / m[0].length , 500 / m.length);
        frame.add(p, 2, 0);

    }

}
