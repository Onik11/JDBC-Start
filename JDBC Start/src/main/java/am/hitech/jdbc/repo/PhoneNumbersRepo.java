package am.hitech.jdbc.repo;

import am.hitech.jdbc.model.PhoneNumbers;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.util.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumbersRepo {
    Connection connection = DataSource.getConnection();
    UserRepo userRepo = new UserRepo();

    public List<PhoneNumbers> numberBuilder(ResultSet resultSet) {
        List<PhoneNumbers> numbers = new ArrayList<>();
        PhoneNumbers number;

        try {
            while (resultSet.next()) {
                number = new PhoneNumbers();

                number.setNumber(resultSet.getInt("number"));
                number.setUserId(resultSet.getInt("user_id"));
                numbers.add(number);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }

    public List<PhoneNumbers> getAllNumbers() {

        List<PhoneNumbers> numbers;

        String query = "Select number,user_id from phone_numbers ";
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            numbers = numberBuilder(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numbers;

    }

    public List<String> getInfo() {
        List<PhoneNumbers> list = getAllNumbers();
        List<String> info = new ArrayList<>();
        List<User> users = userRepo.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserId() == 0) {
                info.add(list.get(i).getNumber() + " no user");
            } else {
                for (int j = 0; j < users.size(); j++) {
                    if (list.get(i).getUserId() == users.get(j).getId()) {
                        info.add(list.get(i).getNumber() + " " + users.get(j).getFirstName() + " " + users.get(j).getLastName());
                    }
                }
            }
        }
        return info;

    }

}
