package org.example;

public class Point {
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
