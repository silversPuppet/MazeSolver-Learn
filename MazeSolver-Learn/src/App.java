public class App {
    public static void main(String[] args) throws Exception {
        Interface master = new Interface();
        Maze m = new Maze();
        m.Simple();
        master.ShowMaze(m.getMaze());
        System.out.println("Hello, World!");
    }
}
