package project.controller;

import project.model.SubjectManager;
import project.model.StudentManager;
import project.model.datatype.Student;
import project.model.datatype.Subject;
import project.view.MainView;

import javax.swing.*;

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
        mainView.getAddFirstStudentButton().addActionListener(e -> {
            addNewStudent(StudentManager.FIRST_STUDENT);
            updateSubjectView();
            mainView.updateStudentDataTable(studentManager.getDataModel());
        });

        mainView.getAddLastStudentButton().addActionListener(e -> {
            addNewStudent(StudentManager.LAST_STUDENT);
            updateSubjectView();
            mainView.updateStudentDataTable(studentManager.getDataModel());
        });

        mainView.getRemoveStudentFirstButton().addActionListener(e -> {
            removeStudent(StudentManager.FIRST_STUDENT);
            updateSubjectView();
            mainView.updateStudentDataTable(studentManager.getDataModel());
        });

        mainView.getRemoveStudentLastButton().addActionListener(e -> {
            removeStudent(StudentManager.LAST_STUDENT);
            updateSubjectView();
            mainView.updateStudentDataTable(studentManager.getDataModel());
        });

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

        mainView.getAddFirstSubjectButton().addActionListener(e -> addNewSubject(SubjectManager.FIRST_SUBJECT));

        mainView.getAddLastSubjectButton().addActionListener(e -> addNewSubject(SubjectManager.LAST_SUBJECT));

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

        mainView.getRemoveFirstSubjectButton().addActionListener(e -> {
            removeSubject(SubjectManager.FIRST_SUBJECT);
            updateSubjectView();
            mainView.updateStudentDataTable(studentManager.getDataModel());
        });

        mainView.getRemoveLastSubjectButton().addActionListener(e -> {
            removeSubject(SubjectManager.LAST_SUBJECT);
            updateSubjectView();
            mainView.updateStudentDataTable(studentManager.getDataModel());
        });

        ListSelectionModel model = mainView.getSubjectTableModel();
        model.addListSelectionListener(e -> {
            if (!model.isSelectionEmpty()) {
                int index = model.getMinSelectionIndex();
                loadSubject(index);
            }
        });
    }

    private void addNewStudent(String atPosition) {
        String rfId = mainView.getRfIdText();
        String name = mainView.getFirstNameText();
        String lastName = mainView.getLastNameText();

        if (studentManager.addStudent(rfId.trim(), name.trim(), lastName.trim(), atPosition)) {
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

    private void removeStudent(String atPosition) {
        String studentName = studentManager.removeStudent(atPosition);

        mainView.showDialog("Delete Student",
                String.format("The student '%s' was deleted successfully", studentName), "info");
        updateProfileView();
    }

    private void updateProfileView() {
        Student student = studentManager.getStudent();
        if (student != null) {
            mainView.setRfidLabelText(student.getRfid());
            mainView.setFirstNameLabelText(student.getName());
            mainView.setLastNameLabelText(student.getLastName());
        } else {
            mainView.setRfidLabelText("");
            mainView.setFirstNameLabelText("");
            mainView.setLastNameLabelText("");
        }
    }

    private void addNewSubject(String atPosition) {
        String id = mainView.getSubjectIdText();
        String name = mainView.getSubjectNameText();
        String grade = mainView.getSubjectGradeText();

        if (subjectManager.addSubject(id, name, grade, atPosition)) {
            mainView.showDialog("Add Subject",
                    String.format("The subject %s was added successfully", name), "info");
            updateSubjectView();
            if (atPosition.equals(SubjectManager.FIRST_SUBJECT)) {
                mainView.selectSubjectRow(0);
            } else {
                mainView.selectSubjectRow(subjectManager.getDataModel().getRowCount() - 1);
            }
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

    private void removeSubject(String atPosition) {
        String subjectName = subjectManager.removeSubject(atPosition);

        mainView.showDialog("Delete Subject",
                String.format("The subject '%s' was deleted successfully", subjectName), "info");
        updateProfileView();
    }
}
