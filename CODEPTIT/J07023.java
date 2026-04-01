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
public class J07023 {
    static boolean snt(int n) {
        for(int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    static boolean tn(int n) {
        String s = String.valueOf(n);
        int l = 0, r = s.length() - 1;
        while(l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        List<Integer> ds1 = (ArrayList<Integer>) in1.readObject();
        List<Integer> ds2 = (ArrayList<Integer>) in2.readObject();
        
        Map<Integer, Integer> mp1 = new TreeMap<>();
        Map<Integer, Integer> mp2 = new TreeMap<>();
        
        for (int x : ds1) {
            if (snt(x) && tn(x)) mp1.put(x, mp1.getOrDefault(x, 0) + 1);
        }
        
        for (int x : ds2) {
            if (snt(x) && tn(x)) mp2.put(x, mp2.getOrDefault(x, 0) + 1);
        }
        
        Set<Integer> ts = new TreeSet<>(mp2.keySet());
        ts.retainAll(mp1.keySet());
        for (int x : ts) {
            if (mp1.containsKey(x) && mp2.containsKey(x)) System.out.println(x + " " + mp1.get(x) + " " + mp2.get(x));
        }
    }
}
