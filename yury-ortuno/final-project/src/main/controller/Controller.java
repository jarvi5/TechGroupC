package main.controller;

import main.model.Course;
import main.model.Student;
import main.utilities.DoubleLinkedList;
import main.utilities.MultiList;
import main.utilities.MultiNode;
import main.utilities.Node;
import main.view.App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Controller {
    private App view;
    private MultiList<Student, Course> allStudentList;
    private MultiList<Student, Course> studentList;
    private MultiNode studentTmp;
    private Node courseTmp;
    private DefaultTableModel allStudentTable = new DefaultTableModel();
    private DefaultTableModel courseStudentTable = new DefaultTableModel();
    private DoubleLinkedList<Course> tmpCourseList;
    private int resultTmp = 1;

    public Controller(App view) {
        this.view = view;
        allStudentList = new MultiList<>();
        studentList = new MultiList<>();
        String[] title = new String[]{"Id", "Last Name", "First Name"};
        allStudentTable.setColumnIdentifiers(title);
        this.view.getAllStudentTable().setModel(allStudentTable);
        String[] titleCourse = new String[]{"Id", "Subject", "Grade"};
        courseStudentTable.setColumnIdentifiers(titleCourse);
        this.view.getCourseInformationTable().setModel(courseStudentTable);
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
        view.getCEditBtn().addActionListener(e -> editCourses());
        view.getCNextBtn().addActionListener(e -> nextCourse());
        view.getCBeforeBtn().addActionListener(e -> previousCourse());
    }

    private void addStudent() {
        String firstName = view.getFirstNameTxt().getText();
        String lastName = view.getLastNameTxt().getText();
        int rfid = Integer.parseInt(view.getRfidTxt().getText());
        Student student = new Student(rfid, firstName, lastName);
        if (searchByRfid(rfid) == null) {
            allStudentList.addParent(student);
            JOptionPane.showMessageDialog(new JFrame(), "the student was register successful", "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
            clearInformationStudent();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "the student already exists", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
        allStudentTable.addRow(new Object[]{student.getRfid(), student.getLastName(), student.getFirstName()});
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
                    JOptionPane.PLAIN_MESSAGE);
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
            JOptionPane.showMessageDialog(new JFrame(), "the course was register successful", "Dialog",
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

    private void cleanTable(DefaultTableModel table) {
        int rowCount = table.getRowCount();
        for (int row = rowCount - 1; row >= 0; row--) {
            table.removeRow(row);
        }
    }

    private void generateReportGrades() {
        cleanTable(courseStudentTable);
        int row = view.getAllStudentTable().getSelectedRow();
        int rfid = (int) allStudentTable.getValueAt(row, 0);
        Student student = searchByRfid(rfid);
        tmpCourseList = allStudentList.getChildFromParent(student);
        Node<Course> courseNode = tmpCourseList.getHeadNode();
        while (courseNode != null) {
            Course course = courseNode.getNode();
            courseStudentTable.addRow(new Object[]{course.getId(), course.getCourseName(), course.getFinalGrade()});
            courseNode = courseNode.getNext();
        }
    }

    private void editCourses() {
        generateReportGrades();
        int row = view.getAllStudentTable().getSelectedRow();
        int rfid = (int) allStudentTable.getValueAt(row, 0);
        Student student = searchByRfid(rfid);
        tmpCourseList = allStudentList.getChildFromParent(student);
        courseTmp = tmpCourseList.getHeadNode();
        Course course = (Course) courseTmp.getNode();
        view.getCIdTxt().setText(String.valueOf(course.getId()));
        view.getCNameTxt().setText(course.getCourseName());
        view.getCFinalTxt().setText(String.valueOf(course.getFinalGrade()));
    }

    private void nextCourse() {
        if (courseTmp.getNext() != null) {
            courseTmp = courseTmp.getNext();
            Course course = (Course) courseTmp.getNode();
            view.getCIdTxt().setText(String.valueOf(course.getId()));
            view.getCNameTxt().setText(course.getCourseName());
            view.getCFinalTxt().setText(String.valueOf(course.getFinalGrade()));
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Don´t found more course ", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void previousCourse() {
        if (courseTmp.getPrevious() != null) {
            courseTmp = courseTmp.getPrevious();
            Course course = (Course) courseTmp.getNode();
            view.getCIdTxt().setText(String.valueOf(course.getId()));
            view.getCNameTxt().setText(course.getCourseName());
            view.getCFinalTxt().setText(String.valueOf(course.getFinalGrade()));
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Don´t found more course ", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}