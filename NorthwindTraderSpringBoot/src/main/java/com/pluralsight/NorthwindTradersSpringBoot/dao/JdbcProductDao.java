package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Product product) {
        String sql = "INSERT INTO products (product_id, name, category, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getProductId(), product.getName(), product.getCategory(), product.getPrice());
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Product(
                rs.getInt("product_id"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getDouble("price")
        ));
    }

    @Override
    public Optional<Product> getById(int id) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        try {
            Product product = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Product(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price")
            ));
            return Optional.ofNullable(product);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, category = ?, price = ? WHERE product_id = ?";
        jdbcTemplate.update(sql, product.getName(), product.getCategory(), product.getPrice(), product.getProductId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        jdbcTemplate.update(sql, id);
    }
}