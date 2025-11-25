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
public class J05037 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Hang> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Hang(sc.nextLine(), sc.nextLine(), 
                       Long.parseLong(sc.nextLine()),
                       Long.parseLong(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            return Long.compare(b.giaBan(), a.giaBan());
        });
        
        for (Hang x : ds){
            System.out.println(x);
        }
    }
}

class Hang {
    String ma, ten, dv;
    long dongia, sl;
    static int id = 1;
    
    Hang(String ten, String dv, long dongia, long sl){
        this.ma = String.format("MH%02d", id++);
        this.ten = ten;
        this.dv = dv;
        this.dongia = dongia;
        this.sl = sl;
    }
    
    public long phiVanChuyen() {
        return Math.round(sl * dongia * 0.05);
    }
    
    public long thanhTien() {
        return Math.round(sl * dongia + phiVanChuyen());
    }
    
    public long giaBan() {
        long sell = thanhTien() * 102 / 100 / sl;
        if(sell%100!=0) sell = sell - sell%100 + 100;
        return sell;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + dv + " " + phiVanChuyen() + " " + thanhTien() + " " + giaBan();
    }
}

//4
//DUONG
//KG
//7500
//150
//TRUNG
//CHUC
//10000
//225
//GAO
//KG
//14000
//118
//SUA
//HOP
//48000
//430
