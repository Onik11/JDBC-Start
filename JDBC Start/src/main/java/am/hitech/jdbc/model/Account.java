package am.hitech.jdbc.model;

public class Account {
    private int id;
    private String username;
    private String password;
    private int balance;
    private int userId;

    public Account(int id, String username, String password, int balance, int userId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.userId = userId;
    }
    public Account(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", userId=" + userId +
                '}';
    }
}
