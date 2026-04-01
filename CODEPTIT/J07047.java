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
public class J07047 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("DATA.in"));
        Map<String, KhachSan> map = new HashMap<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            KhachSan x = new KhachSan(sc.next(), sc.next(), sc.nextLong(), sc.nextDouble());
            sc.nextLine();
            map.put(x.ma, x);
        }
        int m = Integer.parseInt(sc.nextLine());
        List<KhachHang> ds = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String ten = sc.nextLine();
            String maP = sc.nextLine();
            String in = sc.nextLine();
            String out = sc.nextLine();
            String ma = maP.substring(2, 3);
            ds.add(new KhachHang(ten, maP, in, out, map.get(ma)));
        }
        Collections.sort(ds, (a, b) -> Long.compare(b.ngay, a.ngay));
        
        for (KhachHang x : ds) System.out.println(x);
    }
}

class KhachSan {
    String ma, ten;
    long gia;
    double phi;
    
    KhachSan (String ma, String ten, long gia, double phi) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.phi = phi;
    }
}

class KhachHang {
    String maKH, hoten, maP;
    static int id = 1;
    long ngay;
    KhachSan kh;
    
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
    KhachHang (String hoten, String maP, String in, String out, KhachSan x) throws ParseException {
        this.maKH = String.format("KH%02d", id++);
        this.hoten = hoten;
        this.maP = maP;
        this.kh = x;
        this.ngay = (fm.parse(out).getTime() - fm.parse(in).getTime()) / (1000 * 60 * 60 * 24) + 1;
    }
    
    double giamGia() {
        if (ngay > 30) return 0.06;
        if (ngay >= 20) return 0.04;
        if (ngay >= 10) return 0.02;
        return 0;
    }
    
    double tien() {
        return (double)ngay * kh.gia * (1 + kh.phi) * (1 - giamGia());
    }

    @Override
    public String toString() {
        return maKH + " " + hoten + " " + maP + " " + ngay + " " + String.format("%.2f", tien());
    }  
}
