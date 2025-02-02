public class Maze {
    //0 = path, 1 = wall, 2 = end
    int[][] maze;
    String info;

    public int[][] getMaze()
    {
        return maze;
    }
   
    public void Simple()
    {
        int[][] m = { {1, 2, 1, 1, 1, 1, 1, 1, 1}, 
                        {1, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1, 0, 3},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1}};
        maze = m;
        info = new String("- Keine freistehenden Wände \n- Sackgassen \n- Kreuzungen");
    }
}
