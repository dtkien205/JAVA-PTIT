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
public class J05012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Hang> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new Hang(sc.nextLine(), sc.nextLine(),
                        Long.parseLong(sc.nextLine()),
                        Long.parseLong(sc.nextLine()),
                        Long.parseLong(sc.nextLine())));
        }
        ds.sort((a, b) -> {
            return Long.compare(b.tongTien(), a.tongTien());
        });
        
        for(Hang x : ds)
            System.out.println(x);
    }
}

class Hang{
    String ma, ten;
    long sl, donGia, chietKhau;
    
    Hang(String ma, String ten, long sl, long donGia, long chietKhau){
        this.ma = ma;
        this.ten = ten;
        this.sl = sl;
        this.donGia = donGia;
        this.chietKhau = chietKhau;
    }
    
    public long tongTien() {
        return sl * donGia - chietKhau;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + sl + " " + donGia + " " + chietKhau + " " + tongTien();
    } 
}

//3
//ML01
//May lanh SANYO
//12
//4000000
//2400000
//ML02
//May lanh HITACHI
//4
//2550000000
//0
//ML03
//May lanh NATIONAL
//5
//3000000
//150000