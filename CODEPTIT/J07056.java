/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07056 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<KhachHang> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ds.add(new KhachHang(sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> Long.compare(b.tong(), a.tong()));
        
        for (KhachHang x : ds)
            System.out.println(x);
    }
}

class KhachHang {
    String ma, hoten, loai;
    long so;
    static int id = 1;
    
    KhachHang(String hoten, String line) {
        String[] t = line.split("\\s+");
        this.loai = t[0];
        this.so = Long.parseLong(t[2]) - Long.parseLong(t[1]);
        
        String[] ten = hoten.trim().toLowerCase().split("\\s+");
        String res = "";
        for (int i = 0; i < ten.length; i++) {
            res += ten[i].substring(0, 1).toUpperCase() + ten[i].substring(1) + " ";
        }
        this.hoten = res.trim();
        this.ma = String.format("KH%02d", id++);
    }
    
    public long dinhMuc() {
        if (loai.equals("A")) return 100;
        if (loai.equals("B")) return 500;
        return 200;
    }
    
    public long tienTrong() {
        if(so < dinhMuc()) return so * 450;
        return dinhMuc() * 450;
    }
    
    public long tienVuot() { 
        if (so > dinhMuc()) return (so - dinhMuc()) * 1000;
        return 0;
    }
    
    public long thue() {
        return tienVuot() * 5 / 100;
    }
    
    public long tong() {
        return tienTrong() + tienVuot() + thue();
    }

    @Override
    public String toString() {
        return ma + " " + hoten + " " + tienTrong() + " " + tienVuot() + " " + thue() + " " + tong();
    }  
}

//2
// nGuyEn Hong Ngat
//C 200 278
// Chu thi    minh
//A 120 160
