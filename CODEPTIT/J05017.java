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
public class J05017 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<KH> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new KH(sc.nextLine(), 
                    Integer.parseInt(sc.nextLine()),
                    Integer.parseInt(sc.nextLine())));
        }
        ds.sort((a, b) -> {
            return Long.compare(b.tongTien(), a.tongTien());
        });
        for (KH x : ds)
            System.out.println(x);
    }
}

class KH {
    String ma, ten;
    static int id = 1;
    int so;
    
    KH (String ten, int cu, int moi){
        this.ma = String.format("KH%02d", id++);
        this.ten = ten;
        this.so = moi - cu; 
    }
    
    public long tongTien() {
        if (so <= 50) return so * 100 + Math.round(so * 100 * 0.02);
        if (so <= 100) return 50 * 100 + (so - 50) * 150 + Math.round((50 * 100 + (so - 50) * 150) * 0.03);
        return 50 * 100 + 50 * 150 + (so - 100) * 200 + Math.round((50 * 100 + 50 * 150 + (so - 100) * 200) * 0.05);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tongTien();
    }  
}

//3
//Le Thi Thanh
//468
//500
//Le Duc Cong
//160
//230
//Ha Hue Anh
//410
//612
