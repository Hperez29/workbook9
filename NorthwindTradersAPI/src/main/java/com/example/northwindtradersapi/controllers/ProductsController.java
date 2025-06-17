package com.example.northwindtradersapi.controllers;

import com.example.northwindtradersapi.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Chai", 1, 18.0),
            new Product(2, "Chang", 1, 19.0),
            new Product(3, "Aniseed Syrup", 2, 10.0),
            new Product(4, "Chef Anton's Cajun Seasoning", 2, 22.0),
            new Product(5, "Chef Anton's Gumbo Mix", 2, 21.35)
    ));

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Double price) {

        return products.stream()
                .filter(p -> name == null || p.getProductName().toLowerCase().contains(name.toLowerCase()))
                .filter(p -> categoryId == null || p.getCategoryId() == categoryId)
                .filter(p -> price == null || p.getUnitPrice() == price)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst()
                .orElse(null);
    }
}