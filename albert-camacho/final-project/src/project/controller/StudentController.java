package project.controller;

import project.model.Student;
import project.model.StudentManager;
import project.view.StudentManagerView;

import java.util.Vector;

public class StudentController {
    private StudentManager studentManager;
    private StudentManagerView studentManagerView;
//    private Student currentStudent;

    public StudentController(StudentManager model, StudentManagerView view) {
        studentManager = model;
        studentManagerView = view;
    }

    public void initController() {
        studentManagerView.getAddStudentButton().addActionListener(e -> addNewStudent());
        studentManagerView.getSearchStudentButton().addActionListener(e -> searchUser());

        studentManagerView.getPreviousStudentButton().addActionListener(e -> {
            studentManager.previousStudent();
            updateProfileView();
        });
        studentManagerView.getNextStudentButton().addActionListener(e -> {
            studentManager.nextStudent();
            updateProfileView();
        });
    }


    private void addNewStudent() {
        String rfId = studentManagerView.getRfIdText();
        String name = studentManagerView.getFirstNameText();
        String lastName = studentManagerView.getLastNameText();

        if (studentManager.addStudent(rfId.trim(), name.trim(), lastName.trim())) {
            studentManagerView.setRfIdText("");
            studentManagerView.setFirstNameText("");
            studentManagerView.setLastNameText("");
            studentManagerView.showDialog("Add Student",
                    String.format("The student '%s %s' was added successfully", name, lastName), "info");
            updateProfileView();
        } else {
            studentManagerView.showDialog("Add Student", "Student couldn't be added", "error");
        }
    }

    private void searchUser() {
        String name = studentManagerView.getFirstNameText();
        String lastName = studentManagerView.getLastNameText();

        Vector<Object> students = studentManager.searchStudentBy(name.toLowerCase(), lastName.toLowerCase());
        if (!students.isEmpty()) {
            displaySearchResult(students);
        } else {
            studentManagerView.showDialog("Student Search", "Student couldn't be found.", "info");
        }
    }

    private void displaySearchResult(Vector<Object> students) {
        studentManagerView.updateStudentDataTable(students);
    }

    private void updateProfileView(){
        Student student = studentManager.getCurrentStudent();
        if (student != null){
            studentManagerView.setRfidLabelText(student.getRfid());
            studentManagerView.setFirstNameLabelText(student.getName());
            studentManagerView.setLastNameLabelText(student.getLastName());
        }
    }

}
