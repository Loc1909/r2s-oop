package org.example.session03;

import java.util.Scanner;

public class AntiqueShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();
        int choice;

        do {
            System.out.println("\n=== ANTIQUE SHOP MENU ===");
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by the creator");
            System.out.println("6. Display the list of vase items");
            System.out.println("7. Display the list of statue items");
            System.out.println("8. Display the list of painting items");
            System.out.println("9. Quit");
            System.out.print("Input your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        Vase vase = new Vase();
                        System.out.println("\n--- Add New Vase ---");
                        vase.input();
                        if (itemList.addItem(vase)) {
                            System.out.println("Vase added successfully!");
                        } else {
                            System.out.println("Failed to add vase.");
                        }
                        break;

                    case 2:
                        Statue statue = new Statue();
                        System.out.println("\n--- Add New Statue ---");
                        statue.input();
                        if (itemList.addItem(statue)) {
                            System.out.println("Statue added successfully!");
                        } else {
                            System.out.println("Failed to add statue.");
                        }
                        break;

                    case 3:
                        Painting painting = new Painting();
                        System.out.println("\n--- Add New Painting ---");
                        painting.input();
                        if (itemList.addItem(painting)) {
                            System.out.println("Painting added successfully!");
                        } else {
                            System.out.println("Failed to add painting.");
                        }
                        break;

                    case 4:
                        itemList.displayAll();
                        break;

                    case 5:
                        System.out.print("\nEnter creator name to search: ");
                        String creator = sc.nextLine();
                        Item foundItem = itemList.findItem(creator);
                        if (foundItem != null) {
                            System.out.println("Found: " + foundItem.toString());
                        } else {
                            System.out.println("No item found with creator: " + creator);
                        }
                        break;

                    case 6:
                        itemList.displayItemsByType("Vase");
                        break;

                    case 7:
                        itemList.displayItemsByType("Statue");
                        break;

                    case 8:
                        itemList.displayItemsByType("Painting");
                        break;

                    case 9:
                        System.out.println("Thank you for using Antique Shop Management System!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose 1-9.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 9);
    }
}
