package am.hitech.jdbc.controller;

import am.hitech.jdbc.model.User;
import am.hitech.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
       String  password = req.getParameter("password");
        PrintWriter printWriter = resp.getWriter();
        UserService userService =  new UserService();
        User user = userService.checkUser(username, Integer.parseInt(password));
        if (user==null){
            printWriter.write("Wrong login or password");
        }
            printWriter.write("welcome home page " + user.getFirstName() + "  " + user.getLastName());

    }

}
/*
userin avelacnum enq password
stanalu enq es 2 parametrov user ka te che
 */