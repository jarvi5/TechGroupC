package org.minions.controller;

import org.minions.utils.DoubleLinkedList;
import org.minions.utils.MultiList;
import org.minions.model.Student;
import org.minions.model.Subject;
import org.minions.view.AddSubjectDialog;
import org.minions.view.SearchAddStudentPanel;
import org.minions.view.StudentInfoPanel;
import org.minions.view.SubjectPanel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {
    private SearchAddStudentPanel addSearchPanel;
    private StudentInfoPanel studentInfoPanel;
    private SubjectPanel subjectPanel;
    private AddSubjectDialog subjectDialog;
    private Student student;
    private MultiList<Student, Subject> studentSubjectList;

    public Controller(SearchAddStudentPanel addSearchPanel, StudentInfoPanel studentInfoPanel, SubjectPanel subjectPanel) {
        this.addSearchPanel = addSearchPanel;
        this.studentInfoPanel = studentInfoPanel;
        this.subjectPanel = subjectPanel;
        this.studentSubjectList = new MultiList<>();
    }

    public void initController() {
        addSearchPanel.getAddButton().addActionListener(e -> addStudent());
        cleanAlertMessage();
        studentInfoPanel.getNextButton().addActionListener(e -> nextStudent());
        studentInfoPanel.getPreviousButton().addActionListener(e -> previousStudent());
        subjectPanel.getSubjectListPanel().getAddSubjectButton().addActionListener(e -> addSubject());
        subjectPanel.getSubjectListPanel().getNextButton().addActionListener(e -> nextSubject());
        subjectPanel.getSubjectListPanel().getPreviousButton().addActionListener(e -> previousSubject());
    }

    private void nextSubject() {
        if (subjectPanel.getSubjectListPanel().getSubjectList().getModel().getSize() > 0) {
            int index = subjectPanel.getSubjectListPanel().getSubjectList().getSelectedIndex();
            Subject currentSubject = subjectPanel.getSubjectListPanel().getSubjectList().getModel().getElementAt(index);
            if (studentSubjectList.getParentNode(student).getChild().getNode(currentSubject).getNext() != null) {
                Subject selectedSubject = (Subject) studentSubjectList.getParentNode(student).getChild().getNode(currentSubject).getNext().getValue();
                subjectPanel.getSubjectListPanel().getSubjectList().setSelectedValue(selectedSubject, true);
                displaySubjectDetail(selectedSubject);
            }
        }
    }

    private void previousSubject() {
        if (subjectPanel.getSubjectListPanel().getSubjectList().getModel().getSize() > 0) {
            int index = subjectPanel.getSubjectListPanel().getSubjectList().getSelectedIndex();
            Subject currentSubject = subjectPanel.getSubjectListPanel().getSubjectList().getModel().getElementAt(index);
            if (studentSubjectList.getParentNode(student).getChild().getNode(currentSubject).getPrevious() != null) {
                Subject selectedSubject = (Subject) studentSubjectList.getParentNode(student).getChild().getNode(currentSubject).getPrevious().getValue();
                subjectPanel.getSubjectListPanel().getSubjectList().setSelectedValue(selectedSubject, true);
                displaySubjectDetail(selectedSubject);
            }
        }
    }

    private void displaySubjectDetail(Subject subject) {
        subjectPanel.getSubjectDetailPanel().getIdInfoLabel().setText(subject.getId());
        subjectPanel.getSubjectDetailPanel().getNameInfoLabel().setText(subject.getName());
        subjectPanel.getSubjectDetailPanel().getFinalGradeInfoLabel().setText(String.valueOf(subject.getFinalNote()));
        subjectPanel.getSubjectDetailPanel().updateUI();

    }

    private void addSubject() {
        subjectDialog = new AddSubjectDialog();
        subjectDialog.getAddButton().addActionListener(e -> {
            String id = subjectDialog.getIdTxt().getText();
            String name = subjectDialog.getNameTxt().getText();
            int finalGrade = Integer.parseInt(subjectDialog.getFinalGradeTxt().getText());
            Subject subject = new Subject(name, id, finalGrade);
            studentSubjectList.addChild(student, subject);
            subjectDialog.dispose();
            updateSubjectContentPanel(subject);
            displaySubjectDetail(subject);
        });
    }

    private void addStudent() {
        if (checkStudentFields()) {
            String name = addSearchPanel.getFirstnameTxt().getText();
            String lastname = addSearchPanel.getLastnameTxt().getText();
            String ci = addSearchPanel.getRfidTxt().getText();
            student = new Student(name, lastname, ci);
            studentSubjectList.insertDataAtEnd(student);

            //Display Student information in the panel
            studentInfoPanel.getRfidInfoLabel().setText(student.getRfid());
            studentInfoPanel.getFirstnameInfo().setText(student.getName());
            studentInfoPanel.getLastnameInfo().setText(student.getLastName());

            //Clean fields
            addSearchPanel.getRfidTxt().setText("");
            addSearchPanel.getFirstnameTxt().setText("");
            addSearchPanel.getLastnameTxt().setText("");

            subjectPanel.getSubjectListPanel().getAddSubjectButton().setEnabled(true);
            subjectPanel.getSubjectListPanel().getSubjectList().setModel(new DefaultListModel<>());

            subjectPanel.getSubjectDetailPanel().getIdInfoLabel().setText("");
            subjectPanel.getSubjectDetailPanel().getFinalGradeInfoLabel().setText("");
            subjectPanel.getSubjectDetailPanel().getNameInfoLabel().setText("");
        }
    }

    private boolean checkStudentFields() {
        boolean checkedFields = true;
        if (addSearchPanel.getFirstnameTxt().getText().isEmpty() && addSearchPanel.getLastnameTxt().getText().isEmpty() && addSearchPanel.getRfidTxt().getText().isEmpty()) {
            addSearchPanel.getCheckRfidLabel().setText("This field should not be empty");
            addSearchPanel.getCheckFirstnameLabel().setText("This field should not be empty");
            addSearchPanel.getCheckLastnameLabel().setText("This field should not be empty");
            checkedFields = false;
        } else if (addSearchPanel.getFirstnameTxt().getText().isEmpty()) {
            addSearchPanel.getCheckFirstnameLabel().setText("This field should not be empty");
            checkedFields = false;
        } else if (addSearchPanel.getLastnameTxt().getText().isEmpty()) {
            addSearchPanel.getCheckLastnameLabel().setText("This field should not be empty");
            checkedFields = false;
        } else if (addSearchPanel.getRfidTxt().getText().isEmpty()) {
            addSearchPanel.getCheckRfidLabel().setText("This field should not be empty");
            checkedFields = false;
        }
        return checkedFields;
    }

    private void addKeyListenerTxt(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                addSearchPanel.getCheckFirstnameLabel().setText("");
                addSearchPanel.getCheckLastnameLabel().setText("");
                addSearchPanel.getCheckRfidLabel().setText("");
            }
        });
    }

    private void cleanAlertMessage() {
        addKeyListenerTxt(addSearchPanel.getRfidTxt());
        addKeyListenerTxt(addSearchPanel.getFirstnameTxt());
        addKeyListenerTxt(addSearchPanel.getLastnameTxt());
    }

    private void nextStudent() {
        Student nextStudent = studentSubjectList.getNextElement(student);
        if (nextStudent != null) {
            studentInfoPanel.getRfidInfoLabel().setText(nextStudent.getRfid());
            studentInfoPanel.getFirstnameInfo().setText(nextStudent.getName());
            studentInfoPanel.getLastnameInfo().setText(nextStudent.getLastName());
            student = nextStudent;
        }
        updateSubjectContentPanel();
    }

    private void previousStudent() {
        Student previousStudent = studentSubjectList.getPreviousElement(student);
        if (previousStudent != null) {
            studentInfoPanel.getRfidInfoLabel().setText(previousStudent.getRfid());
            studentInfoPanel.getFirstnameInfo().setText(previousStudent.getName());
            studentInfoPanel.getLastnameInfo().setText(previousStudent.getLastName());
            student = previousStudent;
        }
        updateSubjectContentPanel();
    }

    private void updateSubjectContentPanel() {
        DoubleLinkedList subjectList = studentSubjectList.getParentNode(student).getChild();
        if (subjectList != null) {
            subjectPanel.getSubjectListPanel().getSubjectList().setModel(subjectList);
            subjectPanel.getSubjectListPanel().getSubjectList().updateUI();
            subjectPanel.getSubjectListPanel().getSubjectList().setSelectedIndex(0);
        }
    }
    private void updateSubjectContentPanel(Subject subject) {
        DoubleLinkedList subjectList = studentSubjectList.getParentNode(student).getChild();
        if (subjectList != null) {
            subjectPanel.getSubjectListPanel().getSubjectList().setModel(subjectList);
            subjectPanel.getSubjectListPanel().getSubjectList().updateUI();
            subjectPanel.getSubjectListPanel().getSubjectList().setSelectedValue(subject, true);;
        }
    }
}