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
public class J05068 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<XangDau> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new XangDau(sc.next(), Integer.parseInt(sc.next())));
        }
        
        ds.sort((a, b) ->{
            return Long.compare(b.thanhTien(), a.thanhTien());
        });
        
        for (XangDau x : ds)
            System.out.println(x);
    }
}

class XangDau {
    String ma;
    long sl;
    
    XangDau(String ma, long sl){
        this.ma = ma;
        this.sl = sl;
    }
    
    public long donGia(){
        if(this.ma.startsWith("X")) return 128000;
        if(this.ma.startsWith("D")) return 11200;
        return 9700;
    }
    
    public long Thue(){
        long x = donGia() * sl;
        if(this.ma.endsWith("TN")) return 0;
        if(this.ma.startsWith("X")) return x * 3 / 100;
        if(this.ma.startsWith("D")) return x * 7 / 200;
        return x * 2 /100;
    }
    
    public String tenHang() {
        if(ma.endsWith("BP")) return "British Petro";
        if(ma.endsWith("ES")) return "Esso";
        if(ma.endsWith("SH")) return "Shell";
        if(ma.endsWith("CA")) return "Castrol";
        if(ma.endsWith("MO")) return "Mobil";
        return "Trong Nuoc";
    }
    
    public long thanhTien(){
        return donGia() * sl + Thue();
    }

    @Override
    public String toString() {
        return ma + " " + tenHang() + " " + donGia() + " " + Thue() + " " + thanhTien();
    } 
}

//3
//N89BP 4500
//D00BP 3500
//X92SH 2600
