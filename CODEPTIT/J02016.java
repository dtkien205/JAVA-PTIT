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
public class J02016 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] a = new long[n];
            Set<Long> st = new HashSet<>();
            for (int i = 0; i < n; i++){
                long x = sc.nextInt();
                a[i] = x * x;
                st.add(a[i]);
            }
            
            boolean check = false;
            for (int i = 0; i < n; i++){
                for (int j = i + 1; j < n; j++){
                    if(st.contains(a[i] + a[j])){
                        check = true;
                        break;
                    }
                }
                if(check) break;
            }
            System.out.println(check ? "YES" : "NO");
        }
    }
}
