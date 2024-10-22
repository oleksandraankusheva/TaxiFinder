package org.example;
import java.util.Random;

public class RandomPoint {
    private final Random random;

    public RandomPoint() {
        random = new Random();
    }

    public double[] generatePoint() {
        double x = Math.round(random.nextDouble() * 1000) / 10.0;  // Заокруглення до 1 цифри після коми
        double y = Math.round(random.nextDouble() * 1000) / 10.0;  // Заокруглення до 1 цифри після коми
        return new double[]{x, y};
    }
}
    class Point {
        double x;
        double y;

        public Point(double x, double y) {
            if (x < 0 || y < 0) {
                throw new IllegalArgumentException("Negative coordinates.");
            }
            this.x = x;
            this.y = y;
        }
        @Override
        public  String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

