package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="EditDeleteServlet", urlPatterns = "/ads/editads")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        }


        long id = Long.parseLong(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().findById(id);

        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("title", ad.getTitle());
        request.setAttribute("description", ad.getDescription());
        request.getRequestDispatcher("/WEB-INF/ads/editads.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if (title == null || title.isEmpty()) {
            response.sendRedirect("/ads/editads?id=" + id + "&errorMessage=TitleNull");
            return;
        }
        if (description == null || description.isEmpty()) {
            response.sendRedirect("/ads/editads?id=" + id + "&errorMessage=DescriptionNull");
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(id, user.getId(), title, description);
        DaoFactory.getAdsDao().edit(ad);
        response.sendRedirect("/home");
    }
}
