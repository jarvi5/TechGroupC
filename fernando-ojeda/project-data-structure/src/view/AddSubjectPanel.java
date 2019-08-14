package ui2.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AddSubjectPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel noteLabel;
    private JLabel nameDetailLabel;
    private JLabel idDetailLabel;
    private JLabel noteDetailLabel;
    private JTextField nameTextFieldDetail;
    private JTextField idTextFieldDetail;
    private JTextField noteTextFieldDetail;
    private JLabel subjectTitleLabel;
    private JLabel detailLabel;
    private JLabel subjectsLabel;
    private JTextField nameTextField;
    private JTextField idTextField;
    private JTextField noteTextField;
    private JTextArea nameSaveTextArea;
    private JButton saveButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton searchButton;

    public AddSubjectPanel() {
        super();
        placeComponentes();
    }

    private void placeComponentes() {
        this.setBackground(Color.WHITE);
        this.setBounds(2, 400, 1100, 450);
        this.setLayout(null);

        setSubjectTitleLabel(new JLabel("Subject Registration"));
        getSubjectTitleLabel().setBounds(90, 20, 200, 25);
        this.add(getSubjectTitleLabel());

        setDetailLabel(new JLabel("Subject Details"));
        getDetailLabel().setBounds(900, 20, 200, 25);
        this.add(getDetailLabel());

        subjectsLabel = new JLabel("Subjects");
        subjectsLabel.setBounds(650, 20, 200, 25);
        this.add(subjectsLabel);

        setNameLabel(new JLabel("Name"));
        getNameLabel().setBounds(10, 60, 80, 25);
        this.add(getNameLabel());

        setIdLabel(new JLabel("Id"));
        getIdLabel().setBounds(10, 100, 80, 25);
        this.add(getIdLabel());

        setNoteLabel(new JLabel("Note"));
        getNoteLabel().setBounds(10, 140, 80, 25);
        this.add(getNoteLabel());

        nameDetailLabel = new JLabel("Name");
        nameDetailLabel.setBounds(850, 50, 80, 25);
        this.add(nameDetailLabel);

        idDetailLabel = new JLabel("Id");
        idDetailLabel.setBounds(850, 90, 80, 25);
        this.add(idDetailLabel);

        noteDetailLabel = new JLabel("Note");
        noteDetailLabel.setBounds(850, 130, 80, 25);
        this.add(noteDetailLabel);

        setNameTextField(new JTextField());
        getNameTextField().setBounds(100, 60, 160, 25);
        this.add(getNameTextField());

        setIdTextField(new JTextField());
        getIdTextField().setBounds(100, 100, 160, 25);
        this.add(getIdTextField());

        setNoteTextField(new JTextField());
        getNoteTextField().setBounds(100, 140, 160, 25);
        this.add(getNoteTextField());

        nameTextFieldDetail = new JTextField();
        nameTextFieldDetail.setBounds(900, 50, 160, 25);
        this.add(nameTextFieldDetail);

        idTextFieldDetail = new JTextField();
        idTextFieldDetail.setBounds(900, 90, 160, 25);
        this.add(idTextFieldDetail);

        noteTextFieldDetail = new JTextField();
        noteTextFieldDetail.setBounds(900, 130, 160, 25);
        this.add(noteTextFieldDetail);

        setNameSaveTextArea(new JTextArea());
        getNameSaveTextArea().setBounds(900, 50, 200, 100);
        getNameSaveTextArea().setEditable(false);
        this.add(getNameSaveTextArea());

        setPreviousButton(new JButton("<"));
        getPreviousButton().setBounds(330, 50, 50, 25);
        this.add(getPreviousButton());

        setNextButton(new JButton(">"));
        getNextButton().setBounds(400, 50, 50, 25);
        this.add(getNextButton());

        setSaveButton(new JButton("Save"));
        getSaveButton().setBounds(350, 90, 80, 25);
        this.add(getSaveButton());

        setSearchButton(new JButton("search"));
        getSearchButton().setBounds(350, 130, 80, 25);
        this.add(getSearchButton());
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
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

    public JLabel getNoteLabel() {
        return noteLabel;
    }

    public void setNoteLabel(JLabel noteLabel) {
        this.noteLabel = noteLabel;
    }

    public JTextField getNoteTextField() {
        return noteTextField;
    }

    public void setNoteTextField(JTextField noteTextField) {
        this.noteTextField = noteTextField;
    }

    public JLabel getSubjectTitleLabel() {
        return subjectTitleLabel;
    }

    public void setSubjectTitleLabel(JLabel subjectTitleLabel) {
        this.subjectTitleLabel = subjectTitleLabel;
    }

    public JLabel getDetailLabel() {
        return detailLabel;
    }

    public void setDetailLabel(JLabel detailLabel) {
        this.detailLabel = detailLabel;
    }

    public JTextField getNameTextFieldDetail() {
        return nameTextFieldDetail;
    }

    public JTextField getIdTextFieldDetail() {
        return idTextFieldDetail;
    }

    public JTextField getNoteTextFieldDetail() {
        return noteTextFieldDetail;
    }
}
