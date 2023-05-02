package am.hitech.jdbc.repo;

import am.hitech.jdbc.model.Account;
import am.hitech.jdbc.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepo {

    Connection connection = DataSource.getConnection();


    public void transfer(int fromUserId, int toUserId, int amount) {


        String addBalance = "update account set balance = balance + ? where user_id = ?";

        String deductBalance = "update account set balance  =  balance - ?  where user_id = ?";
        try {
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(addBalance);
            statement.setInt(1, amount);
            statement.setInt(2, fromUserId);
            statement.executeUpdate();


            statement = connection.prepareStatement(deductBalance);
            statement.setInt(1, amount);
            statement.setInt(2, toUserId);
            statement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    public List<Account> accountBuilder(ResultSet resultSet) {
        List<Account> accounts = new ArrayList<>();
        Account account = null;

        try {


            while (resultSet.next()) {
                account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setBalance(resultSet.getInt("balance"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setUserId(resultSet.getInt("user_id"));

                accounts.add(account);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public void update(String name,int id){
        String query = "update account set username=? where user_id = ? ";
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2,id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int creatAccount(Account account){
        String query= "insert into account values(0,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,account.getUsername());
            statement.setString(2,account.getPassword());
            statement.setInt(3,account.getBalance());
            statement.setInt(4,account.getUserId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int deleteAccount(int id) {
        String query = "delete from account where id =" + id;

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
