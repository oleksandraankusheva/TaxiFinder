package org.example;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomPoint {
    private final Random random;
    private static final Logger logger = LogManager.getLogger(RandomPoint.class);
    public RandomPoint() {
        random = new Random();
    }

    public double[] generatePoint() {
        logger.info("Повідомлення lof4j2 з RandomPoint");
        double x = Math.round(random.nextDouble() * 1000) / 10.0;  // Заокруглення до 1 цифри після коми
        double y = Math.round(random.nextDouble() * 1000) / 10.0;  // Заокруглення до 1 цифри після коми
        return new double[]{x, y};
    }
}

