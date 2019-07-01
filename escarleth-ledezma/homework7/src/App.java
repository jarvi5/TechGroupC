public class App {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        View v = new View("MVC");
        Controller c = new Controller(new UserManager(), v);
        c.initController();
    }
}