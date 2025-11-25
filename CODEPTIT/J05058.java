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
public class J05058 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<ThiSinh> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new ThiSinh(sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine())
            ));
        }
        
        ds.sort((a, b) -> {
            if(a.diemXetTuyen() != b.diemXetTuyen())
                return Double.compare(b.diemXetTuyen(), a.diemXetTuyen());
            return a.ma.compareTo(b.ma);
        });
        
        for (ThiSinh x : ds){
            System.out.println(x);
        }
    }
}

class ThiSinh {
    String ma, ten;
    double tong;
    
    ThiSinh (String ma, String ten, double d1, double d2, double d3){
        this.ma = ma;
        this.ten = ten;
        this.tong = d1 * 2 + d2 + d3;
    }
    
    public String trangThai() {
        if (diemXetTuyen() >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }
    
    public double uuTien() {
        if(ma.startsWith("KV1")) return 0.5;
        if(ma.startsWith("KV2")) return 1.0;
        return 2.5;
    }
    
    public double diemXetTuyen() {
        return tong + uuTien();
    }
    
    public static String fm(double x){
        if((int)x == x) return String.format("%.0f", x);
        return String.format("%.1f", x);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " +  fm(uuTien()) + " " + fm(diemXetTuyen()) +  " " + trangThai();
    }
    
    
}
