package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", value = "/user/update")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }


        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("email", user.getEmail());
        request.setAttribute("username", user.getUsername());

        request.getRequestDispatcher("/WEB-INF/users/update.jsp")
                .forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        if (username.isEmpty()) {
            response.sendRedirect("/user/edit?errorMessage=UsernameEmpty");
            return;
        }

        if (email.isEmpty()) {
            response.sendRedirect("/user/edit?errorMessage=EmailEmpty");
            return;
        }

        User userTester = new User(username, email); //make userTester to check validity
        User user = (User) request.getSession().getAttribute("user"); //get current user

        boolean checkUsername = user.getUsername().equals(userTester.getUsername());

        boolean checkEmail = user.getEmail().equals(userTester.getEmail());

        if (DaoFactory.getUsersDao().check(userTester) && !checkUsername) { //check if username already exists
            response.sendRedirect("/user/update?errorMessage=UsernameDuplicate");
            return;
        }

        if(!DaoFactory.getUsersDao().emailInputIsValid(email)) { // email is correct format
            response.sendRedirect("/user/update?errorMessage=EmailInvalid");
            return;
        }

        if(DaoFactory.getUsersDao().emailDuplicates(userTester) && !checkEmail) { //Verify unique email
            response.sendRedirect("/user/edit?errorMessage=EmailDuplicate");
            return;
        }

        user.setUsername(username);
        user.setEmail(email);
        DaoFactory.getUsersDao().update(user);
        response.sendRedirect("/profile");
    }


}
