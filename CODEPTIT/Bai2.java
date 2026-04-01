/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author PC
 */
public class Bai2 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<Online> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            ds.add(new Online(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        ds.sort((a, b) -> {
            if (!a.time.equals(b.time)) return Long.compare(b.time, a.time);
            return a.ten.compareTo(b.ten);
        });
        
        for (Online x : ds)
            System.out.println(x);
    }
}

class Online {
    String ten;
    Long time;
    
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Online(String ten, String st, String ed) throws ParseException {
        this.ten = ten;
        this.time = (f.parse(ed).getTime() - f.parse(st).getTime()) / (1000 * 60);
    }

    @Override
    public String toString() {
        return ten  + " " + time;
    } 
}
