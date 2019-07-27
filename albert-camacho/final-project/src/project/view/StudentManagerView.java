package project.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Vector;

public class StudentManagerView {
    private JPanel userViewPanel;
    private JPanel addSearchPanel;
    private JPanel subjectPanel;
    private JPanel profilePanel;
    private JTextField rfIdTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton addStudentButton;
    private JButton searchStudentButton;
    private JButton nextStudentButton;
    private JTable userTable;
    private JPanel searchResultPanel;
    private JButton previousStudentButton;
    private JTable subjectTable;
    private JButton previousSubjectButton;
    private JButton addSubjectButton;
    private JButton nextSubjectButton;
    private JTextField subjectIdTextField;
    private JTextField subjectNameTextField;
    private JTextField subjectGradeTextField;
    private JButton saveSubjectButton;
    private JLabel rfIdLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;

    private DefaultTableModel studentTableModel;
    private DefaultTableModel subjectTableModel;
    private final static Vector<String> studentTableHeader = new Vector<>(Arrays.asList("RFID", "FirstName", "Last Name"));
    private final static Vector<String> subjectTableHeader = new Vector<>(Arrays.asList("ID", "Name"));

    public StudentManagerView() {
        //clean default text in labels
        rfIdLabel.setText("");
        firstNameLabel.setText("");
        lastNameLabel.setText("");
        //load tables with default column names
        loadStudentTable();
        loadSubjectTable();
    }

    private void loadStudentTable(){
        studentTableModel = new DefaultTableModel();
        studentTableModel.setColumnIdentifiers(studentTableHeader);

        userTable.setModel(studentTableModel);
    }

    private void loadSubjectTable() {
        subjectTableModel = new DefaultTableModel();
        subjectTableModel.setColumnIdentifiers(subjectTableHeader);

        subjectTable .setModel(subjectTableModel);
    }

    public void updateStudentDataTable(Vector data) {
        clearTableModel(studentTableModel);
        studentTableModel.setDataVector(data, studentTableHeader);
        userTable.setModel(studentTableModel);
    }

    public void updateSubjectDataTable(Vector data) {
        clearTableModel(subjectTableModel);
        subjectTableModel.setDataVector(data, subjectTableHeader);
        subjectTable.setModel(subjectTableModel);
    }

    private void clearTableModel(DefaultTableModel model) {
        model.setRowCount(0);
    }

    public void setRfidLabelText(String text) {
        this.rfIdLabel.setText(text);
    }

    public void setFirstNameLabelText(String text) {
        this.firstNameLabel.setText(text);
    }

    public void setLastNameLabelText(String text) {
        this.lastNameLabel.setText(text);
    }

    public String getRfIdText() {
        return rfIdTextField.getText();
    }

    public void setRfIdText(String text) {
        this.rfIdTextField.setText(text);
    }

    public String getFirstNameText() {
        return firstNameTextField.getText();
    }

    public void setFirstNameText(String text) {
        this.firstNameTextField.setText(text);
    }

    public String getLastNameText() {
        return lastNameTextField.getText();
    }

    public void setLastNameText(String text) {
        this.lastNameTextField.setText(text);
    }

    public String getSubjectIdText() {
        return subjectIdTextField.getText();
    }

    public void setSubjectIdText(String text) {
        this.subjectIdTextField.setText(text);
    }

    public String getSubjectNameText() {
        return subjectNameTextField.getText();
    }

    public void setSubjectNameText(String text) {
        this.subjectNameTextField.setText(text);
    }

    public String getSubjectGradeText() {
        return subjectGradeTextField.getText();
    }

    public void setSubjectGradeText(String text) {
        this.subjectGradeTextField.setText(text);
    }

    public JButton getAddStudentButton() {
        return addStudentButton;
    }

    public JButton getSearchStudentButton() {
        return searchStudentButton;
    }

    public JButton getNextStudentButton() {
        return nextStudentButton;
    }

    public JButton getPreviousStudentButton() {
        return previousStudentButton;
    }

    public JButton getPreviousSubjectButton() {
        return previousSubjectButton;
    }

    public JButton getAddSubjectButton() {
        return addSubjectButton;
    }

    public JButton getNextSubjectButton() {
        return nextSubjectButton;
    }

    public JButton getSaveSubjectButton() {
        return saveSubjectButton;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StudentManagerView");
        frame.setContentPane(new StudentManagerView().userViewPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
