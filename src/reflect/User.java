package reflect;

/**
 * @ClassName User
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/9 21:59
 * @Version 1.0
 */
public class User {

    private String userName;

    private int id;

    private int age;

    public User() {
    }

    public User(String userName, int id, int age) {
        this.userName = userName;
        this.id = id;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
