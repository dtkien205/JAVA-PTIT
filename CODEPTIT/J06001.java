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
public class J06001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<HoaDon> ds = new ArrayList<>();
        Map<String, SanPham> mapSP = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            Long donGia1 = Long.parseLong(sc.nextLine());
            Long donGia2 = Long.parseLong(sc.nextLine());
            SanPham sp = new SanPham(ma, ten, donGia1, donGia2);
            mapSP.put(ma, sp);
        }
        
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String maGoc = sc.next();
            String ma = maGoc.substring(0, 2);
            long sl = sc.nextLong();
            ds.add(new HoaDon(maGoc, sl, mapSP.get(ma)));
        }
        for (HoaDon x : ds) {
            System.out.println(x);
        }
    }
}

class SanPham {
    String ma, ten;
    long donGia1, donGia2;
    
    SanPham(String ma, String ten, long donGia1, long donGia2) {
        this.ma = ma;
        this.ten = ten;
        this.donGia1 = donGia1;
        this.donGia2 = donGia2;
    }  
}

class HoaDon {
    String maHD;
    long sl;
    static int id = 1;
    SanPham sp;
    
    HoaDon(String maHD, long sl, SanPham sp) {
        this.maHD = maHD;
        this.sl = sl;
        this.sp = sp;
    }
    
    public long donGia() {
        if(maHD.endsWith("1")) return sp.donGia1;
        return sp.donGia2;
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
        return maHD + String.format("-%03d", id++) + " " + sp.ten + " " + giamGia() + " " + phaiTra();
    }  
}

//2
//AT
//Ao thun
//80000
//45000
//QJ
//Quan Jean
//220000
//125000
//2
//AT1 95
//QJ2 105
