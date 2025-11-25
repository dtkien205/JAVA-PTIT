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
public class J02020 {
    
    static int n, k, cnt = 0;
    static int[] a = new int[20];
        
    static void Try(int i, int bd){
        for (int j = bd; j <= n - k + i; j++){
            a[i] = j;
            if(i == k){
                cnt++;
                for (int u = 1; u <= k; u++)
                    System.out.print(a[u] + " ");
                System.out.println();
            }
            else Try(i + 1, j + 1);
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();
        Try(1,1);
        System.out.print("Tong cong co " + cnt + " to hop");
    }
}
