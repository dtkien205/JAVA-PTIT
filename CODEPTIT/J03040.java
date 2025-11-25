/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.util.Scanner;


public class J03040 {
    public static boolean check1(String s){
        for (int i = 1; i < s.length(); i++){
            if(s.charAt(i) <= s.charAt(i - 1)) return false;
        }
        return true;
    }
    
    public static boolean check2(String s){
        if(s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2) && s.charAt(3) == s.charAt(4))
            return true;
        return false;
    }
    
    public static boolean check3(String s){
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '6' && s.charAt(i) != '8') return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            String tmp = s.substring(5, 8) + s.substring(9);
            if(check1(tmp) || check2(tmp) || check3(tmp)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
//7
//29T1–123.45
//29T1–555.55
//29T1–222.33
//29T1–686.88
//29T1–123.33
//29T1–555.54
//29T1–606.88