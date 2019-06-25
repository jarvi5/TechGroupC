package model;

import java.util.LinkedList;

public class UserManager {
    private LinkedList<Model> userList;
    public UserManager() {
        userList = new LinkedList<>();
    }

    public void addUserList(Model user) {
        userList.add(user);
    }

    public LinkedList<Model> searchUser(String lastName, String firstName) {
        LinkedList<Model> searchUserList = new LinkedList<>();
        for (Model userModel : userList) {
            if (userModel.getLastName().equals(lastName) && userModel.getFirstName().equals(firstName)) {
                searchUserList.add(userModel);
            }
        }
        return searchUserList;
    }

}
