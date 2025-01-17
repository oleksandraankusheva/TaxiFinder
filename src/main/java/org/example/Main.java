package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello! It is a new project!!!");
        logger.info("Повідомлення lof4j2 з main");

        RandomPoint randomPoint = new RandomPoint();
        double[] taxi1Location = randomPoint.generatePoint();
        double[] taxi2Location = randomPoint.generatePoint();
        List<Taxi> taxis = new ArrayList<>();
        taxis.add(new Taxi(1, new Point(taxi1Location[0], taxi1Location[1])));
        taxis.add(new Taxi(2, new Point(taxi2Location[0], taxi2Location[1])));

        Shell shell = new Shell();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Taxi Shell.");

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Order a trip");
            System.out.println("2. Calculate fare");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    double[] orderLocation = randomPoint.generatePoint();
                    Order order = new Order(new Point(orderLocation[0], orderLocation[1]));
                    shell.addCommand(new DisplayTaxisCommand(taxis));
                    shell.addCommand(new FindNearestTaxiCommand(taxis, order));
                    shell.run();
                    break;
                case "2":
                    System.out.print("Enter distance (km): ");
                    double distance = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter time (minutes): ");
                    double time = Double.parseDouble(scanner.nextLine());
                    shell.addCommand(new CalculateFareCommand(distance, time));
                    shell.run();
                    break;
                case "3":
                    System.out.println("Exiting the shell...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}