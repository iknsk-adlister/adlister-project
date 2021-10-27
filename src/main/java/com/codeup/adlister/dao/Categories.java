package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import java.util.List;

public interface Categories {
	Long insert(Category category);

	List<Category> all();
}
