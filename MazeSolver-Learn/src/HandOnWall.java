public class HandOnWall extends Solver{
    int[] start;
    Interface gui;

    public void Solve(int[][] m, Interface i)
    {
        gui = i;

        start = FindStart(m);
        //start[0] = x start[1] = y
        System.out.println(start[0] + " " + start[1]);

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
            while (m[start[1]][start[0]] != 3) {

                //If There isn't a wall to the left of you
                if(isWall(dir, m, 1) == false)
                {
                    System.out.print("No wall on Left. Rotated from " + dir + " To ");
                    if(dir < 3)
                    {
                        dir++;    
                    }
                    else {
                        dir = 0;
                    }
                    System.out.print(dir + " DIRECTION \n");
                    WalkForward(dir);
                }
                else
                {
                    //Rotate Left until walkspace available 
                    while (isWall(dir, m, 0)) {
                        System.out.println("WALL ");
                        System.out.print("Rotated from " + dir);
                        if(dir < 3)
                        {    
                            dir++;
                        }   
                        else {
                            dir = 0;
                        }
                        System.out.print(" To " + dir + "\n");
                        
                    }
                    WalkForward(dir);
                }   
                gui.addCord(start);
                System.out.println(start[0] + " " + start[1] + " Walked");  
                System.out.println(m[start[1]][start[0]]);  


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

        System.out.print(d + " Direction before wall check \n");

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
