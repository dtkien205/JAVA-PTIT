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
public class J03020 {
    
    public static boolean check(String s){
        int l = 0, r = s.length()- 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Map<String, Integer> mp = new LinkedHashMap<>();
        int maxLen = 0;
                
        while(sc.hasNext()){
            String word = sc.next();    
            if(check(word)){
                mp.put(word, mp.getOrDefault(word, 0) + 1);
                maxLen = Math.max(maxLen, word.length());
            }
        }
        
        final int max = maxLen;
        
        mp.forEach((k, v) -> {
           if(k.length() == max) {
               System.out.println(k + " " + v);
           }
        });
    }
}


