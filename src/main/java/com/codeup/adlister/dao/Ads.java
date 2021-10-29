package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    void editAd(String title, String description, String id);
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // find an ad by title
    List<Ad> findByTitle(String adTitle);

    List<Ad> findAdByCategory(String category);

    void delete(long id);
}


// define an edit adMethod and a delete adMethod
// implement those methods from the interface into the MySQLAdsDao
// test it by adding the method into the adsDao
// make sure you have a way in the user interface for the user to decide whether they want to edit/delete an ad
// make sure that there are servlets that are mapped to those requests from the user to edit/delete an ad
// use ur DAO methods to do so in the servlet