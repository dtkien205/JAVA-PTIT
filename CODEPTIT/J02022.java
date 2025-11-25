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
public class J02022 {
    static int n;
    static boolean[] vs = new boolean[20];
    
    public static boolean check(String s){
        for (int i = 0; i < n - 1; i++){
            if(Math.abs(s.charAt(i) - s.charAt(i+1)) == 1) return false;
        }
        return true;
    }
    
    public static void Try(int i, String s){
        if(i == n){
            if(check(s))
                System.out.println(s);
            return;
        }
        
        for (int j = 1; j <= n; j++){
            if(!vs[j]){
                vs[j] = true;
                Try(i + 1, s + j);
                vs[j] = false;
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            Try(0, "");
        }
    }
}
