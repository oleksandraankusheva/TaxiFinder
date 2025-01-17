package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


class Shell {
    private final CompositeCommand commands = new CompositeCommand();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void run() {
        commands.execute();
        commands.clear();
    }
}

// Component interface
interface Command {
    void execute();
}

// Leaf command for displaying taxis
class DisplayTaxisCommand implements Command {
    private final List<Taxi> taxis;

    public DisplayTaxisCommand(List<Taxi> taxis) {
        this.taxis = taxis;
    }

    @Override
    public void execute() {
        System.out.println("Available Taxis:");
        for (Taxi taxi : taxis) {
            System.out.println(taxi);
        }
    }
}

// Leaf command for finding the nearest taxi
class FindNearestTaxiCommand implements Command {
    private final List<Taxi> taxis;
    private final Order order;

    public FindNearestTaxiCommand(List<Taxi> taxis, Order order) {
        this.taxis = taxis;
        this.order = order;
    }

    @Override
    public void execute() {
        Taxi nearestTaxi = TaxiFinder.findNearestTaxi(taxis, order);
        System.out.println("Nearest Taxi: " + nearestTaxi.id);
    }
}

// Leaf command for calculating fare
class CalculateFareCommand implements Command {
    private final double distance;
    private final double time;

    public CalculateFareCommand(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    @Override
    public void execute() {
        double fare = TaxiService.calculateFare(distance, time);
        System.out.println("Total Fare: " + fare + " грн");
    }
}

// Composite command
class CompositeCommand implements Command {
    private final List<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);
    }

    public void clear() {
        commands.clear();
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
