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
public class J08020 {
    public static boolean check (String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(' || x == '[' || x == '{')
                st.add(x);
            else {
                if (st.isEmpty() || (x == ')' && st.peek() != '(') || (x == ']' && st.peek() != '[')
                        || (x == '}' && st.peek() != '{')) return false;
                st.pop();
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String s = sc.next();
            System.out.println(check(s) ? "YES" : "NO");
        }
    }
}

//2
//[()]{}{[()()]()}
//[(])