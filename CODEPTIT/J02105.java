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
public class J02105 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++){
            System.out.print("List(" + i + ") = ");
            for (int j = 1; j <= n; j++){
                int x = sc.nextInt();
                if(x == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
