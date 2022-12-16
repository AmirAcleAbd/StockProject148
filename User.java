package fullapp.stockprojecttwo;

public class User {

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String birthday;
    private int age;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof User))
            return false;

        User user = (User)obj;
        return (user.password.equals(this.password) &&
                user.username.equals(this.username));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}