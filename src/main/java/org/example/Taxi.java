package org.example;

public class Taxi {
    int id;
    Point location;
    public Taxi(int id, Point location) {
        this.id = id;
        this.location = location;
    }
    @Override
    public String toString() {
        return "Taxi " + id + " at location " + location;
    }
}
