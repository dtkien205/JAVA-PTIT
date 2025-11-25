/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07059 {
    public static void main(String[] args) throws FileNotFoundException, ParseException{
        Scanner sc = new Scanner(new File("CATHI.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<CaThi> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new CaThi(sc.nextLine(),
                       sc.nextLine(),
                       sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            if(a.time != b.time)
                return Long.compare(a.time, b.time);
            return a.ma.compareTo(b.ma);
        });
        
        for (CaThi x : ds)
            System.out.println(x);
    }
}

class CaThi {
    String ma, ngay, gio, phong;
    long time;
    static int id = 1;
    
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    CaThi(String ngay, String gio, String phong) throws ParseException {
        this.ma = String.format("C%03d", id++);
        this.ngay = ngay;
        this.gio = gio;
        this.phong = phong;
        this.time = fm.parse(ngay + " " + gio).getTime();
    }

    @Override
    public String toString() {
        return ma + " " + ngay + " " + gio + " " + phong;
    }  
}
