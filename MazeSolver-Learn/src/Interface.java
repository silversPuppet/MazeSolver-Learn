import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Interface{
    JFrame frame;
    JPanel mazeOptPanel;
    JPanel mazePanel;
    JPanel solveOptPanel;
    int[][] curM;
    Interface gui = this;

    int speed = 20;
    ArrayList<int[]> cords = new ArrayList<>();

    Maze mazeContr;
    Grid mGraph;
    Solver curSolver;


    public Interface(Maze mContr)
    {
        frame = new JFrame();
        mazeOptPanel = new JPanel();
        mazeContr = mContr;

        JLabel space = new JLabel("");
        JButton b1 = new JButton("Simpel");   
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mazeContr.Simple();
                resetMaze();
                ShowMaze(mazeContr.getMaze());
            }
        }); 
        JButton b2 = new JButton("Freistehend");    
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mazeContr.Freestanding();
                resetMaze();
                ShowMaze(mazeContr.getMaze());
            }
        });
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
                resetMaze();
                curSolver= new HandOnWall(curM, gui);
            }
        });
        JButton sb2 = new JButton("Tremaux");    
        JButton sb3 = new JButton("Rekursiv");    

        solveOptPanel.add(space2);solveOptPanel.add(sb1);solveOptPanel.add(sb2);solveOptPanel.add(sb3);

        solveOptPanel.setLayout(new GridLayout(5, 1, 20, 0));
        solveOptPanel.setSize(400,600);
        solveOptPanel.setLocation(1100, 50);


        JPanel mazeContrPanel = new JPanel();

        JLabel delayLabel = new JLabel("Delay");
        delayLabel.setBounds(400, 0, 500, 20);
        delayLabel.setFont(new Font("Calibri", Font.BOLD, 15));
        JSlider delaySlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 20);
        delaySlider.addChangeListener(new ChangeListener() {
            public void stateChanged( ChangeEvent evt)
            {
                JSlider delay = (JSlider) evt.getSource();
                speed = delay.getValue();
            }
        });
        delaySlider.setPaintLabels(true);
        delaySlider.setMajorTickSpacing(50);
        delaySlider.setBounds(400, 0, 500, 20);


        mazeContrPanel.add(delayLabel);
        mazeContrPanel.add(delaySlider);
        mazeContrPanel.setLayout(new GridLayout(2, 1, 20, 30));
        mazeContrPanel.setSize(500,100);
        mazeContrPanel.setLocation(500, 600);

       

        frame.add(mpHead);
        frame.add(mazeOptPanel);

        frame.add(spHead);
        frame.add(solveOptPanel);

        frame.add(mazeContrPanel);
        
        frame.setLayout(null);
        frame.setSize(2000, 1000);
        frame.setVisible(true);   
    }

    public void ShowMaze(int[][] m)
    {

        curM = m;
         mGraph = new Grid(500, 500, m, cords, speed);
         mGraph.setLayout(null);
         mGraph.setBounds(500, 100, 500, 500);
        frame.add(mGraph);
    }

    public void addCord(int[] cord)
    {
        int[] c = new int[cord.length];
        for(int i = 0; i < cord.length; i++)
        {
            c[i] = cord[i];
        }
        cords.add(c);
    }

    public void resetMaze()
    {
        if(mGraph != null)
        {
            frame.remove(mGraph);
        }
        curSolver = null;
        cords = new ArrayList<int[]>();
        
    }

}
