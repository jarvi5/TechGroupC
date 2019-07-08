package ui.model;

import java.util.LinkedList;

public class UserList {
    private LinkedList<Model> userModelLinkedList;

    public UserList() {
        userModelLinkedList = new LinkedList<>();
    }

    public void addUserList(Model user) {
        userModelLinkedList.add(user);
    }

    public LinkedList<Model> searchUser(String lastname) {
        LinkedList<Model> userList = new LinkedList<>();
        for (Model userModel : userModelLinkedList) {
            if (userModel.getLastname().equals(lastname)) {
                userList.add(userModel);
            }
        }
        return userList;
    }

    public Model getNextUser(String name, String lastname) {
        Model user = null;
        for (int count = 0; count < userModelLinkedList.size(); count++) {
            if (userModelLinkedList.get(count).getFirstname().equals(name) &&
                    userModelLinkedList.get(count).getLastname().equals(lastname)) {
                if(!userModelLinkedList.get(count).equals(userModelLinkedList.getLast())){
                    user = userModelLinkedList.get(count + 1);
                    break;
                }
            }
        }
        return user;
    }

    public Model getPreviousUser(String name, String lastname) {
        Model user = null;
        for (int count = 0; count < userModelLinkedList.size(); count++) {
            if (userModelLinkedList.get(count).getFirstname().equals(name) &&
                    userModelLinkedList.get(count).getLastname().equals(lastname)) {
                if(!userModelLinkedList.get(count).equals(userModelLinkedList.getFirst())){
                    user = userModelLinkedList.get(count - 1);
                    break;
                }
            }
        }
        return user;
    }
}
