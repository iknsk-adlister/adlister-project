package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = (String) request.getSession().getAttribute("homeSearch");
        request.setAttribute("ads", DaoFactory.getAdsDao().findByTitle(userInput));

        request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("ads-btn") != null) {
            request.setAttribute("ads", DaoFactory.getAdsDao().findByTitle(request.getParameter("search-ads")));
        } else if (request.getParameter("users-btn") != null) {
            request.setAttribute("ads", DaoFactory.getAdsDao().findAdByUsername(request.getParameter("search-users")));
        } else if (request.getParameter("categories-btn") != null) {
            request.setAttribute("ads", DaoFactory.getAdsDao().findAdByCategory(request.getParameter("search-categories")));
        }

        request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
    }
}
