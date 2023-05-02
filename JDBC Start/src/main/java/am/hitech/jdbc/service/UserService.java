package am.hitech.jdbc.service;

import am.hitech.jdbc.model.User;
import am.hitech.jdbc.repo.UserRepo;
import am.hitech.jdbc.util.exceptionMassege.ErrorMassage;
import am.hitech.jdbc.util.exceptions.InternalServerError;
import am.hitech.jdbc.util.exceptions.NotFoundException;

import java.util.List;
import java.util.Random;

public class UserService {
    UserRepo userRepo = new UserRepo();

    public List<User> getById(int id) throws NotFoundException, InternalServerError {
        try {
            List<User> user = userRepo.getById(id);
            if (user == null) {
                throw new NotFoundException(ErrorMassage.NOT_FOUND_USER);
            }
            return user;
        } catch (RuntimeException e) {
            throw new InternalServerError(ErrorMassage.ANOTHER_ERROR_MASSAGE);
        }
    }



    public List<User> getByUsername(String username) throws NotFoundException {
        try {
           List<User> user = userRepo.getByUsername(username);
            if (user == null) {
                throw new NotFoundException(ErrorMassage.NOT_FOUND_USER);
            }
            return user;
        } catch (RuntimeException e) {
            throw new InternalError(ErrorMassage.ANOTHER_ERROR_MASSAGE);
        }
    }
    public List<User> findAdults(int age) throws NotFoundException, InternalServerError {
        try {
            List<User> users = userRepo.findAdults(age);
        if (users.size()==0){
            throw new NotFoundException(ErrorMassage.NOT_FOUND_USER);
        }
        return users;
        }catch (RuntimeException e){
            throw new InternalServerError(ErrorMassage.ANOTHER_ERROR_MASSAGE);
        }
    }
    public List<User> findUsers(String s) throws NotFoundException, InternalServerError {
        try {
            List<User> users = userRepo.findUsers(s);
            if (users.size()==0){
                throw new NotFoundException(ErrorMassage.NOT_FOUND_USER);
            }
            return users;
        }catch (RuntimeException e) {
            throw new InternalServerError(ErrorMassage.ANOTHER_ERROR_MASSAGE);
        }
    }
    public void creatUser(User user) throws InternalServerError {
        int row = userRepo.creatUserV2(user);
        if (row==0){
            throw new InternalServerError(ErrorMassage.ANOTHER_ERROR_MASSAGE);
        }
    }
    public void update(String name, int id){
        userRepo.update(name,id);
    }
    public User checkUser(String username, int password){
        User user=null;
        try {
             user=userRepo.checkUser(username,password);
            if (user==null){
                throw new NotFoundException(ErrorMassage.WRONG_LOGIN_OR_PASSWORD);
            }

        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return user;


    }
    public void register(String name,String surname,String email,int age, int password){
       userRepo.register(name,surname,email,age,password);

    }
    public User forgotPassword(String email){
        User user = userRepo.forgotPassword(email);
        String s = randomString();
        user.setPasswordToken(s);

    }
    public String randomString(){
        String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder sb= new StringBuilder();
        Random random = new Random();
        int length = 6;
        for (int i = 0; i <length ; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }

}
