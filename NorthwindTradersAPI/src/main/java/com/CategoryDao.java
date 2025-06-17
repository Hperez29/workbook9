package com.pluralsight.northwindtradersapi.dao;

import com.pluralsight.northwindtradersapi.models.Category;
import java.util.List;

public interface CategoryDao {
    List<Category> getAll();
    Category getById(int id);
}