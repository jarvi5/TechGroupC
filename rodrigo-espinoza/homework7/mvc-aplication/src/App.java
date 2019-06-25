import controller.Controller;
import model.PersonModel;
import view.View;

public class App {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        PersonModel m = new PersonModel("","");
        View v = new View("MVC aplication");
        Controller c = new Controller(m, v);
        c.initController();
    }
}