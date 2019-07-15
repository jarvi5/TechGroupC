import controller.Controller;
import model.ContactsModel;
import model.PersonModel;
import view.View;

public class App {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        ContactsModel contactsModel = new ContactsModel();
        View view = new View("MVC aplication");
        Controller c = new Controller(contactsModel, view);
        c.initController();
    }
}