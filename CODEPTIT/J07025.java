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
public class J07025 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<KhachHang> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ds.add(new KhachHang(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            return Long.compare(a.time, b.time);
        });
        
        for (KhachHang x : ds) System.out.println(x);
    }
}

class KhachHang {
    String ten, gt, ns, dc, ma;
    static int id = 1;
    long time;
    
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
    
    KhachHang(String ten, String gt, String ns, String dc) throws ParseException {
        this.ten = chuanHoaTen(ten);
        this.gt = gt;
        this.ns = chuanHoaNgay(ns);
        this.dc = dc;
        this.ma = String.format("KH%03d", id++);
        this.time = fm.parse(this.ns).getTime();
    }
    
    public String chuanHoaTen(String s) {
        String[] t = s.trim().toLowerCase().split("\\s+");
        String res = "";
        for (String x : t) {
            res += x.substring(0, 1).toUpperCase() + x.substring(1) + " ";
        }
        return res.trim();
    }
    
    public String chuanHoaNgay(String s) {
        String[] p = s.toLowerCase().split("/");
        if (p[0].length() != 2) p[0] = "0" + p[0];
        if (p[1].length() != 2) p[1] = "0" + p[1];
        return p[0] + "/" + p[1] + "/" + p[2];
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gt + " " + dc + " " + ns;
    }
    
}
