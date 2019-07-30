package project.controller;

import project.model.Student;
import project.model.StudentManager;
import project.model.Subject;
import project.view.StudentManagerView;

import javax.swing.*;
import java.util.Vector;

public class StudentController {
    private StudentManager studentManager;
    private StudentManagerView studentManagerView;

    public StudentController(StudentManager model, StudentManagerView view) {
        studentManager = model;
        studentManagerView = view;
    }

    public void initController() {
        studentManagerView.getAddStudentButton().addActionListener(e -> addNewStudent());
        studentManagerView.getSearchStudentButton().addActionListener(e -> searchUser());

        studentManagerView.getNextStudentButton().addActionListener(e -> {
            studentManager.nextStudent();
            updateProfileView();
            updateSubjectView();
        });
        studentManagerView.getPreviousStudentButton().addActionListener(e -> {
            studentManager.previousStudent();
            updateProfileView();
            updateSubjectView();
        });
        studentManagerView.getAddSubjectButton().addActionListener(e -> addNewRowInSubjectTable());
        studentManagerView.getSaveSubjectButton().addActionListener(e -> saveSubject());
        studentManagerView.getNextSubjectButton().addActionListener(e -> {
            int idx = studentManagerView.nextSubjectRow();
            loadSubject(idx);
        });
        studentManagerView.getPreviousSubjectButton().addActionListener(e -> {
            int idx = studentManagerView.previousSubjectRow();
            loadSubject(idx);
        });
        ListSelectionModel model = studentManagerView.getSubjectTableModel();
        model.addListSelectionListener(e -> {
            if (!model.isSelectionEmpty()) {
                int index = model.getMinSelectionIndex();
                loadSubject(index);
            }
        });
    }

    private void addNewStudent() {
        String rfId = studentManagerView.getRfIdText();
        String name = studentManagerView.getFirstNameText();
        String lastName = studentManagerView.getLastNameText();

        if (studentManager.addStudent(rfId.trim(), name.trim(), lastName.trim())) {
            studentManagerView.setRfIdText("");
            studentManagerView.setFirstNameText("");
            studentManagerView.setLastNameText("");
            studentManagerView.showDialog("Add Student",
                    String.format("The student '%s %s' was added successfully", name, lastName), "info");
            updateProfileView();
        } else {
            studentManagerView.showDialog("Add Student", "Student couldn't be added", "error");
        }
    }

    private void searchUser() {
        String name = studentManagerView.getFirstNameText();
        String lastName = studentManagerView.getLastNameText();

        Vector<Object> students = studentManager.searchStudentBy(name.toLowerCase(), lastName.toLowerCase());
        if (!students.isEmpty()) {
            displaySearchResult(students);
        } else {
            studentManagerView.showDialog("Student Search", "Student couldn't be found.", "info");
        }
    }

    private void displaySearchResult(Vector<Object> students) {
        studentManagerView.updateStudentDataTable(students);
    }

    private void updateProfileView(){
        Student student = studentManager.getCurrentStudent();
        if (student != null){
            studentManagerView.setRfidLabelText(student.getRfid());
            studentManagerView.setFirstNameLabelText(student.getName());
            studentManagerView.setLastNameLabelText(student.getLastName());
        }
    }

    private void addNewRowInSubjectTable() {
        studentManagerView.addRowSubjectTable();
        // subject fields are empty
        studentManagerView.setSubjectIdText("");
        studentManagerView.setSubjectNameText("");
        studentManagerView.setSubjectGradeText("");
    }

    private void saveSubject() {
        String id = studentManagerView.getSubjectIdText();
        String name = studentManagerView.getSubjectNameText();
        String grade = studentManagerView.getSubjectGradeText();
        int idx = studentManagerView.getSelectedSubjectRow();

        if (studentManager.saveSubject(id, name, grade, idx)) {
            studentManagerView.showDialog("Add Subject",
                    String.format("The subject %s was saved successfully", name), "info");
            updateSubjectView();
        } else {
            studentManagerView.showDialog("Add Subject",
                    String.format("The subject %s was not saved", name), "error");
        }
    }

    private void updateSubjectView() {
        Vector<Object> subjects = studentManager.getSubjectVector();

        studentManagerView.updateSubjectDataTable(subjects);

    }

    private void loadSubject(int index) {
        try{
            Subject subject = studentManager.getSelectedSubject(index);
            studentManagerView.setSubjectIdText(subject.getId());
            studentManagerView.setSubjectNameText(subject.getName());
            studentManagerView.setSubjectGradeText(String.valueOf(subject.getGrade()));
        } catch (IndexOutOfBoundsException | NullPointerException ex) {
            studentManagerView.setSubjectIdText("");
            studentManagerView.setSubjectNameText("");
            studentManagerView.setSubjectGradeText("");
        }
    }
}
