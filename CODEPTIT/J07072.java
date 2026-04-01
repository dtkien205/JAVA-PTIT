/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07072 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        
        List<String> ds = new ArrayList<>();
        while(sc.hasNext()) {
            String s = sc.nextLine();
            
            if (s.isEmpty()) {
                continue;
            }
            
            String res = "";
            String[] t = s.trim().toLowerCase().split("\\s+");
            for (int i = 0; i < t.length; i++) {
                res += t[i].toUpperCase().charAt(0) + t[i].substring(1) + " ";
            }
            ds.add(res.trim());
        }
        ds.sort((a, b) -> {
            String[] t1 = a.split("\\s+");
            String[] t2 = b.split("\\s+");
            
            String ten1 = t1[t1.length - 1];
            String ten2 = t2[t2.length - 1];
            
            String ho1 = t1[0];
            String ho2 = t2[0];
            
            if (!ten1.equals(ten2)) return ten1.compareTo(ten2);
            if (!ho1.equals(ho2)) return ho1.compareTo(ho2);
            return a.compareTo(b);
        });
        for (String x : ds) System.out.println(x);
    }
}
