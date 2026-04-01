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
public class JKT015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            
            if (Character.isLetterOrDigit(x))
                res.append(x);
            else if (x == '<') {
                if (res.length() > 0) {
                    st.push(res.charAt(res.length() - 1));
                    res.deleteCharAt(res.length() - 1);
                }
            } else if (x == '>') {
                if (!st.isEmpty()) {
                    res.append(st.peek());
                    st.pop();
                }
            } else {
                if (res.length() > 0)
                    res.deleteCharAt(res.length() - 1);
            }
        }
            
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        System.out.println(res.toString());
    }
}
