package ui2.view;

import javax.swing.*;
import java.awt.*;

public class AddUserPanel extends JPanel {
    private JLabel titlePanel;
    private JLabel informationLabel;
    private JLabel idLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JTextField idTextField;
    private JTextField firstnameTextFieldDetail;
    private JTextField lastnameTextFieldDetail;
    private JTextField idTextFieldDetail;
    private JTextArea nameSaveTextArea;
    private JButton saveButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton searchButton;
    private ImageIcon image;
    private ImageIcon imageUser;
    private JLabel imageLabel;
    private JLabel imageUserLabel;
    private JLabel idDetailLabel;
    private JLabel nameDetailLabel;
    private JLabel lastnameDetailLabel;

    public AddUserPanel() {
        super();
        placeComponentes();
    }

    private void placeComponentes() {
        this.setBackground(Color.WHITE);
        this.setBounds(2, 100, 1100, 300);
        this.setLayout(null);

        setTitlePanel(new JLabel("Student Registration"));
        getTitlePanel().setBounds(140, 10, 200, 25);
        this.add(getTitlePanel());

        setInformationLabel(new JLabel("Student Details"));
        getInformationLabel().setBounds(850, 10, 200, 25);
        this.add(getInformationLabel());

        setIdLabel(new JLabel("RFID"));
        getIdLabel().setBounds(60, 40, 80, 25);
        this.add(getIdLabel());

        setFirstnameLabel(new JLabel("Firstname"));
        getFirstnameLabel().setBounds(170, 40, 80, 25);
        this.add(getFirstnameLabel());

        setLastnameLabel(new JLabel("Lastname"));
        getLastnameLabel().setBounds(340, 40, 80, 25);
        this.add(getLastnameLabel());

        setIdTextField(new JTextField());
        getIdTextField().setBounds(10, 80, 100, 25);
        this.add(getIdTextField());

        setFirstnameTextField(new JTextField());
        getFirstnameTextField().setBounds(120, 80, 160, 25);
        this.add(getFirstnameTextField());

        setLastnameTextField(new JTextField());
        getLastnameTextField().setBounds(290, 80, 160, 25);
        this.add(getLastnameTextField());

        idTextFieldDetail = new JTextField();
        idTextFieldDetail.setBounds(890, 50, 160, 25);
        this.add(idTextFieldDetail);

        firstnameTextFieldDetail = new JTextField();
        firstnameTextFieldDetail.setBounds(890, 82, 160, 25);
        this.add(firstnameTextFieldDetail);

        lastnameTextFieldDetail = new JTextField();
        lastnameTextFieldDetail.setBounds(890, 112, 160, 25);
        this.add(lastnameTextFieldDetail);

        setNameSaveTextArea(new JTextArea());
        getNameSaveTextArea().setBounds(890, 55, 200, 100);
        getNameSaveTextArea().setEditable(false);
        this.add(getNameSaveTextArea());

        setPreviousButton(new JButton("<"));
        getPreviousButton().setBounds(500, 40, 50, 25);
        this.add(getPreviousButton());

        setNextButton(new JButton(">"));
        getNextButton().setBounds(560, 40, 50, 25);
        this.add(getNextButton());

        setSaveButton(new JButton("Add"));
        getSaveButton().setBounds(515, 100, 80, 25);
        this.add(getSaveButton());

        setSearchButton(new JButton("search"));
        getSearchButton().setBounds(515, 150, 80, 25);
        this.add(getSearchButton());

        image = new ImageIcon("student.png");
        imageLabel = new JLabel(image);
        imageLabel.setBounds(170, 120, 80, 80);
        this.add(imageLabel);

        imageUser = new ImageIcon("student.png");
        imageUserLabel = new JLabel(imageUser);
        imageUserLabel.setBounds(700, 50, 80, 80);
        this.add(imageUserLabel);

        idDetailLabel = new JLabel("RFID");
        idDetailLabel.setBounds(800, 50, 80, 25);
        this.add(idDetailLabel);

        nameDetailLabel = new JLabel("Firstname");
        nameDetailLabel.setBounds(800, 82, 80, 25);
        this.add(nameDetailLabel);

        lastnameDetailLabel = new JLabel("Lastname");
        lastnameDetailLabel.setBounds(800, 112, 80, 25);
        this.add(lastnameDetailLabel);
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

    public JTextArea getNameSaveTextArea() {
        return nameSaveTextArea;
    }

    public void setNameSaveTextArea(JTextArea nameSaveTextArea) {
        this.nameSaveTextArea = nameSaveTextArea;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public void setPreviousButton(JButton previousButton) {
        this.previousButton = previousButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JLabel getTitlePanel() {
        return titlePanel;
    }

    public void setTitlePanel(JLabel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public JLabel getInformationLabel() {
        return informationLabel;
    }

    public void setInformationLabel(JLabel informationLabel) {
        this.informationLabel = informationLabel;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JTextField getFirstnameTextFieldDetail() {
        return firstnameTextFieldDetail;
    }

    public JTextField getLastnameTextFieldDetail() {
        return lastnameTextFieldDetail;
    }

    public JTextField getIdTextFieldDetail() {
        return idTextFieldDetail;
    }
}
