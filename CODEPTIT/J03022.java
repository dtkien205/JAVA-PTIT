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
public class J03022 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = "";
        
        while(sc.hasNext()){
            s += sc.nextLine();
        }
        
        String[] a = s.trim().toLowerCase().split("[.?!]");
        
        for (String i : a){
            i = i.trim();
            if (i.length() == 0) continue;
            i = Character.toString(i.charAt(0)).toUpperCase() + i.substring(1);
            for (String j : i.split("\\s+"))
                System.out.printf("%s ", j);
            System.out.println();
        }
    }
}

//ky thi LAP TRINH ICPC PTIT  bat dau to chuc     tu     nam 2010. nhu vay, nam nay la          tron 10 nam!
//    vay CO PHAI NAM NAY LA KY THI LAN THU 10?        khong phai! nam nay la KY THI LAN THU 11.