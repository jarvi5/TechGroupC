package controller;

import model.Student;
import multi_list_library.DoubleLinkedList;
import view.View;

public class Controller {
    private View view;
    private  DoubleLinkedList doblete;
    public Controller(View v) {
        view = v;
        initView();
        doblete = new DoubleLinkedList();
        Student stu = new Student(12,"Acario","Apa");
        Student stu1 = new Student(12,"Bacario","Bapa");
        Student stu2 = new Student(12,"Cacario","Capa");
        doblete.addToBack(stu);
        doblete.addToBack(stu1);
        doblete.addToBack(stu2);
    }

    public void initView() {
    }
    public void initController() {
        view.getNextStudentButton().addActionListener(e -> nextResult());
        view.getPreviousStudentButton().addActionListener(e -> previousResult());
        /*view.getAddButton().addActionListener();
        view.getSearchButton().addActionListener();
        view.getNextButton().addActionListener();
        view.getPreviousButton().addActionListener();*/
    }
    private void nextResult(){
        Student student = (Student) doblete.moveNext().getNode();
        view.getFirstNameTextfield().setText(student.getFirstName());
        view.getLastNameTextfield().setText(student.getLastName());
        view.getRfidTextfield().setText(String.valueOf(student.getRfid()));
    }

    private void previousResult(){
        Student student = (Student) doblete.movePrevious().getNode();
        view.getFirstNameTextfield().setText(student.getFirstName());
        view.getLastNameTextfield().setText(student.getLastName());
        view.getRfidTextfield().setText(String.valueOf(student.getRfid()));
    }

}