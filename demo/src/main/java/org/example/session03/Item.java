package org.example.session03;

import java.util.Scanner;

public class Item {
    protected String id;
    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public Item(String id, int value,  String creator) {
        this.id = id;
        this.value = value;
        this.creator = creator;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be >= 0");
        }
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        if (creator == null || creator.trim().isEmpty()) {
            throw new IllegalArgumentException("Creator cannot be null or empty");
        }
        this.creator = creator;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        id = sc.nextLine();
        setId(id);

        System.out.print("Enter value: ");
        value = Integer.parseInt(sc.nextLine());
        setValue(value);

        System.out.print("Enter creator: ");
        creator = sc.nextLine();
        setCreator(creator);
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Value: %d, Creator: %s", id, value, creator);
    }
}