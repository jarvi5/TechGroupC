import controller.UserController;
import model.UserManager;
import view.UserView;

public class App {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        UserManager m = new UserManager();
        UserView v = new UserView("MVC Project - User Manager");
        UserController c = new UserController(m, v);
        c.initController();
    }
}