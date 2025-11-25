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
public class J03038 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Set<String> se = new HashSet<>();
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++){
            String tmp = s.charAt(i) + "";
            se.add(tmp);
        }
        System.out.print(se.size());
    }
}
