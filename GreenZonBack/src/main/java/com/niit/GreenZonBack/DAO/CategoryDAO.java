package com.niit.GreenZonBack.DAO;

import java.util.List;

import com.niit.GreenZonBack.Model.Category;

public interface CategoryDAO 
	{
		public boolean addCategory(Category category);
		public List<Category> showAllCategory();
		public boolean deleteCategory(int id);
		public Category showCategory(int id);
	}
