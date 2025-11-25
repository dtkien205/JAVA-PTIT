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
public class J05043 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<NhanVien> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new NhanVien(sc.nextLine(), sc.nextLine(),
                       Long.parseLong(sc.nextLine()),
                       Long.parseLong(sc.nextLine())));
        }
        
        
        for (NhanVien x : ds){
            System.out.println(x);
        }
    }
}

class NhanVien {
    String ma, ten, chucVu;
    long luongcb, ngayCong;
    static int id = 1;
    
    NhanVien(String ten, String chucVu, long luongcb, long ngayCong){
        this.ma = String.format("NV%02d", id++);
        this.ten = ten;
        this.chucVu = chucVu;
        this.luongcb = luongcb;
        this.ngayCong = ngayCong;
    }
    
    public long phuCap() {
        if(this.chucVu.equals("GD")) return 500;
        if(this.chucVu.equals("PGD")) return 400;
        if(this.chucVu.equals("TP")) return 300;
        if(this.chucVu.equals("KT")) return 250;
        return 100;
    }
    
    public long luongChinh() {
        return luongcb * ngayCong;
    }
    
    public long tamUng() {
        long luong = (phuCap() + luongChinh()) * 2 / 3;
        if (luong < 25000) return Math.round(luong / 1000.0) * 1000;
        return 25000;
    }
    
    public long conLai() {
        return luongChinh() + phuCap() - tamUng();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + phuCap() + " " + luongChinh() + " " + tamUng() + " " + conLai();
    }  
}

//4
//Tran Thi Yen
//NV
//1000
//24
//Nguyen Van Thanh
//BV
//1000
//30
//Doan Truong An
//TP
//3000
//25
//Le Thanh
//GD
//5000
//28
