package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UserManager {
    private List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addUser(String name, String lastName) {
        userList.add(new User(name, lastName));
    }

    public Vector<Object> searchUserBy(String name, String lastName) {
        Vector<Object> result = new Vector<>();

        for (User user : userList) {
            if (name.equals(user.getFirstName()) || lastName.equals(user.getLastName())) {
                Vector<String> userData = new Vector<>();
                userData.add(user.getFirstName());
                userData.add(user.getLastName());
                result.add(userData);
            }
        }
        return result;
    }

    public User nextUser(User user) {
        int index = userList.indexOf(user);
        return (index < 0 || index + 1 == userList.size()) ? null : userList.get(index + 1);
    }

    public User previousUser(User user) {
        int index = userList.indexOf(user);
        return (index <= 0) ? null : userList.get(index - 1);
    }
}
