package controller;

import model.ManagerStudent;
import model.Student;
import view.View;

public class Controller {
    private ManagerStudent managerStudent;
    private View view;

    public Controller(ManagerStudent managerStudent, View view) {
        this.managerStudent = managerStudent;
        this.view = view;
    }

    public void initView() {
        view.getFirstnameTextField().setText("");
        view.getLastnameTextField().setText("");
    }

   /* public void initController() {
        view.getSaveStudentButton().addActionListener(e -> saveStudent());
        view.getSearchStudentButton().addActionListener(e -> searchByUser());
        view.getPreviousStudentButton().addActionListener(e -> previous());
        view.getNextStudentButton().addActionListener(e -> next());
    }*/

    private void showStudent(Student student) {

       view.getFirstnameTextField().setText(student.getName());
       view.getLastnameTextField().setText(student.getLastName());
       view.getRFIDField().setText("" + student.getRFID());
    }

    private void saveStudent(){
        Student student = new Student(view.getFirstnameTextField().getText(),view.getLastnameLabel().getText(),
                Integer.parseInt(view.getRFIDField().getText()));
        showStudent(student);
        managerStudent.addStudent(student);
    }

    private void searchStudent(){
        Student student = new Student(view.getFirstnameTextField().getText(), view.getLastnameTextField().getText(),
                Integer.parseInt(view.getRFIDField().getText()));
        Student studentSerarched = this.managerStudent.searchStudent(student.getName(),student.getLastName()
                ,student.getRFID()); }
    private void previousStudent(){

    }
}
