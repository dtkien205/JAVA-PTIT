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
public class J06005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<String, KhachHang> mapKH = new HashMap<>();
        Map<String, MatHang> mapMH = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        List<HoaDon> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String gt = sc.nextLine();
            String ns = sc.nextLine();
            String dc = sc.nextLine();
            KhachHang x = new KhachHang(ten, gt, ns, dc);
            mapKH.put(x.ma, x);
        }
        
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String ten = sc.nextLine();
            String dv = sc.nextLine();
            long mua = Long.parseLong(sc.nextLine());
            long ban = Long.parseLong(sc.nextLine());
            MatHang x = new MatHang(ten, dv, mua, ban);
            mapMH.put(x.ma, x);
        }
        
        int p = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < p; i++) {
            String maKH = sc.next();
            String maMH = sc.next();
            long sl = sc.nextLong();
            ds.add(new HoaDon(sl, mapKH.get(maKH), mapMH.get(maMH)));
        }
        
        for (HoaDon x : ds) 
            System.out.println(x);
    }
}

class KhachHang {
    String ma, ten, gt, ns, dc;
    static int id = 1;
    
    KhachHang (String ten, String gt, String ns, String dc) {
        this.ma = String.format("KH%03d", id++);
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
    }
}

class MatHang {
    String ma, ten, dv;
    long mua, ban;
    static int id = 1;

    MatHang(String ten, String dv, long mua, long ban) {
        this.ma = String.format("MH%03d", id++);
        this.ten = ten;
        this.dv = dv;
        this.mua = mua;
        this.ban = ban;
    } 
}

class HoaDon {
    String maHD;
    long sl;
    KhachHang kh;
    MatHang mh;
    static int id = 1;
    
    HoaDon (long sl, KhachHang kh, MatHang mh) {
        this.sl = sl;
        this.kh = kh;
        this.mh = mh;
        this.maHD = String.format("HD%03d", id++);
    }

    @Override
    public String toString() {
        return maHD + " " + kh.ten + " " + kh.dc + " " + mh.ten + " " + mh.dv + " " + mh.mua + " " + mh.ban + " "
                + sl + " " + (sl * mh.ban);
    }  
}

//2
//Nguyen Van Nam
//Nam
//12/12/1997
//Mo Lao-Ha Dong-Ha Noi
//Tran Van Binh
//Nam
//11/14/1995
//Phung Khoang-Nam Tu Liem-Ha Noi
//2
//Ao phong tre em
//Cai
//25000
//41000
//Ao khoac nam
//Cai
//240000
//515000
//3
//KH001 MH001 2
//KH001 MH002 3
//KH002 MH002 4
