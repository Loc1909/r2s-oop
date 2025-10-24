package org.example.session03;

import java.util.Scanner;

public class ItemList {
    private Item[] list;
    private int numOfItem;
    private final int MAX = 100;

    public ItemList() {
        list = new Item[MAX];
        numOfItem = 0;
    }

    public boolean isIdExist(String id) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean addItem(Item item) {
        if (item == null || numOfItem >= MAX || isIdExist(item.getId())) {
            return false;
        }

        list[numOfItem] = item;
        numOfItem++;

        return true;
    }

    // This method prints out information of all items
    public void displayAll() {
        if (numOfItem == 0) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("\n=== All Items ===");
        for (int i = 0; i < numOfItem; i++) {
            System.out.println((i + 1) + ". " + list[i].toString());
        }
    }

    public Item findItem(String creator) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equalsIgnoreCase(creator)) {
                return list[i];
            }
        }
        return null;
    }

    public void displayItemsByType(String type) {
        boolean found = false;

        if (type.equalsIgnoreCase("Vase")) {
            System.out.println("\n=== Vase Items ===");
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println((i + 1) + ". " + list[i]);
                    found = true;
                }
            }
        } else if (type.equalsIgnoreCase("Statue")) {
            System.out.println("\n=== Statue Items ===");
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println((i + 1) + ". " + list[i]);
                    found = true;
                }
            }
        } else {
            System.out.println("\n=== Painting Items ===");
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println((i + 1) + ". " + list[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No " + type + " items found.");
        }
    }
}
