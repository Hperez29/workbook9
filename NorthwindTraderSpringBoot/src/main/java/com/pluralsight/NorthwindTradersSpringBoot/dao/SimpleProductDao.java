package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleProductDao implements ProductDao {
    private final List<Product> products = new ArrayList<>();

    @com.pluralsight.NorthwindTradersSpringBoot.dao.PostConstruct
    public void setupDefaults() {
        products.add(new Product(1, "Apple", "Fruit", 0.99));
        products.add(new Product(2, "Laptop", "Electronics", 999.99));
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    @Override
    public Optional<Product> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }
}