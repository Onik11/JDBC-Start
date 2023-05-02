package am.hitech.jdbc.repo;

import am.hitech.jdbc.model.User;
import am.hitech.jdbc.util.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    Connection connection = DataSource.getConnection();

    public List<User> getAll() {
        List<User> users;
        String query = "Select * from user";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            users = buildUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public List<User> getById(int id) {
        List<User> user = null;
        String query = "Select * from user where id =" + id;

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            user = buildUser(resultSet);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> getByUsername(String username) {
        List<User> user = null;
        String query = "Select * from user where email =" + username;

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            user = buildUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> findAdults(int age) {
        List<User> users = null;


        String query = "select * from user where age >= " + age;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            users = buildUser(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return users;
    }

    public List<User> findUsers(String s) {

        List<User> users;

        String query = "Select * from user where first_name like'" + s + "%'";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            users = buildUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private List<User> buildUser(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        User user = null;

        try {
            while (resultSet.next()) {

                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public int creatUser(User user) {
        String query = "insert into user values(0," + user.getFirstName() + "," + user.getLastName() +
                "," + user.getEmail() + "," + user.getAge() + "," + "2023-03-31)";
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int creatUserV2(User user) {
        String query = "insert into user values(0,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getAge());

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String name, int id) {
        String query = "update user set first_name=? where id = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User checkUser(String username, int password) {

        String query = "Select * from user where email=? and password=?";

        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setInt(2, password);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User();

                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void register(String name, String surname, String email, int age, int password) {
        String query = "insert into user values(0,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setInt(4, age);
            statement.setInt(5, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public User forgotPassword(String email) {
        String query = "select * from user where email=?";
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet =statement.executeQuery();

            statement.setString(1,email);
            statement.executeUpdate();
            while (resultSet.next()) {
                user = new User();

                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                user.setPassword(resultSet.getString("password"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;

    }
}
