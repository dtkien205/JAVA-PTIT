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
public class J03027 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> a = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if(a.empty()) a.push(s.charAt(i));
            else {
                if(a.lastElement() == s.charAt(i)) a.pop();
                else a.push(s.charAt(i));
            }
        }
        if(a.empty()) System.out.println("Empty String");
        else {
            a.forEach(c -> {
                System.out.print(c);
            });
        }
    }
}
