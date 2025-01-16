package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaxiService {
        private static final Logger logger = LogManager.getLogger(TaxiService.class);

        private static final double baseFare = 30.0;
        private static final double costPerKm = 10.0;
        private static final double costPerMinute = 2.0;

        public static double calculateFare(double distanceTrip, double timeInMinutes) {
            if (distanceTrip < 0 || timeInMinutes < 0) {
                throw new IllegalArgumentException("Negative values.");
            }
            double tripCost = (distanceTrip * costPerKm) + (timeInMinutes * costPerMinute);
            logger.info("Повідомлення lof4j2 з TaxiService");
            return baseFare + tripCost;
        }
}