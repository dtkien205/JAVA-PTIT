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
public class J04013 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        HocSinh x = new HocSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        System.out.println(x);
    }
}

class HocSinh {
    String mts, ten;
    double d1, d2, d3;
    
    HocSinh(String mts, String ten, double d1, double d2, double d3){
        this.mts = mts;
        this.ten = ten;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
    
    private double getDiemUT(){
        String tmp = mts.substring(0, 3);
        if(tmp.equals("KV1")) return 0.5;
        if(tmp.equals("KV2")) return 1;
        if(tmp.equals("KV3")) return 2.5;
        return 0;
    }
    
    private double getTongDiem(){
        return d1 * 2 + d2 + d3;
    }
    
    private String getKetQua(){
        double tong = getTongDiem() + getDiemUT();
        if(tong >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }
    
    public String format(double x){
        if(x == (int)x) return String.valueOf((int)x);
        return String.valueOf(x);
    }
    
    @Override
    public String toString(){
    return mts + " " + ten + " " 
            + format(getDiemUT()) + " " 
            + format(getTongDiem()) + " " 
            + getKetQua();
    }
}
