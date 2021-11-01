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
        String deleteCategoryQuery = "DELETE FROM ad_category WHERE ad_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(deleteCategoryQuery);
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad with that Category", e);
        }
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
    public Ad findById(long id) {
        try {
            String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractAd(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a Ad by Id", e);
        }
    }

    @Override
    public void edit(Ad ad) {
        String query = "update ads set title = ?, description = ? where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad", e);
        }
    }

    @Override
    public List<Ad> findAdByCategory(String category){
    	String searchQuery = "SELECT * FROM ads JOIN ad_category ac ON ads.id = ac.ad_id JOIN categories c ON c.id = ac.category_id WHERE c.name LIKE ?";
        String wildCard = "%" + category + "%";
    	try{
    		PreparedStatement stmt = connection.prepareStatement(searchQuery);
    		stmt.setString(1, wildCard);
		    ResultSet rs = stmt.executeQuery();
		    return createAdsFromResults(rs);
	    } catch (SQLException throwables) {
		    throw new RuntimeException("Error searching by category.", throwables);
	    }
    }

    @Override
    public List<Ad> getByUserId(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads where user_id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long findUserId(long id) {
        try {
            String query = "SELECT user_id FROM ads WHERE id = ? LIMIT 1";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getLong("user_id");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a Ad by Id", e);
        }
    }


    public List<Ad> findAdByUsername(String username) {
        String query = "SELECT * FROM ads JOIN users u on u.id = ads.user_id WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = (stmt.executeQuery());
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
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
