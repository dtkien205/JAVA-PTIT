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
public class J03021 {
    static char convert(char c){
        if("ABC".indexOf(c) > -1) return '2';
        if("DEF".indexOf(c) > -1) return '3';
        if("GHI".indexOf(c) > -1) return '4';
        if("JKL".indexOf(c) > -1) return '5';
        if("MNO".indexOf(c) > -1) return '6';
        if("PQRS".indexOf(c) > -1) return '7';
        if("TUV".indexOf(c) > -1) return '8';
        return '9';
    }
    
    static boolean check(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine().toUpperCase(), tmp = "";
            for (int i = 0; i < s.length(); i++){
                tmp += convert(s.charAt(i));
            }
            System.out.println(check(tmp) ? "YES" : "NO");
        }
    }
}

//2
//BOHIMA
//IamACoder
