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
public class J05064 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<GiaoVien> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new GiaoVien(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine())));
        }
        
        int ht = 0, hp = 0;
        for (GiaoVien x : ds){
            if(x.ma.startsWith("HT")){
                ht++;
                if(ht > 1) continue;
            }
            if (x.ma.startsWith("HP")){
                hp++;
                if(hp > 2) continue;
            }
            System.out.println(x);
        }
    }
}

class GiaoVien {
    String ma, ten;
    long luong;
    
    GiaoVien(String ma, String ten, long luong){
        this.ma = ma;
        this.ten = ten;
        this.luong = luong;
    }
    
    public long phuCap() {
        if(ma.startsWith("HT")) return 2000000;
        if(ma.startsWith("HP")) return 900000;
        return 500000;
    }
    
    public int heSo() {
        return Integer.parseInt(ma.substring(2));
    }
    
    public long thuNhap() {
        return luong * heSo() + phuCap();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + heSo() + " " + phuCap() + " " + thuNhap();
    }   
}


//3
//GV01
//Nguyen Kim Loan
//1420000
//HT05
//Hoang Thanh Tuan
//1780000
//GV02
//Tran Binh Nguyen
//1468000