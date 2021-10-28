package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdCategory;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
      
	    Category category = DaoFactory.getCategoriesDao().findCategory(request.getParameter("category"));
	    long categoryId;
	    if(DaoFactory.getCategoriesDao().findCategory(request.getParameter("category")) != null){
	    	categoryId = category.getId();
	    } else {
	    	category = new Category(
	    			request.getParameter("category")
		    );
		   categoryId = DaoFactory.getCategoriesDao().insert(category);
	    }
        long adId = DaoFactory.getAdsDao().insert(ad);

	    AdCategory adCategory = new AdCategory(
	    		adId,
			    categoryId
	    );
	    DaoFactory.getAdsCategoriesDao().insert(adCategory);
        response.sendRedirect("/home");
    }
}
