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
public class Bai3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        
        List<Integer> corrects = new ArrayList<>();
        List<Integer> errors = new ArrayList<>();
        Set<Integer> isErrors = new HashSet<>(errors);
        
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            isErrors.add(x);
            errors.add(x);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!isErrors.contains(i)){
                corrects.add(i);
            }
        }
        
        System.out.println("Errors: " + formatList(errors));
        System.out.println("Correct: " + formatList(corrects));
    }
    
    public static String formatList(List<Integer> ds) {
        if (ds.isEmpty()) return "";
        
        List<String> grp = new ArrayList<>();
        int st = ds.get(0);
        int ed = st;
        
        for (int i = 1; i < ds.size(); i++) {
            if (ds.get(i) == ed + 1)
                ed = ds.get(i);
            else {
                if (st == ed) grp.add("" + st);
                else grp.add(st + "-" + ed);
                st = ds.get(i);
                ed = st;
            }
        }
        if (st == ed) grp.add("" + st);
        else grp.add(st + "-" + ed);
        
        if (grp.size() == 1) {
            return grp.get(0);
        } else {
            String res = "";
            for (int i = 0; i < grp.size() - 1; i++) {
                res += grp.get(i);
                if (i != grp.size() - 2) res += ", ";
            }
            return res + " and " + grp.get(grp.size() - 1);
        }
    }
}
