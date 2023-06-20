package com.pharmacystore.dao;

import java.util.List;

import com.pharmacystore.pojo.Category;

public interface CategoryDao {

	boolean addCategory(Category category);
	boolean deleteCategory(int catid);
	List<Category> getAllCategories();
}
