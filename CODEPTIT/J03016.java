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
public class J03016 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < s.length(); i++){
                int n = s.charAt(i) - '0';
                if(i % 2 == 0) sum1 += n;
                else sum2 += n;
            }
            if(Math.abs(sum1 - sum2) % 11 == 0)
                System.out.println(1);
            else System.out.println(0);
        }
    }
}

