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
public class J08026 {
    static int solve(int s, int t) {
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> dis = new HashMap<>();
        q.add(s);
        dis.put(s, 0);
        while(!q.isEmpty()) {
            int cur = q.poll();
            int d = dis.get(cur);
            if (cur == t) return d;
            
            int a = cur - 1;
            if (a >= 0 && !dis.containsKey(a)) {
                dis.put(a, d + 1);
                q.add(a);
            }
            
            int b = cur * 2;
            if (b < 10000 && !dis.containsKey(b)) {
                dis.put(b, d + 1);
                q.add(b);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int s = sc.nextInt(), t = sc.nextInt();
            System.out.println(solve(s,t));
        }
    }
}
