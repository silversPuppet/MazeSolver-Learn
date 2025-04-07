import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;


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


    ArrayList<String> languageStrings;
    boolean languageIsGerman = true;


    public Interface(Maze mContr)
    {
        languageStrings = changeLanguage();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        frame = new JFrame();
        mazeOptPanel = new JPanel();
        mazeContr = mContr;

        JLabel space = new JLabel("");
        JButton b1 = new JButton(languageStrings.get(0));   
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mazeContr.Simple();
                resetMaze();
                ShowMaze(mazeContr.getMaze());
            }
        }); 
        JButton b2 = new JButton(languageStrings.get(1));    
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mazeContr.Freestanding();
                resetMaze();
                ShowMaze(mazeContr.getMaze());
            }
        });
        JButton b3 = new JButton(languageStrings.get(2));    
        b3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
                mazeContr.Komplex();
                resetMaze();
                ShowMaze(mazeContr.getMaze());
            }
        });
        JButton b4 = new JButton(languageStrings.get(3)); 
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
                {
                    mazeContr.Big();
                    resetMaze();
                    ShowMaze(mazeContr.getMaze());
                }
            });

        mazeOptPanel.add(space);mazeOptPanel.add(b1);mazeOptPanel.add(b2);mazeOptPanel.add(b3);mazeOptPanel.add(b4);

        JLabel mpHead = new JLabel(languageStrings.get(4));
        mpHead.setBounds(90,10, 300, 100);
        mpHead.setFont(new Font("Calibri", Font.BOLD, 30));

        mazeOptPanel.setLayout(new GridLayout(5, 1, 20, 0));
        mazeOptPanel.setSize(400,600);
        

        JLabel spHead = new JLabel(languageStrings.get(5));
        spHead.setBounds(1150,10, 300, 100);
        spHead.setFont(new Font("Calibri", Font.BOLD, 30));

        solveOptPanel = new JPanel();

        JLabel space2 = new JLabel("");
        JButton sb1 = new JButton(languageStrings.get(6));    
        sb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                resetMaze();
                curSolver= new HandOnWall(curM, gui);
            }
        });
        JButton sb2 = new JButton(languageStrings.get(7));  
        sb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                resetMaze();
                curSolver = new BreadthFirstSearch(curM, gui);
            }
        });   
        JButton sb3 = new JButton(languageStrings.get(8));  
        sb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                resetMaze();
                curSolver = new DepthfFirstSearch(curM, gui);
            }
        });  

        solveOptPanel.add(space2);solveOptPanel.add(sb1);solveOptPanel.add(sb3);solveOptPanel.add(sb2);

        solveOptPanel.setLayout(new GridLayout(5, 1, 20, 0));
        solveOptPanel.setSize(400,600);
        solveOptPanel.setLocation(1100, 50);


        JPanel mazeContrPanel = new JPanel();

        JLabel delayLabel = new JLabel(languageStrings.get(9));
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


        
        /* 

        JButton languageButton = new JButton(languageStrings.get(10));
        languageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                changeLanguage();
                
            }
        });

        JPanel bottomPanel = new JPanel(new GridLayout(1, 20));
        bottomPanel.setSize(1200, 100);
        bottomPanel.setAlignmentY(0);
        bottomPanel.setLocation(0, 800);
        bottomPanel.add(languageButton);

        frame.add(bottomPanel);
       */

        frame.add(mpHead);
        frame.add(mazeOptPanel);

        frame.add(spHead);
        frame.add(solveOptPanel);

        frame.add(mazeContrPanel);
        
        frame.setLayout(null);
        frame.setSize(dim.width, dim.height);
        frame.setVisible(true);   
    }

    public ArrayList<String> changeLanguage() {
        System.out.println("                METHOD ACTIVE             ");
        languageIsGerman = !languageIsGerman;
        ArrayList<String> languageWords = new ArrayList<String>();
        ArrayList<String> finalWords = new ArrayList<String>();
       
        try{Scanner s = new Scanner(new FileInputStream("MazeSolver-Learn/src/languages.txt"));
        while(s.hasNextLine())
        {
            languageWords.add(s.nextLine());
        }
        
            boolean reachedOtherLanguage = true;
            if (languageIsGerman) {
                
                
                
               for(int i = 0; i<languageWords.size(); i++)
               {

                 if(languageWords.get(i).equals("-e")|| reachedOtherLanguage)
                 {
                    reachedOtherLanguage = true;
                 }
                 else{
                    finalWords.add(languageWords.get(i));
                 }

                 if(languageWords.get(i).equals("-d"))
                 {
                    reachedOtherLanguage = false;
                 } 
                 
               }
               for(String word: finalWords)
               {
                 System.out.println(word);
               }
                
                
            } else {

                for(int i = 0; i<languageWords.size(); i++)
               {

                 if(languageWords.get(i).equals("-d")|| reachedOtherLanguage)
                 {
                    reachedOtherLanguage = true;
                 }
                 else{
                    finalWords.add(languageWords.get(i));
                 }

                 if(languageWords.get(i).equals("-e"))
                 {
                    reachedOtherLanguage = false;
                 } 
                 
               }
               for(String word: finalWords)
               {
                 System.out.println(word);
               }
            }
            s.close();
            return finalWords;
        }
        catch (Exception e)
        {
            System.out.println("Languages File not found :(");
        }

        
        return languageWords;
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
