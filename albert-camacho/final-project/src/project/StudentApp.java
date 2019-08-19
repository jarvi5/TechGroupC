package project;

import project.controller.MainController;
import project.model.StudentManager;
import project.view.MainView;

public class StudentApp {
    public static void main(String[] args) {
        MainView view = new MainView("Student Manager");
        StudentManager model = new StudentManager();
        MainController controller = new MainController(model, view);
        controller.initController();
    }
}
