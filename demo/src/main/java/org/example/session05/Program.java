package org.example.session05;

import java.util.Scanner;

public class Program {
    private static final int ADD_PRODUCT = 1;
    private static final int RETRIEVE_PRODUCT = 2;
    private static final int UPDATE_PRODUCT = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Product Management Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Retrieve Product by ID");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case ADD_PRODUCT:
                    try {
                        System.out.println("Enter product details:");
                        System.out.print("Product ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Product Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Product Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Quantity in Stock: ");
                        int quantity = scanner.nextInt();

                        pm.addProduct(new Product(id, name, price, quantity));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case RETRIEVE_PRODUCT:
                    try {
                        System.out.print("Enter Product ID to retrieve: ");
                        int retrieveID = scanner.nextInt();
                        Product product = pm.getProductByID(retrieveID);
                        product.displayProductInfo();
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case UPDATE_PRODUCT:
                    try {
                        System.out.print("Enter Product ID to update: ");
                        int updateID = scanner.nextInt();
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        pm.updateProductQuantity(updateID, newQuantity);
                    } catch (ProductNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case EXIT:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != EXIT);
    }
}
