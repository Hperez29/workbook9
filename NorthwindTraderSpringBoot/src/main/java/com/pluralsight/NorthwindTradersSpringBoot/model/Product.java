package com.pluralsight.NorthwindTradersSpringBoot.model;

public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;

    // Constructors
    public Product() { }
    public Product(int productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    // (Optional) setters for mutability
}