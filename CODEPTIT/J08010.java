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
public class J08010 {
    public static boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> mp = new LinkedHashMap<>();
        int max = 0;
        
        while(sc.hasNext()) {
            String s = sc.next();
            if(check(s)) {
                mp.put(s, mp.getOrDefault(s, 0) + 1);
                max = Math.max(max, s.length());
            }
        }
        
        for (String k : mp.keySet()) {
            if (k.length() == max)
                System.out.println(k + " " + mp.get(k));
        }
    }
}

//AAA BAABA HDHDH ACBSD SRGTDH DDDDS
//DUAHD AAA AD DA HDHDH AAA AAA AAA AAA
//DDDAS HDHDH HDH AAA AAA AAA AAA AAA
//AAA AAA AAA
//DHKFKH DHDHDD HDHDHD DDDHHH HHHDDD
//TDTD
