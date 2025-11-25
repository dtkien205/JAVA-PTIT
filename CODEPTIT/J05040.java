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
public class J05040 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<NhanVien> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new NhanVien(sc.nextLine(), 
                       Long.parseLong(sc.nextLine()),
                       Long.parseLong(sc.nextLine()), sc.nextLine()));
        }
        
        for (NhanVien x : ds){
            System.out.println(x);
        }
    }
}

class NhanVien {
    String mnv, ten, chucVu;
    long luongNgay, soNgay;
    static int id = 1;
    
    NhanVien(String ten, long luongNgay, long soNgay, String chucVu){
        this.mnv = String.format("NV%02d", id++);
        this.ten = ten;
        this.chucVu = chucVu;
        this.luongNgay = luongNgay;
        this.soNgay = soNgay;
    }
    
    public long luongThang() {
        return luongNgay * soNgay;
    }
    
    public long thuong() {
        if(soNgay >= 25) return luongThang() * 20 / 100;
        if(soNgay >= 22) return luongThang() * 10 / 100;
        return 0;
    }
    
    public long phuCap() {
        if(chucVu.equals("GD")) return 250000;
        if(chucVu.equals("PGD")) return 200000;
        if(chucVu.equals("TP")) return 180000;
        return 150000;
    }
    
    public long thucLinh() {
        return luongThang() + thuong() + phuCap();
    }

    @Override
    public String toString() {
        return mnv + " " + ten + " " + luongThang() + " " + thuong() + " " + phuCap() + " " + thucLinh();
    }
    
    
}

//3
//Cao Van Vu
//50000
//26
//GD
//Do Van Truong
//40000
//25
//PGD
//Truong Thi Tu Linh
//45000
//22
//NV
