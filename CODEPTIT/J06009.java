/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class J06009 {
    public static void main(String[] args) throws FileNotFoundException {
        
        Map<String, KhachHang> mapKH = new HashMap<>();
        Map<String, MatHang> mapMH = new HashMap<>();
        
        Scanner sc1 = new Scanner(new File("KH.in"));
        int n = Integer.parseInt(sc1.nextLine());
        List<KhachHang> dsKH = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            KhachHang x = new KhachHang(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            dsKH.add(x);
            mapKH.put(x.ma, x);
        }
        
        Scanner sc2 = new Scanner(new File("MH.in"));
        int m = Integer.parseInt(sc2.nextLine());
        List<MatHang> dsMH = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            MatHang x = new MatHang(sc2.nextLine(), sc2.nextLine(),
                    Integer.parseInt(sc2.nextLine()),
                    Integer.parseInt(sc2.nextLine()));
            
            dsMH.add(x);
            mapMH.put(x.ma, x);
        }
        
        Scanner sc3 = new Scanner(new File("HD.in"));
        int p = Integer.parseInt(sc3.nextLine());
        List<HoaDon> dsHD = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String maKH = sc3.next();
            String maMH = sc3.next();
            int sl = Integer.parseInt(sc3.next());
            sc3.nextLine();
            dsHD.add(new HoaDon(mapMH.get(maMH), mapKH.get(maKH), sl));
        }
        
        for (HoaDon x : dsHD)
            System.out.println(x);
    }
}

class KhachHang {
    String ma, ten, gt, ns, dc;
    static int id = 1;
    
    KhachHang(String ten, String gt, String ns, String dc) {
        this.ma = String.format("KH%03d", id++);
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
    }
}

class MatHang {
    String ma, ten, dv;
    int mua, ban;
    static int id = 1;
    
    MatHang (String ten, String dv, int mua, int ban) {
        this.ma = String.format("MH%03d", id++);
        this.ten = ten;
        this.dv = dv;
        this.mua = mua;
        this.ban = ban;
    }
}

class HoaDon {
    int sl;
    MatHang mh;
    KhachHang kh;
    String maHD;
    static int id = 1;
    
    HoaDon (MatHang mh, KhachHang kh, int sl) {
        this.maHD = String.format("HD%03d", id++);
        this.mh = mh;
        this.kh = kh;
        this.sl = sl;
    }
    
    public long thanhTien() {
        return 1l * mh.ban * sl;
    }

    @Override
    public String toString() {
        return maHD + " " + kh.ten + " " + kh.dc + " " + mh.ten + " " + mh.dv + " " + mh.mua + " " + mh.ban
                + " "+ sl + " " + thanhTien();
    }  
}