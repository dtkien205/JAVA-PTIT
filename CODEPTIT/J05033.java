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
public class J05033 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Time[] a = new Time[n];
        
        for (int i = 0; i < n; i++){
            a[i] = new Time(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(a, (t1,t2) -> {
            if(t1.h != t2.h) return Integer.compare(t1.h, t2.h);
            if (t1.m != t2.m) return Integer.compare(t1.m, t2.m);
            return Integer.compare(t1.s, t2.s);
        });
        
        for (int i = 0; i < n; i++){
            System.out.println(a[i].h + " " + a[i].m + " " + a[i].s);
        }
    }
}

class Time {
    int h, m, s;
    
    Time(int h, int m, int s){
        this.h = h;
        this.m = m;
        this.s = s;
    }
}