public class App {
    public static void main(String[] args) throws Exception {
        Maze m = new Maze();
        Interface master = new Interface(m);
        m.Freestanding();
        master.ShowMaze(m.getMaze());

        System.out.println("Hello, World!");
    }
}
