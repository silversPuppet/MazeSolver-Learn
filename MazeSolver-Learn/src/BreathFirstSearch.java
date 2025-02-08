import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch extends Solver{
    int[][] maze;


    public BreathFirstSearch(int[][] m, Interface in)
    {
        super(m, in);
        gui = in;

        maze = m;
        start = FindStart(m);

        Point p = getPathBFS(start[0],start[1]);

         for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }

        while(p.getParent() != null) {
            gui.addCord(p.getCords());
            p = p.getParent();
        }

        gui.ShowMaze(m);
    }

    private class Point {
        int x;
        int y;
        Point parent;

        public Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }

        public Point getParent() {
            return this.parent;
        }

        public int[] getCords()
        {
            return new int[]{y, x};
        }
  }


    //Visited Points into waiting list
   Queue<Point> q = new LinkedList<Point>();

    public Point getPathBFS(int x, int y) {

        q.add(new Point(x,y, null));

        while(!q.isEmpty()) {
            Point p = q.remove();

            if (maze[p.x][p.y] == 3) {
                return p;
            }

            if(isFree(p.x+1,p.y)) {
                //maze[p.x][p.y] = 0;
                Point nextP = new Point(p.x+1,p.y, p);
                q.add(nextP);
            }

            if(isFree(p.x-1,p.y)) {
                //maze[p.x][p.y] = 0;
                Point nextP = new Point(p.x-1,p.y, p);
                q.add(nextP);
            }

            if(isFree(p.x,p.y+1)) {
                //maze[p.x][p.y] = 0;
                Point nextP = new Point(p.x,p.y+1, p);
                q.add(nextP);
            }

             if(isFree(p.x,p.y-1)) {
                //maze[p.x][p.y] = 0;
                Point nextP = new Point(p.x,p.y-1, p);
                q.add(nextP);
            }

        }
        return null;
    }


    public boolean isFree(int x, int y) {
        if((x >= 0 && x < maze.length) && (y >= 0 && y < maze[0].length) && (maze[x][y] == 0 || maze[x][y] == 3)) {
            return true;
        }
        return false;
    }

}
