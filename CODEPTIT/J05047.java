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
public class J05047 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Hang> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Hang(sc.nextLine(),
                       Long.parseLong(sc.nextLine()),
                       Long.parseLong(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            return Long.compare(b.tienChietKhau(), a.tienChietKhau());
        });
        
        for (Hang x : ds){
            System.out.println(x);
        }
    }
}

class Hang {
    String ma, ten;
    long sl, donGia;
    static Map<String, Integer> dem = new HashMap<>();
    
    Hang(String ten, long sl, long donGia){
        this.ten = ten;
        this.sl = sl;
        this.donGia = donGia;
        
        String[] t = ten.split("\\s+");
        String prefix = ("" + t[0].charAt(0) + t[1].charAt(0)).toUpperCase();

        int stt = dem.getOrDefault(prefix, 0) + 1;
        dem.put(prefix, stt);

        this.ma = prefix + String.format("%02d", stt);
    }
    
    public long tienChietKhau() {
        long gia = donGia * sl;
        if(sl > 10) return gia * 5 / 100;
        if(sl >= 8) return gia * 2 / 100;
        if(sl >= 5) return gia / 100;
        return 0;
    }
    
    public long thanhTien() {
        return donGia * sl - tienChietKhau();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tienChietKhau() + " " + thanhTien();
    }
}

//3
//May lanh SANYO
//12
//4000000
//Dien thoai Samsung
//30
//3230000
//Dien thoai Nokia
//18
//1240000
