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
public class J05013 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<ThiSinh> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new ThiSinh(sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            return Double.compare(b.diem(), a.diem());
        });
        
        for (ThiSinh x : ds)
            System.out.println(x);
    }
}

class ThiSinh {
    String ma, ten;
    double lt, th;
    static int id = 1;
    
    ThiSinh(String ten, double lt, double th){
        this.ma = String.format("TS%02d", id++);
        this.ten = ten;
        this.lt = (lt <= 10) ? lt : lt / 10;
        this.th = (th <= 10) ? th : th / 10;
    }
    
    public double diem() {
        return (lt + th) / 2;
    }
    
    public String xepLoai() {
        if(diem() < 5) return "TRUOT";
        if(diem() < 8) return "CAN NHAC";
        if(diem() <= 9.5) return "DAT";
        return "XUAT SAC";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.2f", diem()) + " " + xepLoai();
    }
}

//3
//Nguyen Thai Binh
//45
//75
//Le Cong Hoa
//4
//4.5
//Phan Van Duc
//56
//56