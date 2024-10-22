package org.example;

public class Order {
    Point location;
    public Order(Point location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Order at location " + location;
    }
}
