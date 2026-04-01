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
public class J07060 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc1 = new Scanner(new File("MONTHI.in"));
        Scanner sc2 = new Scanner(new File("CATHI.in"));
        Scanner sc3 = new Scanner(new File("LICHTHI.in"));
        
        int n = Integer.parseInt(sc1.nextLine());
        Map<String, Mon> mapMon = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Mon x = new Mon(sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            mapMon.put(x.ma, x);
        }
        
        int m = Integer.parseInt(sc2.nextLine());
        Map<String, CaThi> mapCT = new HashMap<>();
        for (int i = 0; i < m; i++) {
            CaThi x = new CaThi(sc2.nextLine(), sc2.nextLine(), sc2.nextLine());
            mapCT.put(x.maCT, x);
        }
        
        int p = Integer.parseInt(sc3.nextLine());
        List<LichThi> ds = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String maCT = sc3.next();
            String maMH = sc3.next();
            String nhom = sc3.next();
            String sv = sc3.next();
            ds.add(new LichThi(nhom, sv, mapMon.get(maMH), mapCT.get(maCT)));
        }
        
        ds.sort((a, b) -> {
            if (a.time != b.time) return Long.compare(a.time, b.time);
            return a.c.maCT.compareTo(b.c.maCT);
        });
        
        ds.forEach(x -> {
            System.out.println(x);
        });
    }
}

class Mon {
    String ma, ten, ht;
    
    Mon(String ma, String ten, String ht) {
        this.ma = ma;
        this.ten = ten;
        this.ht = ht;
    }
}

class CaThi {
    String maCT, ngay, gio, phong;
    static int id = 1;
    
    CaThi (String ngay, String gio, String phong) {
        this.maCT = String.format("C%03d", id++);
        this.ngay = ngay;
        this.gio = gio;
        this.phong = phong;
    }
}

class LichThi {
    String nhom, soSV;
    Mon m;
    CaThi c;
    long time;
    
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    LichThi (String nhom, String soSV, Mon m, CaThi c) throws ParseException {
        this.nhom = nhom;
        this.soSV = soSV;
        this.m = m;
        this.c = c;
        this.time = fm.parse(c.ngay + " " + c.gio).getTime() / (1000 * 60);
    }

    @Override
    public String toString() {
        return c.ngay + " " + c.gio + " " + c.phong + " " + m.ten + " " + nhom + " " + soSV;
    } 
}
