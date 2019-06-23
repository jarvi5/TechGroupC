package controller;

import model.User;
import model.UserManager;
import view.UserView;

import java.util.Vector;

public class UserController {
    private UserManager userManager;
    private UserView userView;
    private User currentUser;

    public UserController(UserManager model, UserView view) {
        userManager = model;
        userView = view;
    }

    public void initController() {
        userView.getAddButton().addActionListener(e -> {
            clearNotification();
            saveUser();
        });
        userView.getSearchButton().addActionListener(e -> {
            clearNotification();
            searchUser();
        });

        userView.getPreviousButton().addActionListener(e -> {
            clearNotification();
            previousUser();
        });
        userView.getNextButton().addActionListener(e -> {
            clearNotification();
            nextUser();
        });
    }


    private void saveUser() {
        String name = userView.getFirstNameTextField().getText();
        String lastName = userView.getLastNameTextField().getText();

        if (!name.equals("") && name.length() > 2) {
            User user = new User(name.trim(), lastName.trim());
            userManager.addUser(user);

            if (currentUser == null)
                updateCurrentUser(user);

            userView.getFirstNameTextField().setText("");
            userView.getLastNameTextField().setText("");
            userView.displayUserCreated();
        } else {
            userView.displayUserNotCreated();
        }
    }

    private void searchUser() {
        String name = userView.getFirstNameTextField().getText();
        String lastName = userView.getLastNameTextField().getText();

        Vector<Object> users = userManager.searchUserBy(name, lastName);
        if (!users.isEmpty()) {
            displaySearchResult(users);
        } else {
            userView.displayUserNotFound();
        }
    }

    private void displaySearchResult(Vector<Object> users) {
        userView.updateUserTable(users);
    }

    private void previousUser() {
        updateCurrentUser(userManager.previousUser(currentUser));
    }

    private void nextUser() {
        updateCurrentUser(userManager.nextUser(currentUser));
    }

    private void updateCurrentUser(User user) {
        if (user != null) {
            userView.setUserFirstNameLabel(user.getFirstName());
            userView.setUserLastNameLabel(user.getLastName());
            currentUser = user;
        }
    }

    private void clearNotification() {
        userView.clearNotification();
    }
}
