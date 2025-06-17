package com.example.northwindtradersapi.models;

public class Product {
    private final int productId;
    private final String productName;
    private final int categoryId;
    private final double unitPrice;

    public Product(int productId, String productName, int categoryId, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public int getProductId() { return productId; }

    public String getProductName() { return productName; }

    public int getCategoryId() { return categoryId; }

    public double getUnitPrice() { return unitPrice; }
}