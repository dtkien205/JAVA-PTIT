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
public class J04014 {
    public static long gcd(long a, long b){
        while(b != 0){
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a + b;
    }
    
    public static void main(String[] args){
        long a = sc.nextLong(), b = sc.nextLong();
        long c = sc.nextLong(), d = sc.nextLong();
    }
}
