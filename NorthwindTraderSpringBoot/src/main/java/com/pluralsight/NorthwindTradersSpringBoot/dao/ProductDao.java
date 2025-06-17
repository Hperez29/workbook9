package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    void add(Product product);
    List<Product> getAll();

    Optional<Product> getById(int id);

    void update(Product product);

    void delete(int id);
}