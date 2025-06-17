package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.northwindtradersapi.models.Product;
import java.util.List;

public interface ProductDao {
    List<Product> getAll();
    Product getById(int id);
}