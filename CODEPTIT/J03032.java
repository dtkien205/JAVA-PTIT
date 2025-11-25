/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;
import java.util.*;

//2
//ABC DEF
//123 456

public class J03032 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String line = sc.nextLine();
            String[] w = line.trim().split(" +");
            for (int i = 0; i < w.length; i++){
                for (int j = w[i].length() - 1; j >= 0; j--)
                    System.out.print(w[i].charAt(j));
                if (i + 1 < w.length) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
