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

        //Zuerst y dann x abspeichern 
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
        // Trifft auf Wand      War Bereits da      Außerhalb des Labyrinths 
        if (maze[y][x] == 1 || wasHere[y][x] == true || x < 0 || y < 0 || x >= maze[0].length || y >= maze.length) {
            return false;
        }

        wasHere[y][x] = true;
        

        //Prüft ob umliegende Felder Frei sind
        //Falls ja -> Tiefensuche beim nächsten Feld
        //Falls nein -> Nächstes Feld überprüfen
        if (x > 0) // Verhindert über (rechten) Rand des Labrinths hinaus zu gehen
        {
            if (recursiveSolve(x - 1, y)) { //Falls ja -> Tiefensuche beim nächsten Feld (links)
                gui.addCord(new int[]{x, y});
                correctPath[y][x] = true;
                return true;
            }
        }
        if (x < maze.length) 
        {
            if (recursiveSolve(x + 1, y)) { // Tiefensuche (rechts)
                gui.addCord(new int[]{x, y});
                correctPath[y][x] = true;
                return true;
            }
        }
        if (y > 0) 
        {
            if (recursiveSolve(x, y - 1)) { // Teifensuche (oben)
                gui.addCord(new int[]{x, y});
                correctPath[y][x] = true;
                return true;
            }
        }
        if (y < maze[0].length) 
        {
            if (recursiveSolve(x, y + 1)) { // Tiefensuche (unten)
                gui.addCord(new int[]{x, y});
                correctPath[y][x] = true;
                return true;
            }
        }
            

        return false;

    }

    
}
