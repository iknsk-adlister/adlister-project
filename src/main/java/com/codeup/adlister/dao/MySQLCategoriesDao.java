package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
	private Connection connection;

	public MySQLCategoriesDao(Config config){
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
	public Category findCategory(Category category) {
		String query = "SELECT * FROM categories WHERE name = ? LIMIT 1";
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, category.getName());
			return extractCategory(stmt.executeQuery());
		} catch (SQLException e) {
			throw new RuntimeException("Error finding a user by username", e);
		}
	}

	@Override
	public Long insert(Category category) {
		try {
			String insertQuery = "INSERT INTO categories(name) VALUE (?)";
			PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, category.getName());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);
		} catch (SQLException e) {
			throw new RuntimeException("Error creating a new category.", e);
		}
	}

	@Override
	public List<Category> all() {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM categories");
			ResultSet rs = stmt.executeQuery();
			return createCategoriesFromResults(rs);
		} catch (SQLException e) {
			throw new RuntimeException("Error retrieving all categories.", e);
		}
	}

	private Category extractCategory(ResultSet rs) throws SQLException {
		if (! rs.next()) {
			return null;
		}
		return new Category(
				rs.getLong("id"),
				rs.getString("name")
		);
	}

	private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
		List<Category> categories = new ArrayList<>();
		while (rs.next()) {
			categories.add(extractCategory(rs));
		}
		return categories;
	}

}
