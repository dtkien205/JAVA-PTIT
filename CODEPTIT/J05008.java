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
public class J05008 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Point[] a = new Point[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Point(sc.nextDouble(), sc.nextDouble());
            }
            double area = 0;
            for (int i = 0; i < n; i++) {
                int j = (i + 1) % n;
                area += a[i].getX() * a[j].getY() - a[j].getX() * a[i].getY();
            }
            System.out.printf("%.3f\n", Math.abs(area) / 2.0);
        }
    }
}

class Point {
    double x, y;
    
    Point() {
        
    }
    
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double distance(Point secondPoint) {
        return Math.sqrt(Math.pow(x - secondPoint.x, 2) + Math.pow(y - secondPoint.y, 2));
    }
    
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
    
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}


//2
//3
//0 0
//1 0
//0 1
//4
//0 0
//2 0
//2 2
//0 2