package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.northwindtradersapi.dao.CategoryDao;
import com.pluralsight.northwindtradersapi.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoryDao categoryDao;

    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public List<Category> getAllCategories(@RequestParam(required = false) String name) {
        List<Category> categories = categoryDao.getAll();
        if (name != null && !name.isEmpty()) {
            categories.removeIf(c -> !c.getCategoryName().toLowerCase().contains(name.toLowerCase()));
        }
        return categories;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category category = categoryDao.getById(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        int rowsAffected = categoryDao.createCategory(category);
        return rowsAffected > 0 ? ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully.")
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create category.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable int id, @RequestBody Category category) {
        int rowsAffected = categoryDao.updateCategory(id, category.getCategoryName());
        return rowsAffected > 0 ? ResponseEntity.ok("Category updated successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        int rowsAffected = categoryDao.deleteCategory(id);
        return rowsAffected > 0 ? ResponseEntity.ok("Category deleted successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found.");
    }
}