package org.example;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello! It is a new project!!!");
        logger.info("Повідомлення lof4j2");

        double distanceTrip = 10.0;
        double timeInMinutes = 15.0;
        RandomPoint randomPoint = new RandomPoint();
        double[] taxi1Location = randomPoint.generatePoint();
        double[] taxi2Location = randomPoint.generatePoint();
        List<Taxi> taxis = new ArrayList<>();
        taxis.add(new Taxi(1, new Point(taxi1Location[0], taxi1Location[1])));
        taxis.add(new Taxi(2, new Point(taxi2Location[0], taxi2Location[1])));

        double[] orderLocation = randomPoint.generatePoint();
        Order order = new Order(new Point(orderLocation[0], orderLocation[1]));

        //TaxiFinder taxiFinder = new TaxiFinder();
        Taxi nearestTaxi = TaxiFinder.findNearestTaxi(taxis, order);
        System.out.println("Near Taxi: " + nearestTaxi.id);

        double fare = TaxiService.calculateFare(distanceTrip, timeInMinutes);
        System.out.println("Загальна вартість проїзду: " + fare + " грн");
        for (Taxi taxi : taxis) {
            System.out.println(taxi);
        }
        System.out.println(order);
    }
}