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
public class J02034 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mx = 0;
        Set<Integer> se = new HashSet<>();
        
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            se.add(x);
            mx = Math.max(mx, x);
        }
        
        boolean check = false;
        for (int i = 1; i <= mx; i++){
            if(!se.contains(i)){
                check = true;
                System.out.println(i);
            }
        }
        
        if (!check) System.out.println("Excellent!");
    }
}
