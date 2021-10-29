package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public void editAd(String title, String description, String id) {
        try {
            //update the ads and then set the title & description to what the user inputs but the id stays the same
            String updateQuery = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3, String.valueOf(Integer.parseInt(id)));
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Error editing ad.", e);
         }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public List<Ad> findByTitle(String ad) {
        String query = "SELECT * FROM ads WHERE title LIKE ?";
        String wildCardSearch = "%" + ad + "%";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, wildCardSearch);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an ad by title", e);
        }
    }


    public void delete(long id) {
        String insertQuery = "DELETE FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad with that ID", e);
        }

    }

    @Override
    public List<Ad> findAdByCategory(String category){
    	String searchQuery = "SELECT * FROM ads JOIN ad_category ac ON ads.id = ac.ad_id JOIN categories c ON c.id = ac.category_id WHERE c.name = ?";
    	try{
    		PreparedStatement stmt = connection.prepareStatement(searchQuery);
    		stmt.setString(1, category);
		    ResultSet rs = stmt.executeQuery();
		    return createAdsFromResults(rs);
	    } catch (SQLException throwables) {
		    throw new RuntimeException("Error searching by category.", throwables);
	    }
    }

    public Ad findAdById(long id) {
        String selectQuery = "SELECT * FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(selectQuery);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException throwables) {
            throw new RuntimeException("Error finding ad by ID.", throwables);
        }
    }
}
