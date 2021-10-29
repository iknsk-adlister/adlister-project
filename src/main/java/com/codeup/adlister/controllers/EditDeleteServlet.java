package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="EditDeleteServlet", urlPatterns = "/ads/edit")
public class EditDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("ad id");
        String title = request.getParameter("ad title");
        String description = request.getParameter("ad description");
        String delete = request.getParameter("ad delete");
    if (title != null || description != null)
        DaoFactory.getAdsDao().editAd(title, description, id);
    }
//    if (delete != null)
//        DaoFactory.getAdsDao().editAd()
}
