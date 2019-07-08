package view;

import view.user.UserAdd;
import view.user.UserProfile;

import javax.swing.*;
import java.util.Vector;

public class UserView {

    private UserAdd userAddPanel;
    private UserProfile userProfilePanel;

    public UserView(String name) {
        JFrame frame = new JFrame(name);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        userAddPanel = new UserAdd();
        userProfilePanel = new UserProfile();

        frame.add(userAddPanel);
        frame.add(userProfilePanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(550, 250);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public JTextField getFirstNameTextField() {
        return userAddPanel.getFirstNameTextField();
    }

    public JTextField getLastNameTextField() {
        return userAddPanel.getLastNameTextField();
    }

    public JButton getAddButton() {
        return userAddPanel.getAddButton();
    }

    public JButton getSearchButton() {
        return userAddPanel.getSearchButton();
    }

    public JButton getNextButton() {
        return userProfilePanel.getNextButton();
    }

    public JButton getPreviousButton() {
        return userProfilePanel.getPreviousButton();
    }

    public void updateUserTable(Vector data) {
        userProfilePanel.getUserTable().loadData(data);
    }

    public JTable getSearchResultTable(){
        return userProfilePanel.getUserTable().getTable();
    }

    public void setUserFirstNameLabel(String name) {
        userProfilePanel.setUserFirstNameLabel(name);
    }

    public void setUserLastNameLabel(String lastName) {
        userProfilePanel.setUserLastNameLabel(lastName);
    }

    public void displayUserNotFound() {
        userAddPanel.displayUserNotFound();
        userProfilePanel.getUserTable().clearTable();
    }

    public void displayUserNotCreated() {
        userAddPanel.displayUserNotCreated();
    }

    public void displayUserCreated() {
        userAddPanel.displayUserCreated();
    }

    public void clearNotification() {
        userAddPanel.clearNotification();
    }
}
