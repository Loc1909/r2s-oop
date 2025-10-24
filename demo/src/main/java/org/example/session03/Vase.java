package org.example.session03;

import java.util.Scanner;

public class Vase extends Item {
    private int height;
    private String material;

    public Vase() {
        super();
    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }

    public void setHeight(int height) {
        if (height < 0 || height > 2000) {
            throw new IllegalArgumentException("Height must be between 0 and 2000");
        }
        this.height = height;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Material cannot be null or empty");
        }
        this.material = material;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter height (0-2000): ");
        height = Integer.parseInt(sc.nextLine());
        setHeight(height);

        System.out.print("Enter material: ");
        material = sc.nextLine();
        setMaterial(material);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Height: %d, Material: %s", height, material);
    }

}
