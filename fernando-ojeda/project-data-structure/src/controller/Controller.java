package ui2.controller;

import ui2.model.DoubleLinkedList;
import ui2.model.Student;
import ui2.model.Subject;
import ui2.view.ViewManager;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Controller {
    private DoubleLinkedList list;
    private ViewManager view;
    private List<Student> studentsList;
    private List<Subject> subjectList;

    public Controller(DoubleLinkedList list, ViewManager view) {
        this.setList(list);
        this.setView(view);
        setStudentsList(new LinkedList<>());
        subjectList = new LinkedList<>();
    }

    public void initController() {
        getView().getUserPanel().getSaveButton().addActionListener(e -> saveUser());
        getView().getUserPanel().getSearchButton().addActionListener(e -> searchUser());
        getView().getUserPanel().getNextButton().addActionListener(e -> nextUser());
        getView().getUserPanel().getPreviousButton().addActionListener(e -> previousUser());

        getView().getSubjectPanel().getSaveButton().addActionListener(e -> saveSubject());
        getView().getSubjectPanel().getSearchButton().addActionListener(e -> searchSubject());
        getView().getSubjectPanel().getNextButton().addActionListener(e -> nextSubject());
        getView().getSubjectPanel().getPreviousButton().addActionListener(e -> previousSubject());
    }

    private void saveUser() {
        Student student = new Student(Integer.parseInt(getView().getUserPanel().getIdTextField().getText()),
                getView().getUserPanel().getFirstnameTextField().getText(),
                getView().getUserPanel().getLastnameTextField().getText());
        getList().add(student);
        this.getStudentsList().add(student);
        viewSaveUser(student.getId(), student.getName(), student.getLastname());
        showMessageUserSave(student);
        clearFields(getView().getUserPanel().getIdTextField(), "", getView().getUserPanel().getFirstnameTextField(),
                "", getView().getUserPanel().getLastnameTextField(), "");
    }

    public void searchUser() {
        Student studentData = null;
        int id = Integer.parseInt(getView().getUserPanel().getIdTextField().getText());
        for (Student student : this.getStudentsList()) {
            if (id == student.getId()) {
                studentData = student;
                break;
            }
        }

        Student student1 = (Student) getList().search(studentData);

        if (student1 != null) {
            viewSaveUser(student1.getId(), student1.getName(), student1.getLastname());
        } else {
            JOptionPane.showMessageDialog(null, "The student was not found", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        clearFields(getView().getUserPanel().getIdTextField(), "", getView().getUserPanel().getFirstnameTextField(),
                "", getView().getUserPanel().getLastnameTextField(), "");
    }

    private void previousUser() {
        Student studentData = null;
        studentData = getStudent(studentData);

        Student student1 = (Student) getList().previous(studentData);

        if (student1 != null) {
            viewSaveUser(student1.getId(), student1.getName(), student1.getLastname());
        } else {
            showMessageSubjectSave("The student: ", getView().getUserPanel().getFirstnameTextField().getText(),
                    " has not a previous student");
        }
    }

    private void nextUser() {
        Student studentData = null;
        studentData = getStudent(studentData);

        Student student1 = (Student) getList().next(studentData);

        if (student1 != null) {
            viewSaveUser(student1.getId(), student1.getName(), student1.getLastname());
        } else {
            showMessageSubjectSave("The student: ", getView().getUserPanel().getFirstnameTextField().getText(),
                    " has not a next student");
        }
    }

    private void saveSubject() {
        Student studentData = null;

        studentData = getStudent(studentData);

        Subject subject = new Subject(Integer.parseInt(getView().getSubjectPanel().getIdTextField().
                getText()), getView().getSubjectPanel().getNameTextField().getText(),
                Integer.parseInt(getView().getSubjectPanel().getNoteTextField().getText()));

        getList().addChild(studentData, subject);

        this.subjectList.add(subject);

        viewSaveSubject(subject.getName(), subject.getId(), subject.getNote());

        showMessageSubjectSave("The subject: ", subject.getName(), "was saved successfully");

        clearFields(getView().getSubjectPanel().getNameTextField(), "", getView().getSubjectPanel().getIdTextField(),
                "", getView().getSubjectPanel().getNoteTextField(), "");
    }

    private void searchSubject() {
        Student studentData = null;
        Subject subjectData = null;

        studentData = getStudent(studentData);

        subjectData = getSubject(subjectData);

        Subject subject1 = (Subject) getList().searchChild(studentData, subjectData);

        viewSaveSubject(subject1);

        clearFields(getView().getSubjectPanel().getNameTextField(), "", getView().getSubjectPanel().getIdTextField(),
                "", getView().getSubjectPanel().getNoteTextField(), "");
    }

    private void previousSubject() {
        Student studentData = null;
        Subject subjectData = null;

        studentData = getStudent(studentData);

        subjectData = getSubject(subjectData);

        Subject subject = (Subject) getList().previousChild(studentData, subjectData);

        viewSaveSubject(subject);
    }

    private void nextSubject() {
        Student studentData = null;
        Subject subjectData = null;

        studentData = getStudent(studentData);

        subjectData = getSubject(subjectData);

        Subject subject = (Subject) getList().nextChild(studentData, subjectData);

        viewSaveSubject(subject);
    }

    private void viewSaveSubject(Subject subject) {
        if (subject != null) {
            viewSaveSubject(subject.getName(), subject.getId(), subject.getNote());
        } else {
            showMessageSubjectSave("The subject: ", getView().getSubjectPanel().getNameTextFieldDetail().getText(),
                    " has not a next subject");
        }
    }

    private Subject getSubject(Subject subjectData) {
        String name = getView().getSubjectPanel().getNameTextFieldDetail().getText();
        int idSubject = Integer.parseInt(getView().getSubjectPanel().getIdTextFieldDetail().getText());
        int note = Integer.parseInt(getView().getSubjectPanel().getNoteTextFieldDetail().getText());
        for (Subject subject : this.subjectList) {
            if (name.equals(subject.getName()) && idSubject == subject.getId() && note == subject.getNote()) {
                subjectData = subject;
                break;
            }
        }
        return subjectData;
    }

    private Student getStudent(Student studentData) {
        int id = Integer.parseInt(getView().getUserPanel().getIdTextFieldDetail().getText());
        String firstname = getView().getUserPanel().getFirstnameTextFieldDetail().getText();
        String lastname = getView().getUserPanel().getLastnameTextFieldDetail().getText();
        for (Student student : this.getStudentsList()) {
            if (id == student.getId() && firstname.equals(student.getName()) && lastname.equals(student.getLastname())) {
                studentData = student;
                break;
            }
        }
        return studentData;
    }

    private void clearFields(JTextField nameTextField, String s, JTextField idTextField, String s2,
                             JTextField noteTextField, String s3) {
        nameTextField.setText(s);
        idTextField.setText(s2);
        noteTextField.setText(s3);
    }

    private void showMessageSubjectSave(String s, String name, String s2) {
        JOptionPane.showMessageDialog(null, s + name +
                s2, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewSaveSubject(String name, int id, int note) {
        clearFields(getView().getSubjectPanel().getNameTextFieldDetail(), name, getView().getSubjectPanel().
                getIdTextFieldDetail(), String.valueOf(id), getView().getSubjectPanel().getNoteTextFieldDetail(),
                String.valueOf(note));
    }

    private void showMessageUserSave(Student student) {
        JOptionPane.showMessageDialog(null, "The user: " + student.getName() + " " +
                student.getLastname() + " was saved successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewSaveUser(int id, String firstname, String lastname) {
        clearFields(getView().getUserPanel().getIdTextFieldDetail(), String.valueOf(id), getView().getUserPanel().
                getFirstnameTextFieldDetail(), firstname, getView().getUserPanel().getLastnameTextFieldDetail(),
                lastname);
    }

    public DoubleLinkedList getList() {
        return list;
    }

    public void setList(DoubleLinkedList list) {
        this.list = list;
    }

    public ViewManager getView() {
        return view;
    }

    public void setView(ViewManager view) {
        this.view = view;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
