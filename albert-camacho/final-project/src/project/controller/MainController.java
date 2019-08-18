package project.controller;

import project.model.SubjectManager;
import project.model.datatype.Student;
import project.model.StudentManager;
import project.model.datatype.Subject;
import project.view.MainView;

import javax.swing.*;
import java.util.Vector;

public class MainController {
    private StudentManager studentManager;
    private MainView mainView;
    private SubjectManager subjectManager;

    public MainController(StudentManager model, MainView view) {
        studentManager = model;
        mainView = view;
        subjectManager = new SubjectManager();
        studentManager.addObserver(subjectManager);
    }

    public void initController() {
        mainView.getAddStudentButton().addActionListener(e -> {
            addNewStudent();
            updateSubjectView();
            mainView.updateStudentDataTable(studentManager.getDataModel());
        });

//        mainView.getSearchStudentButton().addActionListener(e -> searchUser());

        mainView.getNextStudentButton().addActionListener(e -> {
            studentManager.nextStudent();
            updateProfileView();
            updateSubjectView();
        });

        mainView.getPreviousStudentButton().addActionListener(e -> {
            studentManager.previousStudent();
            updateProfileView();
            updateSubjectView();
        });

        mainView.getAddSubjectButton().addActionListener(e -> addNewSubject());
        mainView.getSaveSubjectButton().addActionListener(e -> saveSubject());

        mainView.getNextSubjectButton().addActionListener(e -> {
            int idx = mainView.getSelectedSubjectRow();
            subjectManager.nextSubject();
            loadSubject();
            mainView.selectSubjectRow(idx + 1);
        });

        mainView.getPreviousSubjectButton().addActionListener(e -> {
            int idx = mainView.getSelectedSubjectRow();
            subjectManager.previousSubject();
            loadSubject();
            mainView.selectSubjectRow(idx - 1);
        });

        ListSelectionModel model = mainView.getSubjectTableModel();
        model.addListSelectionListener(e -> {
            if (!model.isSelectionEmpty()) {
                int index = model.getMinSelectionIndex();
                loadSubject(index);
            }
        });
    }

    private void addNewStudent() {
        String rfId = mainView.getRfIdText();
        String name = mainView.getFirstNameText();
        String lastName = mainView.getLastNameText();

        if (studentManager.addStudent(rfId.trim(), name.trim(), lastName.trim())) {
            mainView.setRfIdText("");
            mainView.setFirstNameText("");
            mainView.setLastNameText("");
            mainView.showDialog("Add Student",
                    String.format("The student '%s %s' was added successfully", name, lastName), "info");
            updateProfileView();
        } else {
            mainView.showDialog("Add Student", "Student couldn't be added", "error");
        }
    }

//    private void searchUser() {
//        String name = mainView.getFirstNameText();
//        String lastName = mainView.getLastNameText();
//
//        Vector students = studentManager.searchStudentBy(name.toLowerCase(), lastName.toLowerCase());
//        if (!students.isEmpty()) {
//            displaySearchResult(students);
//        } else {
//            mainView.showDialog("Student Search", "Student couldn't be found.", "info");
//        }
//    }

    private void displaySearchResult(Vector students) {
        mainView.updateStudentDataTable(students);
    }

    private void updateProfileView() {
        Student student = studentManager.getCurrentStudent();
        if (student != null) {
            mainView.setRfidLabelText(student.getRfid());
            mainView.setFirstNameLabelText(student.getName());
            mainView.setLastNameLabelText(student.getLastName());
        }
    }

    private void addNewSubject() {
        String id = mainView.getSubjectIdText();
        String name = mainView.getSubjectNameText();
        String grade = mainView.getSubjectGradeText();

        if (subjectManager.addSubject(id, name, grade)) {
            mainView.showDialog("Add Subject",
                    String.format("The subject %s was added successfully", name), "info");
            updateSubjectView();
            mainView.selectSubjectRow(subjectManager.getDataModel().getRowCount() - 1);
        } else {
            mainView.showDialog("Add Subject",
                    String.format("The subject %s was not added", name), "error");
        }
    }

    private void saveSubject() {
        String id = mainView.getSubjectIdText();
        String name = mainView.getSubjectNameText();
        String grade = mainView.getSubjectGradeText();

        int selectedRow = mainView.getSelectedSubjectRow();

        if (subjectManager.saveSubject(id, name, grade)) {
            mainView.showDialog("Add Subject",
                    String.format("The subject %s was saved successfully", name), "info");
            updateSubjectView();
            mainView.selectSubjectRow(selectedRow);
        } else {
            mainView.showDialog("Add Subject",
                    String.format("The subject %s was not saved", name), "error");
        }
    }

    private void updateSubjectView() {
        subjectManager.getDataModel().fireTableDataChanged();
        mainView.loadSubjectTable(subjectManager.getDataModel());
    }

    private void loadSubject() {
        Subject subject = subjectManager.getCurrentSubject();
        mainView.setSubjectIdText(subject.getId());
        mainView.setSubjectNameText(subject.getName());
        mainView.setSubjectGradeText(String.valueOf(subject.getGrade()));
    }

    private void loadSubject(int index) {
        try {
            Subject subject = subjectManager.getSelectedSubject(index);
            mainView.setSubjectIdText(subject.getId());
            mainView.setSubjectNameText(subject.getName());
            mainView.setSubjectGradeText(String.valueOf(subject.getGrade()));
        } catch (IndexOutOfBoundsException | NullPointerException ex) {
            mainView.setSubjectIdText("");
            mainView.setSubjectNameText("");
            mainView.setSubjectGradeText("");
        }
    }
}
