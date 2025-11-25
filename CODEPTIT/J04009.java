package javacodeptit;
import java.util.*;

public class J04009 {
    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public static double distance(Point a, Point b) {
            double dx = a.x - b.x;
            double dy = a.y - b.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p3 = new Point(sc.nextDouble(), sc.nextDouble());

            double a = Point.distance(p1, p2);
            double b = Point.distance(p1, p3);
            double c = Point.distance(p2, p3);

            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("INVALID");
            } else {
                double p = (a + b + c) / 2;
                double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.printf("%.2f\n", area);
            }
        }
    }
}
