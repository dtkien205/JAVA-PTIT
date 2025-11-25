/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;
import java.util.*;

//3
//abccaa
//abbcca
//abcda

public class J03025 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < s.length() / 2; i++){
                if(s.charAt(i) != s.charAt(s.length() - i - 1)) cnt++;
            }
            
            if(cnt == 1 || (cnt == 0 && s.length() % 2 == 1)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
