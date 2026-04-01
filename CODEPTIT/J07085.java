/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07085 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<String> ds = (ArrayList<String>) in.readObject();
        
        for (String s : ds) {
            String res = "";
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))){
                    res += s.charAt(i);
                    sum += Integer.parseInt(s.charAt(i) + "");
                }   
            }
            
            while(res.charAt(0) == '0' && res.length() > 1){
                res = res.substring(1);
            }
            
            System.out.println(res + " " + sum);
        }
    }
}
