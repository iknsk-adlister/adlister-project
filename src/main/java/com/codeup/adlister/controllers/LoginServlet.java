package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")

public class LoginServlet extends HttpServlet {
    private int counter = 0; 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
          //if it runs that 1 It's
        counter += 1;
        if(counter > 1)  {
            request.setAttribute("invalidLogin", true);
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (username!=null && username!=" " || password!=null && password!=" ") {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
           // response.getWriter().append("Sucessful Login!");
        } else{
            response.sendRedirect("login.jsp"); //error
            HttpSession session=request.getSession(true);
            session.setAttribute("invalidLogin", "Invalid Login ");
            response.sendRedirect("/login");//original
            return; //original
        }

      
        //original code
      boolean validAttempt = Password.check(password, user.getPassword());

      if (validAttempt) {
          request.getSession().setAttribute("user", user);
          response.sendRedirect("/home");
      } else {
          response.sendRedirect("/login");
      }

    }
}
