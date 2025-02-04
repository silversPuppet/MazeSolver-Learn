public abstract class Solver {
    int[] start;
    Interface gui;

    public Solver(int[][] m, Interface i)
    {
        gui = i;
    }

    public int[] FindStart(int[][] m)
    {
        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j< m[0].length; j++)
            {
                if(m[i][j] == 2){
                    return new int[]{j, i};
                }
            }
        }
        gui.addCord(start);

        return null;
    }

    
}
