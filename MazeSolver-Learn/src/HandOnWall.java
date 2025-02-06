public class HandOnWall extends Solver{


    int numWalks = 0;


    public HandOnWall(int[][] m, Interface i)
    {
        super(m, i);



        gui = i;

        start = FindStart(m);
        //Shows current dirrection you are facing at 
        //          E
        // 0 =  N       S   
        //          W
        // +1 rotates 90 degrees to the left 
        int dir = 0;

        //Check Start
        if (start != null) {
            //TO-DO: Check End

            //Y coordinate then X because of array 
            while (m[start[1]][start[0]] != 3 && numWalks < (m.length * m[0].length) ) {

                //If There isn't a wall to the left of you
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
                    //Rotate right until walkspace available 
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
                gui.addCord(start);
                numWalks++;
            }
            gui.ShowMaze(m);
        }
    }



    //Returns ture if There is a Wall forward
    public boolean isWall(int d, int[][] m, int wallDir)
    {
         //Check Wall Left with wall dir = 0
        //Check Wall Forward with wall dir
        if(d + wallDir > 3 )
        {
            d =  -1 + wallDir;
        }
        else
        {
            d +=  wallDir;
        }

        switch (d) {
            //Facing Down
            case 1:
                //Check for Index Out of Bounds Exception
                if(start[1] + 1 <= m[0].length + 1)
                {
                    return m[start[1] + 1][start[0]] == 1;
                }
                else {
                    return true;
                }
            //facing Right
            case 2:
                if(start[0] + 1 <= m.length + 1)
                {
                    return m[start[1]][start[0] + 1] == 1;
                }
                else {
                    return true;
                }
            //Facing Up
            case 3:
                if(start[1] - 1 >= 0)
                {
                    return m[start[1] - 1][start[0]] == 1;}
                else {
                    return true;
                }
            //Facing left
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
            //When down forward
            case 1:
                start[1]++;
                break;
            //When right Forward
            case 2:
                start[0]++;
                break;
            //When up forward
            case 3:
                start[1]--;
                break;
            //When left forward
            default:
                start[0]--;
                break;
        }
    }

 
}
