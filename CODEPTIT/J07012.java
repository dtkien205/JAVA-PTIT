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
public class J07012 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<String> ds = (ArrayList<String>) in.readObject();
        
        Map<String, Integer> mp = new TreeMap<>();
        for (String line : ds) {
            String[] t = line.trim().toLowerCase().split("[^a-z0-9]+");
            for (String x : t) {
                if (x.isEmpty()) continue;
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());
        list.sort((a, b) -> {
            if (a.getValue() != b.getValue()) return Integer.compare(b.getValue(), a.getValue());
            return a.getKey().compareTo(b.getKey());
        });
        
        list.forEach(x -> {
            System.out.println(x.getKey() + " " + x.getValue());
        });
    }
}
