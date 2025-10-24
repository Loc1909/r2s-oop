package org.example.session03;

import java.util.Scanner;

public class Statue extends Item {
    private int weight;
    private String color;

    public Statue() {
        super();
    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(int weight) {
        if (weight < 0 || weight > 1000) {
            throw new IllegalArgumentException("Weight must be between 0 and 1000");
        }
        this.weight = weight;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }
        this.color = color;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight (0-1000): ");
        weight = Integer.parseInt(sc.nextLine());
        setWeight(weight);

        System.out.print("Enter color: ");
        color = sc.nextLine();
        setColor(color);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Weight: %d, Color: %s", weight, color);
    }
}
