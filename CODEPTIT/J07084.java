/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07084 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<Online> ds = new ArrayList();
        for (int i = 0; i < n; i++) {
            ds.add(new Online(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        ds.sort((a, b) -> {
            if (a.getTime() != b.getTime()) return Long.compare(b.getTime(), a.getTime());
            return a.getTen().compareTo(b.getTen());
        });
        for (Online x : ds) {
            System.out.println(x);
        }
    }
}

class Online {
    private String ten;
    private long time;
    
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Online(String ten, String st, String ed) throws ParseException {
        this.ten = ten;
        this.time = (fm.parse(ed).getTime() - fm.parse(st).getTime()) / (1000 * 60); 
    }

    public String getTen() {
        return ten;
    }

    public long getTime() {
        return time;
    }
   
    @Override
    public String toString() {
        return ten + " " + time;
    }
}
