package org.example.session04;

public class Electronics extends Product {
    private String brand;

    public Electronics(int id, String name, float price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "[Electronics] " + super.toString() + ", Brand: " + brand;
    }
}
