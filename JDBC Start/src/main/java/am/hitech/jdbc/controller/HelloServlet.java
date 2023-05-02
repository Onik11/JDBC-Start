package am.hitech.jdbc.controller;

import am.hitech.jdbc.model.User;
import am.hitech.jdbc.repo.PhoneNumbersRepo;
import am.hitech.jdbc.repo.UserRepo;
import am.hitech.jdbc.service.UserService;
import am.hitech.jdbc.util.exceptions.InternalServerError;
import am.hitech.jdbc.util.exceptions.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HelloServlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
//        PhoneNumbersRepo numbers = new PhoneNumbersRepo();
//        List<String> list = numbers.getInfo();
//
//        for (int i = 0; i <list.size() ; i++) {
//            printWriter.write(list.get(i) +"\n");
//
//        }
        String id = request.getParameter("id");

        UserService userService = new UserService();
        User user= new User();
        try {
            user = userService.getById(Integer.parseInt(id)).get(0);

            printWriter.write(user.toString());
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (InternalServerError e) {
            e.printStackTrace();
        }



    }
}
