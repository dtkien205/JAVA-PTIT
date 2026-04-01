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
public class JKT013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            Queue<String> q = new LinkedList<>();
            q.add("6");
            q.add("8");
            List<String> ds = new ArrayList<>();
            while(!q.isEmpty()) {
                String x = q.poll();
                if (x.length() > n) break;
                ds.add(x);
                q.add(x + "6");
                q.add(x + "8");
            }
            System.out.println(ds.size());
            for (int i = ds.size() - 1; i >= 0; i--) 
                System.out.print(ds.get(i) + " ");
            System.out.println();
        }
    }
}
