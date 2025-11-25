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
public class J04015 {
    public static int phuCap(String s){
        if(s.equals("HT")) return 2000000;
        if(s.equals("HP")) return 900000;
        return 500000;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String ma = sc.nextLine();
        String chucVu = ma.substring(0, 2);
        int heSo = Integer.parseInt(ma.substring(2));
        
        System.out.printf("%s %s %d %d %d", ma, sc.nextLine(), heSo, phuCap(chucVu),1L * sc.nextInt() * heSo + phuCap(chucVu));
    }
}
