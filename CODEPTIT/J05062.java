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
public class J05062 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        List<SinhVien> ds = new ArrayList<>();
        List<Double> dtb = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String ten = sc.nextLine();
            double gpa = Double.parseDouble(sc.next());
            int drl = Integer.parseInt(sc.next());
            
            ds.add(new SinhVien(ten, gpa, drl));
            dtb.add(gpa);
        }
        
        dtb.sort((a, b) -> {
            return Double.compare(b, a);
        });
        double diemChuan = dtb.get(m - 1);
        for (SinhVien x : ds){
            if (x.gpa >= diemChuan)
                x.loai = x.xepLoai();
            else x.loai = "KHONG";
            System.out.println(x);
        }
    }
}

class SinhVien {
    String ten, loai;
    double gpa;
    int drl;
    
    SinhVien(String ten, double gpa, int drl){
        this.ten = ten;
        this.gpa = gpa;
        this.drl = drl;
    }
    
    public String xepLoai() {
        if (drl >= 90 && gpa >= 3.6) return "XUATSAC";
        if (drl >= 80 && gpa >= 3.2) return "GIOI";
        if (drl >= 70 && gpa >= 2.5) return "KHA";
        return "KHONG";
    }

    @Override
    public String toString() {
        return ten + ": " + loai; 
    } 
}

//3 2
//Nguyen Van Nam
//3.59 75
//Tran Hong Ngoc
//3.61 90
//Do Van An
//3.22 90