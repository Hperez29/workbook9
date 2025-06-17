package com.example.northwindtradersapi.controllers;

import com.example.northwindtradersapi.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private List<Category> categories = new ArrayList<>(List.of(
            new Category(1, "Beverages"),
            new Category(2, "Condiments"),
            new Category(3, "Confections")
    ));

    @GetMapping
    public List<Category> getAllCategories(@RequestParam(required = false) String name) {
        return categories.stream()
                .filter(c -> name == null || c.getCategoryName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categories.stream()
                .filter(c -> c.getCategoryId() == id)
                .findFirst()
                .orElse(null);
    }
}