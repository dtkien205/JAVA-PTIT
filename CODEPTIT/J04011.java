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
public class J04011 {
    static class Point3D {
        int x, y, z;
        
        Point3D(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        static Point3D subtract(Point3D a, Point3D b){
            return new Point3D(a.x - b.x, a.y - b.y, a.z - b.z);
        }
        
        static Point3D cross(Point3D a, Point3D b) {
            return new Point3D(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x
            );
        }
        
        static long dot(Point3D a, Point3D b){
            return 1L * a.x * b.x + 1L * a.y * b.y + 1L * a.z * b.z;
        }
        
        static boolean check(Point3D a, Point3D b, Point3D c, Point3D d){
            Point3D ab = subtract(a, b);
            Point3D ac = subtract(a, c);
            Point3D ad = subtract(a, d);
            
            long tich = dot(cross(ab, ac), ad);
            
            return tich == 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
            if(Point3D.check(p1,p2,p3,p4)){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}
