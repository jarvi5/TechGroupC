package ui;

import ui.controller.Controller;
import ui.model.Model;
import ui.model.UserList;
import ui.view.View;

public class Main {
    public static void main(String [] arg){
        View view = new View("MVC USER PROGRAM");
        Model model = new Model("Luis", "Suarez");
        UserList userList = new UserList();
        Controller controller = new Controller(model, userList, view);
        controller.initController();
    }
}
