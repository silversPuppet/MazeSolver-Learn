public class HandOnWall extends Solver{


    int numWalks = 0;


    public HandOnWall(int[][] m, Interface i)
    {
        super(m, i);
        gui = i;

        start = FindStart(m);
        //Dir Zeigt aktuelle Richtung an
        //          O
        // 0 =  N       S   
        //          W
        // +1 dreht 90 Grad nach links 
        int dir = 0;
        
            //     Falls Ziel nicht erreicht     Falls gegangene Schritte nicht zu groß (Falls Lösung nicht auffindbar)
            while (m[start[1]][start[0]] != 3 && numWalks < (m.length * m[0].length) ) {

                //Falls keine Wand links vorhanden ist 
                if(isWall(dir, m, 1) == false)
                {
                    if(dir < 3)
                    {
                        dir++;    
                    }
                    else {
                        dir = 0;
                    }
                    WalkForward(dir);
                }
                else
                {
                    //Drehe dich nach rechts bis keine Wand vorne vorhanden ist
                    while (isWall(dir, m, 0)) {

                        if(dir > 0)
                        {    
                            dir--;
                        }   
                        else {
                            dir = 3;
                        }
                    }
                    WalkForward(dir);
                }   
                //Fügt gegangen Schritt zum GUI hinzu
                gui.addCord(start);
                numWalks++;
            }
        gui.ShowMaze(m);
        
    }



    //Returns true if There is a Wall forward
    public boolean isWall(int d, int[][] m, int wallDir)
    {
        //new Dir hat werte von 0 bis 4 
        int newDir = (d + wallDir) % 4;
        

        switch (newDir) {
            //Unten
            case 1:
                //Verhindert Index Out of Bounds Exception
                if(start[1] + 1 < m.length + 1)
                {
                    return m[start[1] + 1][start[0]] == 1;
                }
                else {
                    return true;
                }
            //Rechts
            case 2:
                if(start[0] + 1 < m[0].length + 1)
                {
                    return m[start[1]][start[0] + 1] == 1;
                }
                else {
                    return true;
                }
            //Oben
            case 3:
                if(start[1] - 1 >= 0)
                {
                    return m[start[1] - 1][start[0]] == 1;}
                else {
                    return true;
                }
            //Links
            default:
                if(start[0] - 1 >= 0)
                {
                    return m[start[1]][start[0] - 1] == 1;
                }
                else {
                    return true;
                }
        }
    }

    public void WalkForward(int d)
    {
        switch (d) {
            //Wenn Unten = Vorne
            case 1:
                start[1]++;
                break;
            //Wenn Oben = Vorne
            case 2:
                start[0]++;
                break;
            //Wenn Rechts = Vorne
            case 3:
                start[1]--;
                break;
            //Wenn Links = Vorne
            default:
                start[0]--;
                break;
        }
    }

 
}
