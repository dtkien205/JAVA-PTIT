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
public class J05074 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<SV> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        for (int i = 0; i < n; i++){
            String msv = sc.next();
            String dd = sc.next();
            sc.nextLine();
            for (SV x : ds){
                if(x.msv.equals(msv)){
                    x.dd = dd;
                }
            }
        }
        for (SV x : ds)
            System.out.println(x);
    }
}

class SV {
    String msv, ten, lop, dd;
    
    SV(String msv, String ten, String lop){
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
    }
    
    public int tinhDiem() {
        int diem = 10;
        for (int i = 0; i < dd.length(); i++){
            if(dd.charAt(i) == 'v') diem -= 2;
            if(dd.charAt(i) == 'm') diem -= 1;
        }
        return Math.max(diem, 0);
    }
    
    public String kq() {
        if(tinhDiem() == 0) return "KDDK";
        return "";
    }

    @Override
    public String toString() {
        return msv + " " + ten + " " + lop + " " + tinhDiem() + " " + kq();
    } 
}
