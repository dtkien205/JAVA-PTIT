package javacodeptit;

import java.io.*;
import java.util.*;

public class J07015 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        
        ArrayList<Integer> list = (ArrayList<Integer>) is.readObject();
        
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int x : list) {
            if (isPrime(x)) {
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }
        }
        
        mp.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        
    }
    
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
