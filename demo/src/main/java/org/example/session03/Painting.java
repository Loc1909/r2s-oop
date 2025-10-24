package org.example.session03;

import java.util.Scanner;

public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    // Constructors
    public Painting() {
        super();
    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        this.height = height;
        this.width = width;
        this.isWaterColor = isWaterColor;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setHeight(int height) {
        if (height < 0 || height > 2000) {
            throw new IllegalArgumentException("Height must be between 0 and 2000");
        }
        this.height = height;
    }

    public void setWidth(int width) {
        if (width < 0 || width > 3000) {
            throw new IllegalArgumentException("Width must be between 0 and 3000");
        }
        this.width = width;
    }

    public void setWaterColor(boolean waterColor) {
        isWaterColor = waterColor;
    }

    public void setFramed(boolean framed) {
        isFramed = framed;
    }

    @Override
    public void input() {
        super.input();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter height (0-2000): ");
        height = sc.nextInt();
        setHeight(height);

        System.out.print("Enter width (0-3000): ");
        width = sc.nextInt();
        setWidth(width);

        System.out.print("Is it water color? (true/false): ");
        isWaterColor = sc.nextBoolean();

        System.out.print("Is it framed? (true/false): ");
        isFramed = sc.nextBoolean();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Height: %d, Width: %d, WaterColor: %b, Framed: %b",
                height, width, isWaterColor, isFramed);
    }
}
