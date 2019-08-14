import controller.MainController;
import model.ManagerStudent;
import view.MainWindows;

public class App {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
       // ContactsModel contactsModel = new ContactsModel();
        ManagerStudent managerStudent = new ManagerStudent();
        MainWindows mainWindows = new MainWindows("MVC aplication");
        MainController controller = new MainController(managerStudent, mainWindows);
        controller.initController();
    }
}
