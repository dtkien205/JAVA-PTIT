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
public class J05057 {  
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
        
        for (ThiSinh x : ds){
            System.out.println(x);
        }
    }
}

class ThiSinh {
    String ma, ten;
    double tong;
    
    ThiSinh(String ma, String ten, double d1, double d2, double d3){
        this.ma = ma;
        this.ten = ten;
        this.tong = d1 * 2 + d2 + d3;
    }
    
    public double getUuTien(){
        String kv = this.ma.substring(0, 3);
        if(kv.equals("KV1")) return 0.5;
        if(kv.equals("KV2")) return 1;
        return 2.5;
    }
    
    public String kq(){
        if(this.tong + getUuTien() >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }
    
    public static String fm(double x){
        if((int)x == x) return String.format("%.0f", x);
        return String.format("%.1f", x);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + fm(getUuTien()) + " " + fm(tong) + " " + kq();
    } 
}

//2
//KV2A002
//Hoang Thanh Tuan
//5
//6
//5
//KV2B123
//Ly Thi Thu Ha
//8
//6.5
//7
