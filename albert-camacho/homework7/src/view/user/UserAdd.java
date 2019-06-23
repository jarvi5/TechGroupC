package view.user;

import javax.swing.*;
import java.awt.*;

public class UserAdd extends UserPanel {

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton addButton;
    private JButton searchButton;

    private JLabel notificationLabel;

    public UserAdd() {
        super();
        init();
    }

    private void init() {
        JLabel firstNameLabel = new JLabel("Name:", JLabel.LEFT);
        constraints = getConstraints(0, 0, WEST, false, true);
        this.add(firstNameLabel, constraints);

        JLabel lastNameLabel = new JLabel("Last Name:", JLabel.LEFT);
        constraints = getConstraints(0, 1, WEST, false, true);
        this.add(lastNameLabel, constraints);

        firstNameTextField = new JTextField(15);
        constraints = getConstraints(1, 0, EAST, true, true);
        this.add(firstNameTextField, constraints);

        lastNameTextField = new JTextField(15);
        constraints = getConstraints(1, 1, EAST, true, true);
        this.add(lastNameTextField, constraints);

        addButton = new JButton("Add");
        constraints = getConstraints(2, 0, EAST, false, true);
        this.add(addButton, constraints);

        searchButton = new JButton("Search");
        constraints = getConstraints(2, 1, EAST, false, true);
        this.add(searchButton, constraints);

        notificationLabel = new JLabel(" ", JLabel.LEFT);
        constraints = getConstraints(0, 2, EAST, true, true);
        constraints.gridwidth = 3;
        this.add(notificationLabel, constraints);
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void displayUserNotFound() {
        notificationLabel.setForeground(Color.RED);
        notificationLabel.setText("User cannot be found!!");
    }

    public void displayUserNotCreated() {
        notificationLabel.setForeground(Color.RED);
        notificationLabel.setText("First name cannot be empty or less than 3 characters");
    }

    public void displayUserCreated() {
        notificationLabel.setForeground(new Color(50, 110, 0));
        notificationLabel.setText("User created successfully");
    }

    public void clearNotification() {
        notificationLabel.setText(" ");
    }
}
