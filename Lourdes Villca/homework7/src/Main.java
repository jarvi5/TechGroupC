import controller.Controller;
import view.MainView;
import view.SearchPanel;
import model.Person;

public class Main{
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        Person person = new Person("Sylvain", "Saurel");
        MainView main = new MainView();

    }
}
