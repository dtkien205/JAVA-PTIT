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
public class J05076 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Hang> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new Hang(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++){
            String ma = sc.next();
            long nhap = sc.nextLong();
            long donGia = sc.nextLong();
            long xuat = sc.nextLong();
            for (Hang x : ds){
                if(x.ma.equals(ma)){
                    long tmp = xuat * donGia + x.loiNhuan(xuat * donGia);
                    System.out.println(ma + " " + x.ten + " " + nhap * donGia +  " " + tmp);
                    break;
                }
            }
        }
    }
}

class Hang {
    String ma, ten, loai;
            
    Hang(String ma, String ten, String loai){
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
    }
    
    public long loiNhuan(long x) {
        if(loai.equals("A")) return x * 8 / 100;
        if(loai.equals("B")) return x * 5 / 100;
        if(loai.equals("C")) return x * 2 / 100;
        return 0;
    }
}

//2
//A001
//Tu lanh
//A
//P002
//May giat
//B
//2
//A001 500 100 300
//P002 1000 1000 500