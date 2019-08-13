package main.controller;

import main.model.Student;
import main.utilities.DoubleLinkedList;
import main.utilities.Node;
import main.view.App;

import javax.swing.*;

public class Controller {
    private App view;
    private DoubleLinkedList<Student> allStudentList;
    private DoubleLinkedList<Student> studentList;
    private Node studentTmp;
    private int resultTmp = 1;

    public Controller(App view) {
        this.view = view;
        allStudentList = new DoubleLinkedList<>();
        studentList = new DoubleLinkedList<>();
    }

    public void initController() {
        view.getAddButton().addActionListener(e -> addStudent());
        view.getSearchButton().addActionListener(e -> searchStudentByLastName());
        view.getEditButton().addActionListener(e -> editStudents());
        view.getNextButton().addActionListener(e -> nextStudent());
        view.getBeforeButton().addActionListener(e -> previousStudent());
        view.getAllStudentButton().addActionListener(e -> allStudent());
    }

    private void addStudent() {
        String firstName = view.getFirstNameTxt().getText();
        String lastName = view.getLastNameTxt().getText();
        int rfid = Integer.parseInt(view.getRfidTxt().getText());

        if (searchByRfid(rfid) == null) {
            allStudentList.addToBack(new Student(rfid, firstName, lastName));
            JOptionPane.showMessageDialog(new JFrame(), "the student was register successful", "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
            clearInformationStudent();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "the student already exists", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearInformationStudent() {
        view.getFirstNameTxt().setText("");
        view.getLastNameTxt().setText("");
        view.getRfidTxt().setText("");
    }

    private void searchStudentByLastName() {
        String search = view.getSearchStudentTxt().getText();
        studentList = searchByLastName(search);
        if (studentList.getSize() > 0) {
            JOptionPane.showMessageDialog(new JFrame(), String.format("Found %s students", studentList.getSize()),
                    "Dialog", JOptionPane.ERROR_MESSAGE);
            view.getStudentResult().setText(String.format("0/%s", studentList.getSize()));
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Not found any students", "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        view.getSearchStudentTxt().setText("");
    }

    private void editStudents() {
        if (studentList.getSize() > 0) {
            studentTmp = studentList.getHeadNode();
            Student student = (Student) studentTmp.getNode();
            view.getFirstNameTxt().setText(student.getFirstName());
            view.getLastNameTxt().setText(student.getLastName());
            view.getRfidTxt().setText(String.valueOf(student.getRfid()));
            view.getStudentResult().setText(String.format("1/%s", studentList.getSize()));
        }
    }

    private void nextStudent() {
        if (resultTmp < studentList.getSize()) {
            Student student = (Student) studentTmp.getNext().getNode();
            view.getFirstNameTxt().setText(student.getFirstName());
            view.getLastNameTxt().setText(student.getLastName());
            view.getRfidTxt().setText(String.valueOf(student.getRfid()));
            view.getStudentResult().setText(String.format("%s/%s", ++resultTmp, studentList.getSize()));
            studentTmp = studentTmp.getNext();
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Don´t found more student", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void previousStudent() {
        if (resultTmp > 1) {
            Student student = (Student) studentTmp.getPrevious().getNode();
            view.getFirstNameTxt().setText(student.getFirstName());
            view.getLastNameTxt().setText(student.getLastName());
            view.getRfidTxt().setText(String.valueOf(student.getRfid()));
            view.getStudentResult().setText(String.format("%s/%s", --resultTmp, studentList.getSize()));
            studentTmp = studentTmp.getPrevious();
        }else {
            JOptionPane.showMessageDialog(new JFrame(), "Don´t found more student", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void allStudent(){
        studentList = allStudentList;
    }

    private Student searchByRfid(int rifd) {
        Node studentNode = allStudentList.getHeadNode();
        while (studentNode != null) {
            Student student = (Student) studentNode.getNode();
            if (student.getRfid() == rifd) {
                return student;
            } else {
                studentNode = studentNode.getNext();
            }
        }
        return null;
    }

    private DoubleLinkedList<Student> searchByLastName(String lastName) {
        Node studentNode = allStudentList.getHeadNode();
        DoubleLinkedList<Student> searchList = new DoubleLinkedList<>();
        while (studentNode != null) {
            Student student = (Student) studentNode.getNode();
            if (student.getLastName().contains(lastName)) {
                searchList.addToBack(student);
            }
            studentNode = studentNode.getNext();

        }
        resultTmp = 1;
        return searchList;
    }

}