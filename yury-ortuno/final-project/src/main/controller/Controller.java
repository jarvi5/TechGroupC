package main.controller;

import main.model.Course;
import main.model.Student;
import main.utilities.DoubleLinkedList;
import main.utilities.MultiList;
import main.utilities.MultiNode;
import main.view.App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Controller {
    private App view;
    private MultiList<Student, Course> allStudentList;
    private MultiList<Student, Course> studentList;
    private MultiNode studentTmp;
    private DefaultTableModel tableModel;
    private int resultTmp = 1;

    public Controller(App view) {
        this.view = view;
        allStudentList = new MultiList<>();
        studentList = new MultiList<>();
        view.getCourseInformationTable().setModel(tableModel);
    }

    public void initController() {
        //section student information
        view.getAddButton().addActionListener(e -> addStudent());
        view.getSearchButton().addActionListener(e -> searchStudentByLastName());
        view.getEditButton().addActionListener(e -> editStudents());
        view.getNextButton().addActionListener(e -> nextStudent());
        view.getBeforeButton().addActionListener(e -> previousStudent());
        view.getAllStudentButton().addActionListener(e -> allStudent());
        view.getViewGradesButton().addActionListener(e -> generateReportGrades());

        //section course of student
        view.getCAddBtn().addActionListener(e -> addCourse());
    }

    private void addStudent() {
        String firstName = view.getFirstNameTxt().getText();
        String lastName = view.getLastNameTxt().getText();
        int rfid = Integer.parseInt(view.getRfidTxt().getText());

        if (searchByRfid(rfid) == null) {
            allStudentList.addParent(new Student(rfid, firstName, lastName));
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
        clearInformationStudent();
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
        } else {
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
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Don´t found more student", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void allStudent() {
        studentList = allStudentList;
        if (studentList.getSize() > 0) {
            studentTmp = studentList.getHeadNode();
            Student student = (Student) studentTmp.getNode();
            view.getFirstNameTxt().setText(student.getFirstName());
            view.getLastNameTxt().setText(student.getLastName());
            view.getRfidTxt().setText(String.valueOf(student.getRfid()));
            view.getStudentResult().setText(String.format("1/%s", studentList.getSize()));
        }
    }


    private void addCourse() {
        int rfidstudent = Integer.parseInt(view.getRfidTxt().getText());
        int idCourse = Integer.parseInt(view.getCIdTxt().getText());
        int gradeCourse = Integer.parseInt(view.getCFinalTxt().getText());
        String courseName = view.getCNameTxt().getText();
        Student student = searchByRfid(rfidstudent);
        if (student != null) {
            allStudentList.addChild(student, new Course(idCourse, courseName, gradeCourse));
            JOptionPane.showMessageDialog(new JFrame(), "the student was register successful", "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
            clearInformationStudent();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "the student does not exists, please first add new " +
                    "srudent", "Dialog", JOptionPane.ERROR_MESSAGE);
        }
        view.getRfidTxt().setText("");
        view.getCIdTxt().setText("");
        view.getCFinalTxt().setText("");
        view.getCNameTxt().setText("");
    }

    private Student searchByRfid(int rifd) {
        MultiNode studentNode = allStudentList.getHeadNode();
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

    private MultiList<Student, Course> searchByLastName(String lastName) {
        MultiNode studentNode = allStudentList.getHeadNode();
        MultiList<Student, Course> searchList = new MultiList<>();
        while (studentNode != null) {
            Student student = (Student) studentNode.getNode();
            if (student.getLastName().contains(lastName)) {
                searchList.addParent(student);
            }
            studentNode = studentNode.getNext();

        }
        resultTmp = 1;
        return searchList;
    }

    private void generateReportGrades() {
        int rfid = Integer.parseInt(view.getRfidTxt().getText());
        Student student = searchByRfid(rfid);
        DoubleLinkedList<Course> courseList = allStudentList.getChildFromParent(student);
        DefaultTableModel tableModel = new DefaultTableModel(courseList.getSize(), 3);
        tableModel = new DefaultTableModel(courseList.getSize(), 3);
        String[] columnNames = { "ID", "Subject", "Grade" };

    }
}