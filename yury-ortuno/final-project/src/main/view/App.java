package main.view;

import javax.swing.*;

public class App {
    private JTextField rfidTxt;
    private JTextField lastNameTxt;
    private JTextField searchStudentTxt;
    private JButton searchButton;
    private JButton editButton;
    private JButton updateButton;
    private JButton addButton;
    private JTextField firstNameTxt;
    private JButton beforeButton;
    private JButton nextButton;
    private JLabel studentResult;
    private JButton CEditBtn;
    private JButton CAddBtn;
    private JButton CUpdateBtn;
    private JButton CSearchBtn;
    private JLabel courseResult;
    private JButton CNextBtn;
    private JButton CBeforeBtn;
    private JTextField CIdTxt;
    private JTextField CNameTxt;
    private JTextField CFinalTxt;
    private JTextField CSearchTxt;
    private JPanel mainPanel;

    public App() {
        JFrame frame = new JFrame("Courses");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JTextField getRfidTxt() {
        return rfidTxt;
    }

    public void setRfidTxt(JTextField rfidTxt) {
        this.rfidTxt = rfidTxt;
    }

    public JTextField getLastNameTxt() {
        return lastNameTxt;
    }

    public void setLastNameTxt(JTextField lastNameTxt) {
        this.lastNameTxt = lastNameTxt;
    }

    public JTextField getSearchStudentTxt() {
        return searchStudentTxt;
    }

    public void setSearchStudentTxt(JTextField searchStudentTxt) {
        this.searchStudentTxt = searchStudentTxt;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JTextField getFirstNameTxt() {
        return firstNameTxt;
    }

    public void setFirstNameTxt(JTextField firstNameTxt) {
        this.firstNameTxt = firstNameTxt;
    }

    public JButton getBeforeButton() {
        return beforeButton;
    }

    public void setBeforeButton(JButton beforeButton) {
        this.beforeButton = beforeButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public JLabel getStudentResult() {
        return studentResult;
    }

    public void setStudentResult(JLabel studentResult) {
        this.studentResult = studentResult;
    }

    public JButton getCEditBtn() {
        return CEditBtn;
    }

    public void setCEditBtn(JButton CEditBtn) {
        this.CEditBtn = CEditBtn;
    }

    public JButton getCAddBtn() {
        return CAddBtn;
    }

    public void setCAddBtn(JButton CAddBtn) {
        this.CAddBtn = CAddBtn;
    }

    public JButton getCUpdateBtn() {
        return CUpdateBtn;
    }

    public void setCUpdateBtn(JButton CUpdateBtn) {
        this.CUpdateBtn = CUpdateBtn;
    }

    public JButton getCSearchBtn() {
        return CSearchBtn;
    }

    public void setCSearchBtn(JButton CSearchBtn) {
        this.CSearchBtn = CSearchBtn;
    }

    public JLabel getCourseResult() {
        return courseResult;
    }

    public void setCourseResult(JLabel courseResult) {
        this.courseResult = courseResult;
    }

    public JButton getCNextBtn() {
        return CNextBtn;
    }

    public void setCNextBtn(JButton CNextBtn) {
        this.CNextBtn = CNextBtn;
    }

    public JButton getCBeforeBtn() {
        return CBeforeBtn;
    }

    public void setCBeforeBtn(JButton CBeforeBtn) {
        this.CBeforeBtn = CBeforeBtn;
    }

    public JTextField getCIdTxt() {
        return CIdTxt;
    }

    public void setCIdTxt(JTextField CIdTxt) {
        this.CIdTxt = CIdTxt;
    }

    public JTextField getCNameTxt() {
        return CNameTxt;
    }

    public void setCNameTxt(JTextField CNameTxt) {
        this.CNameTxt = CNameTxt;
    }

    public JTextField getCFinalTxt() {
        return CFinalTxt;
    }

    public void setCFinalTxt(JTextField CFinalTxt) {
        this.CFinalTxt = CFinalTxt;
    }

    public JTextField getCSearchTxt() {
        return CSearchTxt;
    }

    public void setCSearchTxt(JTextField CSearchTxt) {
        this.CSearchTxt = CSearchTxt;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
