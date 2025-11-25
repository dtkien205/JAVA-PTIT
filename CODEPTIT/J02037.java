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
public class J02037 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        sc.nextLine();
        
        while(t-- > 0){
            String[] s = sc.nextLine().trim().split("\\s+");
            int cnt = 0;
            for (int i = 0; i < s.length; i++){
                if(Integer.parseInt(s[i]) % 2 == 0)
                   cnt++;
            }
            if(s.length % 2 == 0 && cnt > s.length - cnt || s.length % 2 != 0 && s.length - cnt > cnt)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}


//2
//11 22 33 44 55 66 77
//23 34 45 56 67 78 89 90 121 131 141 151 161 171