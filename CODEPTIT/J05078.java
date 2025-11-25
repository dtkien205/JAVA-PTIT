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
public class J05078 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<PhongBan> p = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String[] t = sc.nextLine().split(" ", 2);
            p.add(new PhongBan(t[0], t[1]));
        }
        
        int m = Integer.parseInt(sc.nextLine());
        List<NhanVien> nv = new ArrayList<>();
        for (int i  = 0; i < m; i++){
            nv.add(new NhanVien(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine())));
        }
        
        for (PhongBan x : p){
            for (NhanVien y : nv){
                if(x.ma.equals(y.mnv.substring(3)))
                    y.phong = x.tenPhong;
            }
        }
        
        String tmp = sc.nextLine(), Phong = "";
        for (PhongBan x : p){
            if(x.ma.equals(tmp)){
                Phong = x.tenPhong;
                break;
            }
        }
        
        System.out.printf("Bang luong phong %s:\n", Phong);
        
        for (NhanVien x : nv){
            if(x.phong.equals(Phong))
                System.out.println(x);
        }
    }
}

class PhongBan {
    String ma, tenPhong;
    
    PhongBan(String ma, String tenPhong){
        this.ma = ma;
        this.tenPhong = tenPhong;
    }
}

class NhanVien {
    String mnv, ten, phong;
    long luong, ngay;
    
    NhanVien(String mnv, String ten, long luong, long ngay){
        this.mnv = mnv;
        this.ten = ten;
        this.luong = luong;
        this.ngay = ngay;
    }
    
    public int heSo() {
        String loai = this.mnv.substring(0, 1);
        int nam = Integer.parseInt(mnv.substring(1, 3));
        
        if(loai.equals("A")){
            if(nam >= 16) return 20;
            if(nam >= 9) return 14;
            if(nam >= 4) return 12;
            return 10;
        }
        
        if(loai.equals("B")){
            if(nam >= 16) return 16;
            if(nam >= 9) return 13;
            if(nam >= 4) return 11;
            return 10;
        }
        
        if(loai.equals("C")){
            if(nam >= 16) return 14;
            if(nam >= 9) return 12;
            if(nam >= 4) return 10;
            return 9;
        }
        
        if(loai.equals("D")){
            if(nam >= 16) return 13;
            if(nam >= 9) return 11;
            if(nam >= 4) return 9;
            return 8;
        }
        return 0;
    }
    
    public long luongThang() {
        return luong * ngay * heSo();
    }

    @Override
    public String toString() {
        return mnv + " " + ten + " " + luongThang() * 1000;
    }
}


//2
//HC Hanh chinh
//KH Ke hoach Dau tu
//2
//C06HC
//Tran Binh Minh
//65
//25
//D03KH
//Le Hoa Binh
//59
//24
//KH