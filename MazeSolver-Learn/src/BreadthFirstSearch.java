import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Solver {
    int[][] maze;
    boolean[][] wasHere;

    public BreadthFirstSearch(int[][] m, Interface in) {
        super(m, in);
        gui = in;

        maze = m;
        start = FindStart(m);

        wasHere = new boolean[m[0].length][m.length];

        Point p = getPathBFS(start[0], start[1]);

        while (p.getParent() != null) {
            gui.addCord(p.getCords());
            p = p.getParent();
        }
        

        gui.ShowMaze(m);
    }

    //Knoten
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

        public int[] getCords() {
            return new int[] { y, x };
        }
    }

    public Point getPathBFS(int x, int y) {

        //Erstelle Warteschlange 
        Queue<Point> q = new LinkedList<>();
        //Bereits Besuchte Knoten sollen nicht wiederholt besucht werden  
        ArrayList<String> visited = new ArrayList<String>();

        //Start Knoten hinzufügen 
        q.add(new Point(x, y, null));
        visited.add(x + "," + y);

        while (!q.isEmpty()) {
            //Aktuelles Element aus Warteschlange entnehmen 
            Point p = q.remove();

            //Falls Ziel erreicht
            if (maze[p.x][p.y] == 3) {
                return p; 
            }

            int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            //Für jedes element int[] d im array directions 
            //Überprüft umliegende Knoten
            for (int[] d : directions) {
                //Siehe Linke Hand Regel Aktuelle Position + Richtung 
                int newX = p.x + d[0], newY = p.y + d[1];
                if (isFree(newX, newY) && !visited.contains(newX + "," + newY)) {
                    visited.add(newX + "," + newY);
                    //Füge Umliegenden Knoten zur Warteschlange hinzu
                    q.add(new Point(newX, newY, p));
                }
            }
        }
        return null;
    }

    public boolean isFree(int x, int y) {
        //                      Inerhalb des Labyrinths                     Auf freiem Knoten oder Ziel Knoten     
        if ((x > 0 && x < maze.length) && (y > 0 && y < maze[0].length) && (maze[x][y] == 0 || maze[x][y] == 3)) {
            return true;
        }
        return false;
    }

}
