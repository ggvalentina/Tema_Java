import java.util.Objects;

enum UserAccountType {
    STUDENT, TEACHER
}

public class User {
    public String fName;
    public String lName;
    public String userName;
    public String password;
    //public MenuStrategy menuStrategy;
    public UserAccountType tip;
    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String userName, String password, UserAccountType account) {
        this.userName = userName;
        this.password = password;
        this.tip = account;
        //this.menuStrategy = accountType;
    }
}
