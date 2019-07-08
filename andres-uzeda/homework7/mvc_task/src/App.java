public class App {
    public static void main(String[] args) {
        Model m = new Model("Bob", "Sponge");
        View v = new View("MVC Task");
        Controller c = new Controller(m, v);
        c.initController();
    }
}