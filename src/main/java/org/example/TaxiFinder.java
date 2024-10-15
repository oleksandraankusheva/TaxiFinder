package org.example;

import java.util.ArrayList;
import java.util.List;


public class TaxiFinder {
    public static void main(String[] args) {
        List<Taxi> taxis = new ArrayList<>();
        taxis.add(new Taxi(1, new Point(1, 3)));
        taxis.add(new Taxi(2, new Point(5, 1)));

        Order order = new Order(new Point(3, 4));

        Taxi nearestTaxi = findNearestTaxi(taxis, order);
        System.out.println("Near Taxi: " + nearestTaxi.id);
        }

        public static double calculateDistance(Point p1, Point p2)
        {
            return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        }

    public static Taxi findNearestTaxi(List<Taxi> taxis, Order order) {
        Taxi nearestTaxi = null;
        double minDistance = Double.MAX_VALUE;

        for (Taxi taxi : taxis) {
            double distance = calculateDistance(taxi.location, order.location);
            if (distance < minDistance) {
                minDistance = distance;
                nearestTaxi = taxi;
            }
        }

        return nearestTaxi;
    }
    }
