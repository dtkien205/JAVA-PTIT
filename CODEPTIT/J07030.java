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
public class J07030 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        ArrayList<Integer> ds1 = (ArrayList<Integer>) sc1.readObject();
        ArrayList<Integer> ds2 = (ArrayList<Integer>) sc2.readObject();
        
        Set<Integer> s1 = new TreeSet<>(ds1);
        Set<Integer> s2 = new TreeSet<>(ds2);
        
        int MAX = 1000000;
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i] ){
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (Integer n : s1) {
            if(n >= 500000)
                break;
            int m = 1000000 - n;
            if(isPrime[n] && isPrime[m] && s2.contains(m)) {
                System.out.println(n + " " + m);
            }
        }
    }
}
