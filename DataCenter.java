package fullapp.stockprojecttwo;

import java.util.ArrayList;

public class DataCenter {

    private static DataCenter instance = null;

    private static ArrayList<User> userList;

    private DataCenter() {
        userList = new ArrayList<>();

        userList.add(new User("amir", "123"));
        userList.add(new User("xyz123", "234567"));
    }

    public static DataCenter getInstance() {
        if (instance == null) {
            instance = new DataCenter();
        }
        return instance;
    }

    public boolean findUser(String username, String password) {
        return findUser(new User(username, password));
    }

    public boolean findUser(User user) {
        return userList.contains(user);
    }

    public boolean addUser(User user) {
        if (findUser(user)) {
            return false;
        }
        userList.add(user);
        return true;
    }

}
