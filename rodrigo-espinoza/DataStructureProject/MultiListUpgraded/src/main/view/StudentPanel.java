package view;

import javax.swing.*;

public class StudentPanel {
    private JPanel studentPanel;

    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel RFIDLabel;
    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JTextField RFIDField;
    private JButton saveStudentButton;
    private JButton nextStudentButton;
    private JButton previousStudentButton;
    private JButton searchStudentButton;

    public StudentPanel() {
        this.studentPanel = new JPanel();
        this.firstnameLabel = new JLabel("Fist Name");
        this.lastnameLabel = new JLabel();
        this.RFIDLabel = new JLabel();
    }

    public void initPanel(){
        this.firstnameLabel.setBounds(10, 10, 80, 25);
        this.studentPanel.add(firstnameLabel);

    }
    public JPanel getStudentPanel() {
        return studentPanel;
    }
}
