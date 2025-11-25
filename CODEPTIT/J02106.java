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
public class J02106 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= n; i++){
            int cnt = 0;
            for (int j = 1; j <= 3; j++){
                int x = sc.nextInt();
                if(x == 1) cnt++;
            }
            if(cnt > 3 - cnt) res++;
        }
        System.out.println(res);
    }
}
