/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;
import java.util.*;

//2
//abcd
//defgh
//a
//a

public class J03026 {
    static boolean check(String a, String b){
        if(a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String a = sc.nextLine(), b = sc.nextLine();
            if(!check(a, b)) System.out.println(Math.max(a.length(), b.length()));
            else System.out.println("-1");
        }
    }
}
