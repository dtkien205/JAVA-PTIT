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
public class J05014 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<GiaoVien> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new GiaoVien(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            return Double.compare(b.tong(), a.tong());
        });
        
        for (GiaoVien x : ds)
            System.out.println(x);
    }
}

class GiaoVien {
    String ma, ten, maXet;
    double d1, d2;
    static int id = 1;
    
    GiaoVien (String ten, String maXet, double d1, double d2){
        this.ma = String.format("GV%02d", id++);
        this.ten = ten;
        this.maXet = maXet;
        this.d1 = d1;
        this.d2 = d2;
    }
    
    public double diem() {
        return (d1 * 2 + d2);
    }
    
    public double uuTien() {
        if(maXet.endsWith("1")) return 2;
        if(maXet.endsWith("2")) return 1.5;
        if(maXet.endsWith("3")) return 1;
        return 0;
    }
    
    public String mon() {
        if(maXet.startsWith("A")) return "TOAN";
        if(maXet.startsWith("B")) return "LY";
        return "HOA";
    }
    
    public double tong() {
        return diem() + uuTien();
    }

    public String kq() {
        if(diem() + uuTien() >= 18) return "TRUNG TUYEN";
        return "LOAI";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + mon() + " " + String.format("%.1f" , tong()) + " " + kq();
    }  
}

//3
//Le Van Binh
//A1
//7.0
//3.0
//Tran Van Toan
//B3
//4.0
//7.0
//Hoang Thi Tam
//C2
//7.0
//6.0