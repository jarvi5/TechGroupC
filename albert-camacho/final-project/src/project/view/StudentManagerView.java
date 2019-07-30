package project.view;

import project.common.IFunction;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.*;

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
    private JFrame frame;

    private DefaultTableModel studentTableModel;
    private DefaultTableModel subjectTableModel;
    private final static Vector<String> studentTableHeader = new Vector<>(Arrays.asList("RFID", "FirstName", "Last Name"));
    private final static Vector<String> subjectTableHeader = new Vector<>(Arrays.asList("ID", "Name"));

    public StudentManagerView(String title) {
        //clean default text in labels
        rfIdLabel.setText("");
        firstNameLabel.setText("");
        lastNameLabel.setText("");
        //load tables with default column names
        loadStudentTable();
        loadSubjectTable();

        frame = new JFrame(title);
        frame.setContentPane(this.userViewPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void loadStudentTable(){
        studentTableModel = new DefaultTableModel(){
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        studentTableModel.setColumnIdentifiers(studentTableHeader);
        userTable.setModel(studentTableModel);
        //userTable.setRowSelectionAllowed(true);
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void loadSubjectTable() {
        subjectTableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        subjectTableModel.setColumnIdentifiers(subjectTableHeader);

        subjectTable.setModel(subjectTableModel);
        //subjectTable.setRowSelectionAllowed(true);
        subjectTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
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

    public ListSelectionModel getSubjectTableModel() {
        return subjectTable.getSelectionModel();
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

    public void showDialog(String title, String msg, String optionMsg) {
        Map<String, IFunction> strategyMap = new HashMap<>();
        strategyMap.put("info", () -> JOptionPane.showMessageDialog(frame, msg));
        strategyMap.put("alert", () -> JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.WARNING_MESSAGE));
        strategyMap.put("error", () -> JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.ERROR_MESSAGE));
        strategyMap.put("yesno", () -> JOptionPane.showConfirmDialog(frame, msg, title, JOptionPane.YES_NO_OPTION));

        strategyMap.get(optionMsg).execute();
    }

    public static void main(String[] args) {
        new StudentManagerView("Student Manager View - Test");
    }

    public void addRowSubjectTable() {
        DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
        int idx = model.getRowCount();
        if (idx == 0 || model.getValueAt(idx - 1, 0) != null) {
            model.addRow(new Object[]{});
            subjectTable.setRowSelectionInterval(idx, idx);
        }
    }

    public int previousSubjectRow() {
        int index = subjectTable.getSelectedRow();
        if (index > 0) {
            index--;
            subjectTable.setRowSelectionInterval(index, index);
        }
        return index;
    }
    public int nextSubjectRow() {
        int index = subjectTable.getSelectedRow();
        if (index < subjectTableModel.getRowCount() - 1) {
            index++;
            subjectTable.setRowSelectionInterval(index, index);
        }
        return index;
    }

    public int getSelectedSubjectRow(){
        return subjectTable.getSelectedRow();
    }
}
