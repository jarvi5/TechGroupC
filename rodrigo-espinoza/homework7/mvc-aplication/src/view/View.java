package view;

import java.awt.BorderLayout;
import javax.swing.*;

public class View {
    // View uses Swing framework to display UI to user
    private JFrame frame;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JTextArea nameSaveTextArea;
    private JButton saveButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton searchButton;

    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 320);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getFrame().add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
        // Create UI elements
        private void placeComponents (JPanel panel){

            panel.setLayout(null);

            setFirstnameLabel(new JLabel("First Name"));
            getFirstnameLabel().setBounds(10, 10, 80, 25);
            panel.add(getFirstnameLabel());

            setLastnameLabel(new JLabel("Last Name"));
            getLastnameLabel().setBounds(10, 50, 80, 25);
            panel.add(getLastnameLabel());

            setFirstnameTextField(new JTextField());
            getFirstnameTextField().setBounds(100, 10, 160, 25);
            panel.add(getFirstnameTextField());

            setLastnameTextField(new JTextField());
            getLastnameTextField().setBounds(100, 50, 160, 25);
            panel.add(getLastnameTextField());

            setNameSaveTextArea(new JTextArea());
            getNameSaveTextArea().setBounds(100, 140, 160, 100);
            getNameSaveTextArea().setEditable(false);
            panel.add(getNameSaveTextArea());

            setSaveButton(new JButton("Save"));
            getSaveButton().setBounds(350, 10, 90, 25);
            panel.add(getSaveButton());

            setNextButton(new JButton("Next"));
            getNextButton().setBounds(350, 50, 90, 25);
            panel.add(getNextButton());

            setPreviousButton(new JButton("Previous"));
            getPreviousButton().setBounds(350, 90, 90, 25);
            panel.add(getPreviousButton());

            setSearchButton(new JButton("Search"));
            getSearchButton().setBounds(350, 130, 90, 25);
            panel.add(getSearchButton());
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
}