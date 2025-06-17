package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.northwindtradersapi.models.Category;
import java.util.List;

public interface CategoryDao {
    List<Category> getAll();
    Category getById(int id);
    int createCategory(Category category);
    int updateCategory(int id, String newName);
    int deleteCategory(int id);
}

