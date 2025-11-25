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
public class J02103 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++){
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] a = new int[n][m];
            int[][] b = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = sc.nextInt();
            
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    for (int k = 0; k < m; k++){
                        b[i][j] += a[i][k] * a[j][k];
                    }
                }
            }
            
            System.out.println("Test " + x + ":");
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++)
                    System.out.print(b[i][j] + " ");
                System.out.println();
            }
        }
    }
}
