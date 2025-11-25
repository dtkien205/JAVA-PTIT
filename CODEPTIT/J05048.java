/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;

/**
 *
 * @author PC
 */
public class J05048 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Hang> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Hang(sc.nextLine(),             
                       Long.parseLong(sc.nextLine())));
        }
        
        for (Hang x : ds){
            System.out.println(x);
        }
    }
}

class Hang {
    String ma;
    long nhap;
    
    Hang(String ma, long nhap){
        this.ma = ma;
        this.nhap = nhap;
    }
    
    public long xuat() {
        if(ma.startsWith("A")) return Math.round(nhap * 60.0 / 100);
        return Math.round(nhap * 70.0 / 100);
    }
    
    public long donGia() {
        if(ma.endsWith("Y")) return 110000;
        return 135000;
    }
    
    public long tien() {
        return xuat() * donGia();
    }
    
    public long thue() {
        if(ma.startsWith("A") && ma.endsWith("Y")) return tien() * 8 / 100;
        if(ma.startsWith("A") && ma.endsWith("N")) return tien() * 11 / 100;
        if(ma.startsWith("B") && ma.endsWith("Y")) return tien() * 17 / 100;
        return tien() * 22 / 100;
    }

    @Override
    public String toString() {
        return ma + " " + nhap + " " + xuat() + " " + donGia() + " " + tien() + " " + thue();
    } 
}

//3
//A001Y
//1000
//B012N
//2500
//B003Y
//4582