public class Maze {
    //0 = path, 1 = wall, 2 = end
    int[][] maze;
    int[] start = {0, 0};
    String info;

    public int[][] getMaze()
    {
        return maze;
    }
   
    public void leftHandMaze()
    {
        maze = new int[][]{ {0, 1, 0, 0, 0, 1, 0, 1}, 
                            {0, 1, 0, 1, 0, 1, 0, 1},
                            {0, 1, 0, 1, 1, 1, 0, 1},
                            {0, 1, 0, 0, 0, 0, 0, 1},
                            {0, 1, 1, 1, 0, 1, 0, 1},
                            {0, 0, 0, 0, 0, 1, 0, 2},
                            {1, 1, 1, 1, 1, 1, 1, 1,}};
        info = new String("- Keine freistehenden Wände \n- Sackgassen \n- Kreuzungen");
    }
}
