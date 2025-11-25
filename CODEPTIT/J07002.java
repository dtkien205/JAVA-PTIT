/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;
import java.util.*;
import java.io.*;
/**
 *
 * @author PC
 */
public class J07002 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DATA.in"));
        
        long sum = 0;
        while(sc.hasNext()){
            String x = sc.next();
            try {
                sum += Integer.parseInt(x);
            } catch (NumberFormatException e) {
                
            }
        }
        System.out.print(sum);
    }
}
