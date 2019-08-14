package view;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
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
    private JLabel subjectLabel;
    private JTextArea subjectTextArea;
    private JButton saveSubjectButton;
    private JButton searchSubjectButton;
    private JButton previousSubjectButton;
    private JButton nextSubjectButton;
    

    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getFrame().add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private void placeComponents (JPanel panel){

        panel.setLayout(null);

        setFirstnameLabel(new JLabel("First Name"));
        getFirstnameLabel().setBounds(10, 10, 80, 25);
        panel.add(getFirstnameLabel());

        setLastnameLabel(new JLabel("Last Name"));
        getLastnameLabel().setBounds(10, 50, 80, 25);
        panel.add(getLastnameLabel());

        setLastnameLabel(new JLabel("RFID"));
        getLastnameLabel().setBounds(10, 90, 80, 25);
        panel.add(getLastnameLabel());

        setFirstnameTextField(new JTextField());
        getFirstnameTextField().setBounds(100, 10, 160, 25);
        panel.add(getFirstnameTextField());

        setLastnameTextField(new JTextField());
        getLastnameTextField().setBounds(100, 50, 160, 25);
        panel.add(getLastnameTextField());

        setRFIDField(new JTextField());
        getRFIDField().setBounds(100,90,160,25);
        panel.add(getRFIDField());

        setSaveStudentButton(new JButton("Save"));
        getSaveStudentButton().setBounds(350, 10, 90, 25);
        panel.add(getSaveStudentButton());

        setNextStudentButton(new JButton("Next"));
        getNextStudentButton().setBounds(350, 50, 90, 25);
        panel.add(getNextStudentButton());

        setPreviousStudentButton(new JButton("Previous"));
        getPreviousStudentButton().setBounds(350, 90, 90, 25);
        panel.add(getPreviousStudentButton());

        setSearchStudentButton(new JButton("Search"));
        getSearchStudentButton().setBounds(350, 130, 90, 25);
        panel.add(getSearchStudentButton());

        setSubjectLabel(new JLabel("Subjects"));
        getSubjectLabel().setBounds(50, 130, 160, 100);
        panel.add(getSubjectLabel());

        setSubjectTextArea(new JTextArea());
        getSubjectTextArea().setBounds(50, 210, 160, 180);
        getSubjectTextArea().setEditable(false);
        panel.add(getSubjectTextArea());

        setPreviousSubjectButton(new JButton("<"));
        getPreviousSubjectButton().setBounds(250, 210, 50, 25);
        panel.add(getPreviousSubjectButton());

        setNextSubjectButton(new JButton(">"));
        getNextSubjectButton().setBounds(250, 240, 50, 25);
        panel.add(getNextSubjectButton());


    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getFirstnameLabel() {
        return firstnameLabel;
    }

    public void setFirstnameLabel(JLabel firstnameLabel) {
        this.firstnameLabel = firstnameLabel;
    }

    public JLabel getLastnameLabel() {
        return lastnameLabel;
    }

    public void setLastnameLabel(JLabel lastnameLabel) {
        this.lastnameLabel = lastnameLabel;
    }

    public JLabel getRFIDLabel() {
        return RFIDLabel;
    }

    public void setRFIDLabel(JLabel RFIDLabel) {
        this.RFIDLabel = RFIDLabel;
    }

    public JTextField getFirstnameTextField() {
        return firstnameTextField;
    }

    public void setFirstnameTextField(JTextField firstnameTextField) {
        this.firstnameTextField = firstnameTextField;
    }

    public JTextField getLastnameTextField() {
        return lastnameTextField;
    }

    public void setLastnameTextField(JTextField lastnameTextField) {
        this.lastnameTextField = lastnameTextField;
    }

    public JTextArea getSubjectTextArea() {
        return subjectTextArea;
    }

    public void setSubjectTextArea(JTextArea subjectTextArea) {
        this.subjectTextArea = subjectTextArea;
    }

    public JButton getSaveStudentButton() {
        return saveStudentButton;
    }

    public void setSaveStudentButton(JButton saveStudentButton) {
        this.saveStudentButton = saveStudentButton;
    }

    public JButton getNextStudentButton() {
        return nextStudentButton;
    }

    public void setNextStudentButton(JButton nextStudentButton) {
        this.nextStudentButton = nextStudentButton;
    }

    public JButton getPreviousStudentButton() {
        return previousStudentButton;
    }

    public void setPreviousStudentButton(JButton previousStudentButton) {
        this.previousStudentButton = previousStudentButton;
    }

    public JButton getSearchStudentButton() {
        return searchStudentButton;
    }

    public void setSearchStudentButton(JButton searchStudentButton) {
        this.searchStudentButton = searchStudentButton;
    }

    public JTextField getRFIDField() {
        return RFIDField;
    }

    public void setRFIDField(JTextField RFIDField) {
        this.RFIDField = RFIDField;
    }

    public JLabel getSubjectLabel() {
        return subjectLabel;
    }

    public void setSubjectLabel(JLabel subjectLabel) {
        this.subjectLabel = subjectLabel;
    }

    public JButton getSaveSubjectButton() {
        return saveSubjectButton;
    }

    public void setSaveSubjectButton(JButton saveSubjectButton) {
        this.saveSubjectButton = saveSubjectButton;
    }

    public JButton getSearchSubjectButton() {
        return searchSubjectButton;
    }

    public void setSearchSubjectButton(JButton searchSubjectButton) {
        this.searchSubjectButton = searchSubjectButton;
    }

    public JButton getPreviousSubjectButton() {
        return previousSubjectButton;
    }

    public void setPreviousSubjectButton(JButton previousSubjectButton) {
        this.previousSubjectButton = previousSubjectButton;
    }

    public JButton getNextSubjectButton() {
        return nextSubjectButton;
    }

    public void setNextSubjectButton(JButton nextSubjectButton) {
        this.nextSubjectButton = nextSubjectButton;
    }
}
