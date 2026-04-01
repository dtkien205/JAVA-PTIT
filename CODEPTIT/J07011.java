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
public class J07011 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().toLowerCase().split("[^a-z0-9]");
            
            for (String w : p) {
                if (w.isEmpty()) continue;
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int c = Integer.compare(b.getValue(), a.getValue()); 
            if (c != 0) return c;
            return a.getKey().compareTo(b.getKey());             
        });

        list.forEach(x -> {
            System.out.println(x.getKey() + " " + x.getValue());
        });
        
    }
}
