package controller;

import model.Model;
import model.UserManager;
import view.View;

import javax.swing.*;
import java.util.LinkedList;

public class Controller {
    private Model user;
    private UserManager userManager;
    private View view;

    public Controller(Model user, UserManager userManager, View view) {
        this.user = user;
        this.userManager = userManager;
        this.view = view;
        initView();
    }

    public void initView() {
        view.getFirstNameTextField().setText(user.getFirstName());
        view.getLastNameTextField().setText(user.getLastName());
    }

    public void initController() {
        view.getSaveButton().addActionListener(e -> saveUser());
        view.getSearchButton().addActionListener(e -> searchUserName());
    }


    private void saveUser() {
        user = new Model(view.getFirstNameTextField().getText(), view.getLastNameTextField().getText());
        userManager.addUserList(user);
        viewSaveUser(user.getFirstName(), user.getLastName());
        JOptionPane.showMessageDialog(null, "The userManager: " + user.getFirstName() + " " +
                user.getLastName() + " was saved successful", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewSaveUser(String firstName, String lastName) {
        StringBuilder userName = new StringBuilder().append(firstName).append(" ").append(lastName);
        view.getNameSaveTextArea().setText(userName.toString());
    }

    public void searchUserName() {
        String name = "";
        LinkedList<Model> user = this.userManager.searchUser(view.getLastNameTextField().getText(),
                view.getFirstNameTextField().getText());
        if (!user.isEmpty()) {
            for (Model model : user) {
                name = name + model.getFirstName() + " " + model.getLastName() + "\n";
            }
            view.getNameSaveTextArea().setText(name);
        } else {
            JOptionPane.showMessageDialog(null, "The user with first name and last name " +
                    "was not found", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
