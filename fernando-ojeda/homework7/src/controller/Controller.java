package ui.controller;

import ui.model.UserList;
import ui.model.Model;
import ui.view.View;

import javax.swing.*;
import java.util.LinkedList;

public class Controller {
    private Model model;
    private UserList userList;
    private View view;

    public Controller(Model model, UserList userList, View view) {
        this.model = model;
        this.userList = userList;
        this.view = view;
        initView();
    }

    public void initView() {
        view.getFirstnameTextField().setText(model.getFirstname());
        view.getLastnameTextField().setText(model.getLastname());
    }

    public void initController() {
        view.getSaveButton().addActionListener(e -> saveUser());
        view.getSearchButton().addActionListener(e -> searchUserName());
        view.getNextButton().addActionListener(e -> nextUser());
        view.getPreviousButton().addActionListener(e -> previousUser());
    }

    private void previousUser() {
        String name = view.getFirstnameTextField().getText();
        String lastname = view.getLastnameTextField().getText();
        Model user = userList.getPreviousUser(name, lastname);
        if (user != null) {
            viewSaveUser(user.getFirstname(), user.getLastname());
        } else {
            JOptionPane.showMessageDialog(null, "Not found User Information",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void nextUser() {
        String name = view.getFirstnameTextField().getText();
        String lastname = view.getLastnameTextField().getText();
        Model user = userList.getNextUser(name, lastname);
        if (user != null) {
            viewSaveUser(user.getFirstname(), user.getLastname());
        } else {
            JOptionPane.showMessageDialog(null, "Not found User Information",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void saveUser() {
        model = new Model(view.getFirstnameTextField().getText(), view.getLastnameTextField().getText());
        userList.addUserList(model);
        viewSaveUser(model.getFirstname(), model.getLastname());
        JOptionPane.showMessageDialog(null, "The user: " + model.getFirstname() + " " +
                model.getLastname() + " was saved successful", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewSaveUser(String firstname, String lastname) {
        StringBuilder userName = new StringBuilder().append(firstname).append(" ").append(lastname);
        view.getNameSaveTextArea().setText(userName.toString());
    }

    public void searchUserName() {
        String name = "";
        LinkedList<Model> user = userList.searchUser(view.getLastnameTextField().getText());
        if (!user.isEmpty()) {
            for (Model model : user) {
                name = name + model.getFirstname() + " " + model.getLastname() + "\n";
            }
            view.getNameSaveTextArea().setText(name);
        } else {
            JOptionPane.showMessageDialog(null, "The user with lastname: " +
                    view.getLastnameTextField() + " was not found", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
