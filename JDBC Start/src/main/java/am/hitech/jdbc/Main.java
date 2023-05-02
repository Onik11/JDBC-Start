package am.hitech.jdbc;

import am.hitech.jdbc.repo.PhoneNumbersRepo;
import am.hitech.jdbc.service.AccountService;
import am.hitech.jdbc.service.UserService;
import am.hitech.jdbc.util.exceptions.InternalServerError;
import am.hitech.jdbc.util.exceptions.NotFoundException;

import java.sql.SQLException;

public class Main {
    UserService userService = new UserService();
    AccountService accountService = new AccountService();

    public static void main(String[] args) throws SQLException, NotFoundException, InternalServerError {
        Main main = new Main();
//        User user = main.userService.getById(1);
//        System.out.println(user);

//    List<User> users = main.userService.findAdults(18);
//        System.out.println(users);
//        System.out.println(users);

//    System.out.println(main.userService.findUsers("T"));
//        main.userService.creatUser(new User(1,"Onik","Abgaryan","onik@gmail.com", 25));
//        main.userService.update("Ono", 8);

//main.transfer(1,4,10);
//        PhoneNumbersRepo numbersRepo = new PhoneNumbersRepo();
//        System.out.println(numbersRepo.getInfo());

        System.out.println(main.userService.checkUser("tom@gmail.com",1234));

    }


}

/*
preperstatmentov grel bolor funkcianery adressi hamar
mek el get by user id funkcia


 */