package am.hitech.jdbc.model;

import am.hitech.jdbc.util.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {


    }

    public static List getAllUsers() throws SQLException {
        User user = null;
        List<User> list = new ArrayList<>();

        String query = "select * from user";
        Connection connection = DataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");

            user = new User(id, first_name, lastName, email, age);
            list.add(user);
        }
        return list;
    }

}
