import controller.Controller;
import model.Model;
import model.UserManager;
import view.View;

public class Main {
    public static void main(String[] arg) {
        View view = new View("MVC USER PROGRAM");
        Model model = new Model("Luis", "Suarez");
        UserManager userManager = new UserManager();
        Controller controller = new Controller(model, userManager, view);
        controller.initController();
    }
}
