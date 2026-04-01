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
public class J06002 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<HoaDon> ds = new ArrayList<>();
        Map<String, SanPham> mapSP = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long gia1 = Long.parseLong(sc.nextLine());
            long gia2 = Long.parseLong(sc.nextLine());
            SanPham x = new SanPham(ma, ten, gia1, gia2);
            mapSP.put(ma, x);
        }
        
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String maGoc = sc.next();
            long sl = sc.nextLong();
            String ma = maGoc.substring(0, 2);
            ds.add(new HoaDon(i + 1, maGoc, sl, mapSP.get(ma)));
        }
        
        ds.sort((a, b) -> {
            return Long.compare(b.phaiTra(), a.phaiTra());
        });
         
        for (HoaDon x : ds)
            System.out.println(x);
    }
}

class SanPham {
    String ma, ten;
    long gia1, gia2;
    
    SanPham (String ma, String ten, long gia1, long gia2) {
        this.ma = ma;
        this.ten = ten;
        this.gia1 = gia1;
        this.gia2 = gia2;
    }
}

class HoaDon {
    String maHD, tmp;
    long sl;
    SanPham sp;
    
    HoaDon (int id, String maHD, long sl, SanPham sp) {
        this.tmp = maHD + String.format("-%03d", id);
        this.maHD = maHD;
        this.sl = sl;
        this.sp = sp;
    }
    
    public long donGia() {
        if (maHD.endsWith("1")) return sp.gia1;
        return sp.gia2;
    }
    
    public long giamGia() {
        long thanhTien = sl * donGia();
        if (sl >= 150) return thanhTien * 50 / 100;
        if (sl >= 100) return thanhTien * 30 / 100;
        if (sl >= 50) return thanhTien * 15 / 100;
        return 0;
    }
    
    public long phaiTra() {
        return sl * donGia() - giamGia();
    }

    @Override
    public String toString() {
        return tmp + " " + sp.ten + " " + giamGia() + " " + phaiTra();
    }
    
}
