package org.minions.controller;

import org.minions.utils.DoubleLinkedList;
import org.minions.utils.MultiList;
import org.minions.model.Student;
import org.minions.model.Subject;
import org.minions.utils.Node;
import org.minions.utils.NumericInputVerifier;
import org.minions.view.AddSubjectDialog;
import org.minions.view.SearchAddStudentPanel;
import org.minions.view.StudentInfoPanel;
import org.minions.view.SubjectPanel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Method that manage flow communication between the view and model
 */
public class Controller {
    private SearchAddStudentPanel addSearchPanel;
    private StudentInfoPanel studentInfoPanel;
    private SubjectPanel subjectPanel;
    private AddSubjectDialog subjectDialog;
    private Student student;
    private MultiList<Student, Subject> studentSubjectList;

    /**
     * Consctructor that Initialize the attributes.
     *
     * @param addSearchPanel   Panel that have the add and search Student.
     * @param studentInfoPanel Panel that Display the Student Information.
     * @param subjectPanel     Panel that display all the Subject Information.
     */
    public Controller(SearchAddStudentPanel addSearchPanel, StudentInfoPanel studentInfoPanel, SubjectPanel subjectPanel) {
        this.addSearchPanel = addSearchPanel;
        this.studentInfoPanel = studentInfoPanel;
        this.subjectPanel = subjectPanel;
        this.studentSubjectList = new MultiList<>();
    }

    /**
     * Method that initialize the controller, add events to all components.
     */
    public void initController() {
        addSearchPanel.getAddButton().addActionListener(e -> addStudent());
        addEventCleanValidationMessage();
        studentInfoPanel.getNextButton().addActionListener(e -> nextStudent());
        studentInfoPanel.getPreviousButton().addActionListener(e -> previousStudent());
        subjectPanel.getSubjectListPanel().getAddSubjectButton().addActionListener(e -> addSubject());
        subjectPanel.getSubjectListPanel().getNextButton().addActionListener(e -> nextSubject());
        subjectPanel.getSubjectListPanel().getPreviousButton().addActionListener(e -> previousSubject());
        addSearchPanel.getSearchButton().addActionListener(e -> searchStudent());
    }

    /**
     * Method that search a student given any of its attributes.
     */
    private void searchStudent() {
        cleanValidationMessage();
        String name = addSearchPanel.getFirstnameTxt().getText();
        String lastname = addSearchPanel.getLastnameTxt().getText();
        String rfid = addSearchPanel.getRfidTxt().getText();
        for (int i = 0; i < studentSubjectList.getSize(); i++) {
            student = (Student) studentSubjectList.getElementAt(i);
            if (!name.isEmpty() && student.getName().equals(name) ||
                    !lastname.isEmpty() && student.getLastName().equals(lastname) ||
                    !rfid.isEmpty() && student.getRfid().equals(rfid)) {
                updateStudentInfoPanel();
                updateSubjectListContentPanel();
                return;
            }
        }
        JOptionPane.showMessageDialog(addSearchPanel, "Student Not found", "Alert", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Method that navigate through the Subject List and go to the next element from the current selected Subject.
     */
    private void nextSubject() {
        if (subjectPanel.getSubjectListPanel().getSubjectList().getModel().getSize() > 0) {
            int index = subjectPanel.getSubjectListPanel().getSubjectList().getSelectedIndex();
            Subject currentSubject = subjectPanel.getSubjectListPanel().getSubjectList().getModel().getElementAt(index);
            if (studentSubjectList.getNode(student).getChild().getNode(currentSubject).getNext() != null) {
                Subject selectedSubject = (Subject) studentSubjectList.getNode(student).getChild().getNode(currentSubject).getNext().getValue();
                subjectPanel.getSubjectListPanel().getSubjectList().setSelectedValue(selectedSubject, true);
                displaySubjectDetail(selectedSubject);
            }
        }
    }

    /**
     * Method that navigate through the Subject List and go to the previous element from the current selected Subject.
     */
    private void previousSubject() {
        if (subjectPanel.getSubjectListPanel().getSubjectList().getModel().getSize() > 0) {
            int index = subjectPanel.getSubjectListPanel().getSubjectList().getSelectedIndex();
            Subject currentSubject = subjectPanel.getSubjectListPanel().getSubjectList().getModel().getElementAt(index);
            if (studentSubjectList.getNode(student).getChild().getNode(currentSubject).getPrevious() != null) {
                Subject selectedSubject = (Subject) studentSubjectList.getNode(student).getChild().getNode(currentSubject).getPrevious().getValue();
                subjectPanel.getSubjectListPanel().getSubjectList().setSelectedValue(selectedSubject, true);
                displaySubjectDetail(selectedSubject);
            }
        }
    }

    /**
     * Method that display the Subject Detail on the UI  given the Subject Object.
     *
     * @param subject Subject Object Information.
     */
    private void displaySubjectDetail(Subject subject) {
        subjectPanel.getSubjectDetailPanel().getIdInfoLabel().setText(subject.getId());
        subjectPanel.getSubjectDetailPanel().getNameInfoLabel().setText(subject.getName());
        subjectPanel.getSubjectDetailPanel().getFinalGradeInfoLabel().setText(String.valueOf(subject.getFinalNote()));
        subjectPanel.getSubjectDetailPanel().updateUI();
    }

    /**
     * Method that add subject to the linked list.
     */
    private void addSubject() {
        subjectDialog = new AddSubjectDialog();
        subjectDialog.getAddButton().addActionListener(e -> {
            if (checkSubjectFields()) {
                String id = subjectDialog.getIdTxt().getText();
                String name = subjectDialog.getNameTxt().getText();
                String finalGrade = subjectDialog.getFinalGradeTxt().getText();
                Subject subject = new Subject(name, id, Double.parseDouble(finalGrade));
                studentSubjectList.addChild(student, subject);
                subjectDialog.dispose();
                //update the subject information detail
                updateSubjectInfoContentPanel(subject);
                displaySubjectDetail(subject);
            }
        });
        addListenerCleanValidationMessage();
        subjectDialog.getCancelButton().addActionListener(e -> {
            subjectDialog.dispose();
        });
    }

    /**
     * Method that add student in the linked list
     */
    private void addStudent() {
        if (checkStudentFields()) {
            String name = addSearchPanel.getFirstnameTxt().getText();
            String lastname = addSearchPanel.getLastnameTxt().getText();
            String ci = addSearchPanel.getRfidTxt().getText();
            student = new Student(name, lastname, ci);
            studentSubjectList.insertElementAtEnd(student);

            //Display Student information in the panel
            updateStudentInfoPanel();

            //Clean fields
            addSearchPanel.getRfidTxt().setText("");
            addSearchPanel.getFirstnameTxt().setText("");
            addSearchPanel.getLastnameTxt().setText("");

            //enable the Add Subject Button
            subjectPanel.getSubjectListPanel().getAddSubjectButton().setEnabled(true);
            subjectPanel.getSubjectListPanel().getSubjectList().setModel(new DefaultListModel<>());

            // Clean set input from the text fields
            subjectPanel.getSubjectDetailPanel().getIdInfoLabel().setText("");
            subjectPanel.getSubjectDetailPanel().getFinalGradeInfoLabel().setText("");
            subjectPanel.getSubjectDetailPanel().getNameInfoLabel().setText("");
        }
    }

    /**
     * Method that update the Student Detail information in the Panel.
     */
    private void updateStudentInfoPanel() {
        studentInfoPanel.getRfidInfoLabel().setText(student.getRfid());
        studentInfoPanel.getFirstnameInfo().setText(student.getName());
        studentInfoPanel.getLastnameInfo().setText(student.getLastName());
    }

    /**
     * Method that check the student information fields.
     *
     * @return a boolean True if all fields are right, otherwise false.
     */
    private boolean checkStudentFields() {
        boolean checkFirstName = checkEmptyField(addSearchPanel.getFirstnameTxt(), addSearchPanel.getCheckFirstnameLabel());
        boolean checkLastName = checkEmptyField(addSearchPanel.getLastnameTxt(), addSearchPanel.getCheckLastnameLabel());
        boolean checkRfid = checkEmptyField(addSearchPanel.getRfidTxt(), addSearchPanel.getCheckRfidLabel());
        return checkFirstName && checkLastName && checkRfid;
    }

    /**
     * Method that check the Subject field information is set.
     *
     * @return a boolean True if all fields are right, otherwise false.
     */
    private boolean checkSubjectFields() {
        boolean checkedFields = true;
        NumericInputVerifier inputVerifier = new NumericInputVerifier();
        if (!inputVerifier.verify(subjectDialog.getFinalGradeTxt())) {
            subjectDialog.getCheckFinalGradeLabel().setText("Insert a valid Numeric field");
            checkedFields = false;
        }
        boolean checkId = checkEmptyField(subjectDialog.getIdTxt(), subjectDialog.getCheckIdLabel());
        boolean checkName = checkEmptyField(subjectDialog.getNameTxt(), subjectDialog.getCheckNameLabel());
        boolean checkFinalGrade = checkEmptyField(subjectDialog.getFinalGradeTxt(), subjectDialog.getCheckFinalGradeLabel());
        return checkId && checkName && checkFinalGrade && checkedFields;
    }

    /**
     * Method that check if a text field is empty and displays the validation error message.
     *
     * @param textField  Text Field component.
     * @param checklabel Label Component that represents the validation label
     * @return a boolean True if the text field is not empty, False otherwise.
     */
    private boolean checkEmptyField(JTextField textField, JLabel checklabel) {
        boolean checkedFields = true;
        if (textField.getText().isEmpty()) {
            checklabel.setText("This field should not be empty");
            checkedFields = false;
        }
        return checkedFields;
    }

    /**
     * Method that implement the  key listener for a given text field Component.
     *
     * @param textField text field component.
     */
    private void addKeyListenerTxtStudent(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                cleanValidationMessage();
            }
        });
    }

    /**
     * Method that add key listener event to all text fields of the Student Panel.
     */
    private void addEventCleanValidationMessage() {
        addKeyListenerTxtStudent(addSearchPanel.getRfidTxt());
        addKeyListenerTxtStudent(addSearchPanel.getFirstnameTxt());
        addKeyListenerTxtStudent(addSearchPanel.getLastnameTxt());
    }

    /**
     * Method that implement the  key listener for a given text field Component for Subject fields.
     *
     * @param textField textField text field component.
     */
    private void addKeyListenerTxtSubject(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                subjectDialog.getCheckIdLabel().setText("");
                subjectDialog.getCheckNameLabel().setText("");
                subjectDialog.getCheckFinalGradeLabel().setText("");
            }
        });
    }

    /**
     * Method that Clean the validation messages for Student fields
     */
    private void cleanValidationMessage() {
        addSearchPanel.getCheckFirstnameLabel().setText("");
        addSearchPanel.getCheckLastnameLabel().setText("");
        addSearchPanel.getCheckRfidLabel().setText("");
    }

    /**
     * Method that add key listener event to all text fields of the Subject Dialog.
     */
    private void addListenerCleanValidationMessage() {
        addKeyListenerTxtSubject(subjectDialog.getIdTxt());
        addKeyListenerTxtSubject(subjectDialog.getNameTxt());
        addKeyListenerTxtSubject(subjectDialog.getFinalGradeTxt());
    }

    /**
     * Method that go to the next element of the current Student.
     */
    private void nextStudent() {
        if (studentSubjectList.getSize() > 0) {
            Node<Student> nextStudent = studentSubjectList.getNode(student);
            if (nextStudent.getNext() != null) {
                studentInfoPanel.getRfidInfoLabel().setText(nextStudent.getNext().getValue().getRfid());
                studentInfoPanel.getFirstnameInfo().setText(nextStudent.getNext().getValue().getName());
                studentInfoPanel.getLastnameInfo().setText(nextStudent.getNext().getValue().getLastName());
                student = nextStudent.getNext().getValue();
                updateSubjectListContentPanel();
            }
        }
    }

    /**
     * Method that go to the previous element of the current student.
     */
    private void previousStudent() {
        if (studentSubjectList.getSize() > 0) {
            Node<Student> studentNode = studentSubjectList.getNode(student);
            if (studentNode.getPrevious() != null) {
                studentInfoPanel.getRfidInfoLabel().setText(studentNode.getPrevious().getValue().getRfid());
                studentInfoPanel.getFirstnameInfo().setText(studentNode.getPrevious().getValue().getName());
                studentInfoPanel.getLastnameInfo().setText(studentNode.getPrevious().getValue().getLastName());
                student = studentNode.getPrevious().getValue();
                updateSubjectListContentPanel();
            }
        }
    }

    /**
     * Method that update the Subject List in the UI.
     */
    private void updateSubjectListContentPanel() {
        DoubleLinkedList subjectList = studentSubjectList.getNode(student).getChild();
        if (subjectList != null) {
            subjectPanel.getSubjectListPanel().getSubjectList().setModel(subjectList);
            subjectPanel.getSubjectListPanel().getSubjectList().updateUI();
            subjectPanel.getSubjectListPanel().getSubjectList().setSelectedIndex(0);
            displaySubjectDetail((Subject) subjectList.getElementAtIndex(0));
        } else {
            subjectPanel.getSubjectListPanel().getSubjectList().setModel(new DefaultListModel<>());
            cleanSubjectDetail();
        }
    }

    /**
     * Method that clean the Subject Detail Information.
     */
    private void cleanSubjectDetail() {
        subjectPanel.getSubjectDetailPanel().getIdInfoLabel().setText("");
        subjectPanel.getSubjectDetailPanel().getNameInfoLabel().setText("");
        subjectPanel.getSubjectDetailPanel().getFinalGradeInfoLabel().setText("");
        subjectPanel.getSubjectDetailPanel().updateUI();
    }

    /**
     * Method that update the Subject Detail Information.
     *
     * @param subject Subject Object.
     */
    private void updateSubjectInfoContentPanel(Subject subject) {
        DoubleLinkedList subjectList = studentSubjectList.getNode(student).getChild();
        if (subjectList != null) {
            subjectPanel.getSubjectListPanel().getSubjectList().setModel(subjectList);
            subjectPanel.getSubjectListPanel().getSubjectList().updateUI();
            subjectPanel.getSubjectListPanel().getSubjectList().setSelectedValue(subject, true);
            displaySubjectDetail((Subject) subjectList.getElementAtIndex(0));
        }
    }
}
