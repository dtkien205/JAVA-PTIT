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
public class J08024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
    } 
    
    public static long solve(int n) {
        Queue<Long> q = new LinkedList<>();
        q.add(9L);
        
        while(!q.isEmpty()) {
            long x = q.poll();
            
            if (x % n == 0) return x;
            
            q.add(x * 10);
            q.add(x * 10 + 9);
        }
        return -1;
    }
}
