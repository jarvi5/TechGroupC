import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {
    private List<User> userList;
    private int index;

    public UserManager() {
        userList = new ArrayList<>();
    }

    public void setModel(User user) {
        userList.add(user);
        index++;
    }

    public List<User> getUserList() {
        return userList;
    }

    public int getIndex() {
        return index;
    }

    public String getLastUserName() {
        User user = userList.get(userList.size() - 1);
        return user.getUserName();
    }

    private String getUser() {
        String result = "";
        if (!userList.isEmpty()) {
            result = userList.get(index).getUserName();
        }
        return result;
    }

    public String nextUser() {
        index++;
        return getUser();
    }

    public String previousUser() {
        index--;
        return getUser();
    }

    public String searchUser(String firstName, String lastName) {
        String result = "";
        if (!userList.isEmpty()) {
            result = userList.stream()
                    .filter(user -> user.getFirstName().equalsIgnoreCase(firstName) ||
                            user.getLastName().equalsIgnoreCase(lastName))
                    .map(User::getUserName)
                    .collect(Collectors.joining("\n"));
        }
        return result;
    }
}
