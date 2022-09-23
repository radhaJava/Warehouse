package loginPage;

public class User {
    int index;
    String userName;
    String password;
    String userRole;

    public User(int index, String userName, String password, String userRole) {
        this.index = index;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public int getIndex() {
        return index;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }
}
