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
public class J05059 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<ThiSinh>ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ds.add(new ThiSinh(sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine())));
        }
        int chiTieu = Integer.parseInt(sc.nextLine());
        double diemChuan = 0;
        
        ds.sort((a, b) -> {
            if(a.tong == b.tong)
                return a.ma.compareTo(b.ma);
            return Double.compare(b.tong, a.tong);
        });
        
        diemChuan = ds.get(chiTieu - 1).tong;
        
        System.out.println(diemChuan);
        for (ThiSinh x : ds){
            if (x.tong >= diemChuan) x.trangThai = "TRUNG TUYEN";
            else x.trangThai = "TRUOT";
            System.out.println(x);
        }
    }
}

class ThiSinh {
    String ma, ten, trangThai;
    double tong;
    
    ThiSinh(String ma, String ten, double toan, double ly, double hoa){
        this.ma = ma;
        this.ten = ten;
        this.tong = (toan * 2) + ly + hoa + uuTien();
    }
    
    public String fm(double x){
        if(x == (int)x) return String.format("%d", (int)x);
        return String.format("%.1f", x);
    }
    
    public double uuTien() {
        if (ma.startsWith("KV1")) return 0.5;
        if (ma.startsWith("KV2")) return 1.0;
        return 2.5;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + fm(uuTien()) + " " + fm(tong) + " " + trangThai;
    }   
}

//2
//KV2A002
//Hoang Thanh Tuan
//5
//6
//5
//KV3B123
//Ly Thi Thu Ha
//8
//6.5
//7
//1
