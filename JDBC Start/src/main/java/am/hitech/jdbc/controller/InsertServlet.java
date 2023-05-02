package am.hitech.jdbc.controller;

import am.hitech.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm_password");

        UserService userService = new UserService();


        if (password.equals(confirm)) {
            userService.register(name, surname, email, Integer.parseInt(age), Integer.parseInt(password));
            resp.sendRedirect("index.html");
        } else {
            printWriter.write("Wrong confirm password");
        }
    }
}

/*
registracia aneluc adressn el save ani

userin avelacnum enq reset password (password token)
verification code
 */
