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
public class J05075 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        for (int i = 0; i < n; i++){
            String msv = sc.next();
            String cc = sc.next();
            for (SinhVien x : ds){
                if(x.msv.equals(msv)){
                    x.dd = cc;
                    x.diem = x.tinhDiem();
                }
            }
        }
        
        String lop = sc.next();
        for (SinhVien x : ds){
                if(x.lop.equals(lop)){
                    System.out.println(x);
                }
            }
    }
}

class SinhVien {
    String msv, ten, lop, dd;
    int diem;
    
    SinhVien(String msv, String ten, String lop){
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
    }
    
    public int tinhDiem() {
        int d = 10;
        for (int i = 0; i < dd.length(); i++){
            if(dd.charAt(i) == 'm') d -= 1;
            if(dd.charAt(i) == 'v') d -= 2;
        }
        return Math.max(d, 0);
    }
    
    public String tinhCC() {
        if(diem == 0) return "KDDK";
        return "";
    }

    @Override
    public String toString() {
        return msv + " " + ten + " " + lop + " " + diem + " " + tinhCC();
    }   
}

//3
//B19DCCN999
//Le Cong Minh
//D19CQAT02-B
//B19DCCN998
//Tran Truong Giang
//D19CQAT02-B
//B19DCCN997
//Nguyen Tuan Anh
//D19CQCN04-B
//B19DCCN998 xxxmxmmvmx
//B19DCCN997 xmxmxxxvxx
//B19DCCN999 xvxmxmmvvm
//D19CQAT02-B
