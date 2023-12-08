package Exercises;

import java.util.Comparator;
import java.util.List;

public class Exercise7{
    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public double distanceToOrigin() {
            return Math.sqrt(x * x + y * y);
        }

        public static List<Point> kClosestToOrigin(List<Point> A, int k) {

            Comparator<Point> comparator = Comparator.comparingDouble(Point::distanceToOrigin);

            return Exercise6.kSmallest(A, k, comparator);
        }

    }
    public static void main(String[] args) {

        List<Point> points = List.of(new Point(1, 2), new Point(3, 4), new Point(5, 6), new Point(0, 0));

        List<Point> closestPoints = Point.kClosestToOrigin(points,3);


        System.out.println(closestPoints);
    }
}




