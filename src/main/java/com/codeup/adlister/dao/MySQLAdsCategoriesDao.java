package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCategory;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLAdsCategoriesDao implements AdsCategories{
	private Connection connection;

	public MySQLAdsCategoriesDao(Config config){
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
	public long insert(AdCategory adCategory) {
		try {
			String insertQuery = "INSERT INTO ad_category(ad_id, category_id) VALUES (?, ?)";
			PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, adCategory.getAdId());
			stmt.setLong(2, adCategory.getCategoryId());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);
		} catch (SQLException e) {
			throw new RuntimeException("Error creating a new ad.", e);
		}
	}
}
