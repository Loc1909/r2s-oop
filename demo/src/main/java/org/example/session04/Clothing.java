package org.example.session04;

public class Clothing extends Product {
    private String size;

    public Clothing(int id, String name, float price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "[Clothing] " + super.toString() + ", Size: " + size;
    }
}