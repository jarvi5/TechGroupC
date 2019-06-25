package view;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextArea nameSaveTextArea;
    private JButton saveButton;
    private JButton searchButton;

    public View(String title) {
        setFrame(new JFrame(title));
        getFrame().setSize(500, 300);
        getFrame().getContentPane().setLayout(new BorderLayout());
        getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getFrame().setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getFrame().add(panel);
        placeComponents(panel);

        getFrame().setVisible(true);
    }

    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        setFirstNameLabel(new JLabel("FirstName"));
        getFirstNameLabel().setBounds(10, 10, 80, 25);
        panel.add(getFirstNameLabel());

        setLastNameLabel(new JLabel("LastName"));
        getLastNameLabel().setBounds(10, 40, 80, 25);
        panel.add(getLastNameLabel());

        setFirstNameTextField(new JTextField());
        getFirstNameTextField().setBounds(100, 10, 160, 25);
        panel.add(getFirstNameTextField());

        setLastNameTextField(new JTextField());
        getLastNameTextField().setBounds(100, 40, 160, 25);
        panel.add(getLastNameTextField());

        setNameSaveTextArea(new JTextArea());
        getNameSaveTextArea().setBounds(100, 100, 160, 100);
        getNameSaveTextArea().setEditable(false);
        panel.add(getNameSaveTextArea());

        setSaveButton(new JButton("Save"));
        getSaveButton().setBounds(350, 10, 80, 25);
        panel.add(getSaveButton());


        setSearchButton(new JButton("Search"));
        getSearchButton().setBounds(350, 50, 80, 25);
        panel.add(getSearchButton());
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getFirstNameLabel() {
        return firstNameLabel;
    }

    public void setFirstNameLabel(JLabel firstNameLabel) {
        this.firstNameLabel = firstNameLabel;
    }

    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    public void setLastNameLabel(JLabel lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public void setFirstNameTextField(JTextField firstNameTextField) {
        this.firstNameTextField = firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
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


    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }
}
