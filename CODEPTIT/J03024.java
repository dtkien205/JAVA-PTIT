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
public class J03024 {
    public static int check(String s){
        int c = 0, l = 0;
        for (int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(x < '0' || x > '9') return -1;
            if((x - '0') % 2 == 0) c++;
            else l++;
        }
        int n = s.length();
        if (n % 2 == 0) {
            return (c > l) ? 1 : 0;         
        } else {
            return (l > c) ? 1 : 0;        
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            String s = sc.nextLine();
            if(check(s) == -1) System.out.println("INVALID");
            else if(check(s) == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

//3
//01234aa32432432432534545b987978
//1234567890123456789000
//999999999999999999999999999999