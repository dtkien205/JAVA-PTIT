/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;
import java.util.*;
/**
 *
 * @author PC
 */
public class J04008 {
    static class Point {
        private double x, y;
        
        Point(){   
        }
        
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
        
        Point(Point p){
            this.x = p.x;
            this.y = p.y;
        }
        
        public double getX(){
            return x;
        }
        public double getY(){
            return y;
        }
        
        public double distance(Point secondPoint){
            double dx = this.x - secondPoint.x;
            double dy = this.y - secondPoint.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
        
        public static double distance(Point p1, Point p2){
            double dx = p1.x - p2.x;
            double dy = p1.y - p2.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p3 = new Point(sc.nextDouble(), sc.nextDouble());
            
            double a = Point.distance(p1, p2);
            double b = Point.distance(p1, p3);
            double c = Point.distance(p3, p2);
            
            if(a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("INVALID");
            } else {
                System.out.printf("%.3f\n", a + b + c);
            }
        }
    }
}
