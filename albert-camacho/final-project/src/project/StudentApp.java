package project;

import project.controller.StudentController;
import project.model.StudentManager;
import project.view.StudentManagerView;

public class StudentApp {
    public static void main(String[] args) {
        StudentManagerView view = new StudentManagerView("Student Manager");
        StudentManager model = new StudentManager();
        StudentController controller = new StudentController(model, view);
        controller.initController();
    }
}
