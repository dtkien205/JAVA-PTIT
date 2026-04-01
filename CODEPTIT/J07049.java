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
public class J07049 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        Map<String, SanPham> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            SanPham x = new SanPham(sc.nextLine(), sc.nextLine(), 
                    Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            map.put(x.ma, x);
        }
        
        int m = Integer.parseInt(sc.nextLine());
        List<KhachHang> ds = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String hoten = sc.nextLine();
            String dc = sc.nextLine();
            String maSP = sc.nextLine();
            long sl = Long.parseLong(sc.nextLine());
            String ngay = sc.nextLine();
            ds.add(new KhachHang(hoten, dc, maSP, (int) sl, ngay, map.get(maSP)));
        }
        
        ds.sort((a, b) -> {
            if (a.time != b.time) return Long.compare(a.time, b.time);
            return a.ma.compareTo(b.ma);
        });
        
        for (KhachHang x : ds) System.out.println(x);
    }
}

class SanPham {
    String ma, ten;
    long gia, bh;
    
    SanPham (String ma, String ten, long gia, long baoHanh) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.bh = baoHanh;
    }
}

class KhachHang {
    String ma, hoten, dc, maSP, ngay;
    int sl;
    SanPham sp;
    static int id = 1;
    long time;
    Date ed;
    
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
    
    KhachHang (String hoten, String dc, String maSP, int sl, String ngay, SanPham sp) throws ParseException {
        this.ma = String.format("KH%02d", id++);
        this.hoten = hoten;
        this.dc = dc;
        this.maSP = maSP;
        this.ngay = ngay;
        this.sl = sl;
        this.sp = sp;
        
        Date mua = fm.parse(ngay);
        Calendar cal = Calendar.getInstance();
        cal.setTime(mua);
        cal.add(Calendar.MONTH, (int) sp.bh);
        this.ed = cal.getTime();
        this.time = ed.getTime() / (1000 * 60 * 60);
    }
    
    long tien() {
        return sp.gia * sl;
    }

    @Override
    public String toString() {
        return ma + " " + hoten + " " + dc + " " + maSP + " " + tien() + " " + fm.format(ed);
    }  
}
