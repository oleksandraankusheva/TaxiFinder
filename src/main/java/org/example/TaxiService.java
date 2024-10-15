package org.example;

public class TaxiService {

        private static final double baseFare = 30.0;
        private static final double costPerKm = 10.0;
        private static final double costPerMinute = 2.0;

        public static double calculateFare(double distanceTrip, double timeInMinutes) {
            double tripCost = (distanceTrip * costPerKm) + (timeInMinutes * costPerMinute);

            return baseFare + tripCost;
        }
}