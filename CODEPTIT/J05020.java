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
public class J05020 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        List<SinhVien> ds = new ArrayList();
        for (int i = 0; i < n ; i++){
            ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            if(!a.lop.equals(b.lop))
                return a.lop.compareTo(b.lop);
            return a.msv.compareTo(b.msv);
        });
        
        for (SinhVien x : ds)
            System.out.println(x);
    }
}

class SinhVien {
    String msv, hoten, lop, email;
    
    SinhVien (String msv, String hoten, String lop, String email){
        this.msv = msv;
        this.hoten = hoten;
        this.lop = lop;
        this.email = email;
    }

    @Override
    public String toString() {
        return msv + " " + hoten + " " + lop + " " + email;
    }
    
}

//4
//B16DCCN011
//Nguyen Trong Duc Anh
//D16CNPM1
//sv1@stu.ptit.edu.vn
//B15DCCN215
//To Ngoc Hieu
//D15CNPM3
//sv2@stu.ptit.edu.vn
//B15DCKT150
//Nguyen Ngoc Son
//D15CQKT02-B
//sv3@stu.ptit.edu.vn
//B15DCKT199
//Nguyen Trong Tung
//D15CQKT03-B
//sv4@stu.ptit.edu.vn
