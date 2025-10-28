package org.example.session05;

public class ProductManagement {
    private Product[] products = new Product[10];
    private int productCount = 0;

    public void addProduct(Product product) throws IllegalArgumentException {
        if (productCount >= 10) {
            throw new IllegalArgumentException("Product array is full. Cannot add more products.");
        }

        if (product.getPrice() < 0 || product.getQuantityInStock() < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }

        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == product.getProductID()) {
                throw new IllegalArgumentException("Product ID already exists.");
            }
        }

        products[productCount] = product;
        productCount++;
        System.out.println("Product added successfully.");
    }

    public Product getProductByID(int productID) throws ProductNotFoundException {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == productID) {
                return products[i];
            }
        }
        throw new ProductNotFoundException("Product with ID " + productID + " not found.");
    }

    public void updateProductQuantity(int productID, int newQuantity) throws ProductNotFoundException, IllegalArgumentException {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative.");
        }

        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == productID) {
                products[i].setQuantityInStock(newQuantity);
                System.out.println("Product quantity updated successfully.");
                return;
            }
        }
        throw new ProductNotFoundException("Product with ID " + productID + " not found.");
    }
}
