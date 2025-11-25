/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class J05004 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        SinhVien[] ds = new SinhVien[n];
        
        for (int i = 0 ; i < n ; i++){
            ds[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
        }
        
        for (int i = 0; i < n ; i++){
            System.out.println(ds[i]);
        }
    }
}

class SinhVien{
    String msv, hoten, lop, ns;
    double gpa;
    static int id = 1;
    
    SinhVien(String hoten, String lop, String ns, double gpa){
        this.msv = String.format("B20DCCN%03d", id++);
        this.hoten = chuanHoaTen(hoten);
        this.lop = lop;
        this.ns = chuanHoaNgay(ns);
        this.gpa = gpa;
    }
    
    @Override
    public String toString(){
        return msv + " " + hoten + " " + lop + " " + ns + " " + String.format("%.2f", gpa);
    }
    
    public static String chuanHoaTen(String s){
        s = s.trim().toLowerCase();
        String[] ten = s.split("\\s+");
        String res = "";
        for (String x : ten){
            res += x.substring(0, 1).toUpperCase() + x.substring(1) + " ";
        }
        return res;
    }
    
    public static String chuanHoaNgay(String s){
        String[] ns = s.split("/");
        if(ns[0].length() != 2) ns[0] = "0" + ns[0];
        if(ns[1].length() != 2) ns[1] = "0" + ns[1];
        return ns[0] + "/" + ns[1] + "/" + ns[2];
    }
}


//1
//nGuyEn  vaN    biNH
//D20CQCN01-B
//2/12/2002
//3.1