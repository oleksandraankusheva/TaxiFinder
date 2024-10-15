package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! It is a new project!!!");

        double distanceTrip = 10.0;
        double timeInMinutes = 15.0;

        double fare = TaxiService.calculateFare(distanceTrip, timeInMinutes);
        System.out.println("Загальна вартість проїзду: " + fare + " грн");
    }
}