public class DepthfFirstSearch extends Solver{
    
    int[][] maze;
    boolean[][] wasHere;
    boolean[][] correctPath;

    public DepthfFirstSearch(int[][] m, Interface in)
    {
        super(m, in);
        gui = in;

        maze = m;
        start = FindStart(m);

        //X Then Y saved
        wasHere = new boolean[m.length][m[0].length];
        correctPath = new boolean[m.length][m[0].length];

        boolean b = recursiveSolve(start[0], start[1]);

        gui.ShowMaze(m);
    }

    public boolean recursiveSolve(int x, int y) {
        // reached end
        if (maze[y][x] == 3) {
            return true;
        }
        // On wall or there before
        if (maze[y][x] == 1 || wasHere[y][x] == true) {
            return false;
        }

        wasHere[y][x] = true;
        if (x > 0) // Checks if not on top edge
        {
            if (recursiveSolve(x - 1, y)) { // Recalls method one up
                gui.addCord(new int[]{x, y});
                correctPath[y][x] = true;
                return true;
            }
        }
        if (x < maze.length) // Checks if not on bottom edge
        {
            if (recursiveSolve(x + 1, y)) { // Recalls method one down
                gui.addCord(new int[]{x, y});
                correctPath[y][x] = true;
                return true;
            }
        }
        if (y > 0) // Checks if not on left edge
        {
            if (recursiveSolve(x, y - 1)) { // Recalls method one to the left
                gui.addCord(new int[]{x, y});
                correctPath[y][x] = true;
                return true;
            }
        }
        if (y < maze[0].length) // Checks if not on right edge
        {
            if (recursiveSolve(x, y + 1)) { // Recalls method one to the right
                gui.addCord(new int[]{x, y});
                correctPath[y][x] = true;
                return true;
            }
        }

        return false;

    }

    
}
