package org.example.session04;

import java.util.Scanner;

public class Program {
    private Product[] products;
    private byte numOfProduct;
    private static final byte MAX = 100;

    public Program() {
        products = new Product[MAX];
        numOfProduct = 0;
    }

    public boolean isIdExist(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getId() == id) return true;
        }
        return false;
    }

    private boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    private String readNonEmptyString(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (isEmpty(input)) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (isEmpty(input));
        return input;
    }

    public void addProduct(Product product) {
        if (numOfProduct >= MAX) {
            System.out.println("Product list is full!");
            return;
        }
        if (isIdExist(product.getId())) {
            System.out.println("Error: ID already exists!");
            return;
        }
        products[numOfProduct++] = product;
        System.out.println("Product added successfully.");
    }

    public void displayProducts() {
        if (numOfProduct == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("=== Product List ===");
        for (int i = 0; i < numOfProduct; i++) {
            System.out.println(products[i]);
        }
    }

    public Product findProduct(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        byte choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Find Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Byte.parseByte(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("1. Electronics");
                    System.out.println("2. Clothing");
                    System.out.print("Choose product type: ");
                    byte type = Byte.parseByte(scanner.nextLine());

                    int id = Integer.parseInt(p.readNonEmptyString(scanner, "Enter ID: "));
                    //int id = Integer.parseInt(scanner.nextLine());
                    String name = p.readNonEmptyString(scanner, "Enter Name: ");
                    float price = Float.parseFloat(p.readNonEmptyString(scanner, "Enter Price: "));
                    // float price = Float.parseFloat(scanner.nextLine());


                    if (type == 1) {
                        String brand = p.readNonEmptyString(scanner, "Enter Brand: ");
                        p.addProduct(new Electronics(id, name, price, brand));
                    } else if (type == 2) {
                        String size = p.readNonEmptyString(scanner, "Enter Size: ");
                        p.addProduct(new Clothing(id, name, price, size));
                    } else {
                        System.out.println("Invalid type!");
                    }
                    break;

                case 2:
                    p.displayProducts();
                    break;

                case 3:
                    int searchId = Integer.parseInt(p.readNonEmptyString(scanner, "Enter product ID to find: "));
                    Product found = p.findProduct(searchId);
                    if (found != null)
                        System.out.println("Found: " + found);
                    else
                        System.out.println("Product not found!");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
