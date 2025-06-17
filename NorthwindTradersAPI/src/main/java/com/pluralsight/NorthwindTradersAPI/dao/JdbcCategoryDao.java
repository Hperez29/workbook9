package com.pluralsight.northwindtradersapi.dao;

import com.pluralsight.northwindtradersapi.models.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcCategoryDao implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCategoryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Category> categoryRowMapper = (rs, rowNum) -> {
        int id = rs.getInt("CategoryID");
        String name = rs.getString("CategoryName");
        return new Category(id, name);
    };

    @Override
    public List<Category> getAll() {
        String sql = "SELECT CategoryID, CategoryName FROM Categories";
        return jdbcTemplate.query(sql, categoryRowMapper);
    }

    @Override
    public Category getById(int id) {
        String sql = "SELECT CategoryID, CategoryName FROM Categories WHERE CategoryID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, categoryRowMapper);
    }
}
