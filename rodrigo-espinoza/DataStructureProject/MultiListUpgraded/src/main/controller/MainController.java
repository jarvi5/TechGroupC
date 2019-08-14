package controller;

import model.ManagerStudent;
import view.MainWindows;

public class MainController {
    private ManagerStudent managerStudent;
    private MainWindows mainWindows;


    public MainController(ManagerStudent managerStudent, MainWindows mainWindows) {
        this.managerStudent = new ManagerStudent();
        this.mainWindows = mainWindows;
    }

    public void initController() {
        this.mainWindows.init();
       /* mainWindows.getSaveStudentButton().addActionListener(e -> saveStudent());
        mainWindows.getSearchStudentButton().addActionListener(e -> searchByUser());
        mainWindows.getPreviousStudentButton().addActionListener(e -> previous());
        mainWindows.getNextStudentButton().addActionListener(e -> next());*/
    }

    /*public void initView() {
        mainWindows.getFirstnameTextField().setText("");
        mainWindows.getLastnameTextField().setText("");
    }



    private void showStudent(Student student) {

       mainWindows.getFirstnameTextField().setText(student.getName());
       mainWindows.getLastnameTextField().setText(student.getLastName());
       mainWindows.getRFIDField().setText("" + student.getRFID());
    }

    private void saveStudent(){
        Student student = new Student(mainWindows.getFirstnameTextField().getText(), mainWindows.getLastnameLabel().getText(),
                Integer.parseInt(mainWindows.getRFIDField().getText()));
        showStudent(student);
        managerStudent.addStudent(student);
    }

    private void searchStudent(){
        Student student = new Student(mainWindows.getFirstnameTextField().getText(), mainWindows.getLastnameTextField().getText(),
                Integer.parseInt(mainWindows.getRFIDField().getText()));
        Student studentSerarched = this.managerStudent.searchStudent(student.getName(),student.getLastName()
                ,student.getRFID()); }
    private void previousStudent(){

    }*/
}
