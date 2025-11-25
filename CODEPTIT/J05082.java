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
public class J05082 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<KhachHang> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new KhachHang(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            if(a.y != b.y) return Integer.compare(a.y, b.y);
            if(a.m != b.m) return Integer.compare(a.m, b.m);
            return Integer.compare(a.d, b.d);
        });
        
        for (KhachHang x : ds)
            System.out.println(x);
    }
}

class KhachHang {
    String ma, ten, gt, ns, diaChi;
    int d, m, y;
    static int id = 1;
    
    KhachHang(String ten, String gt, String ns, String diaChi){
        this.ma = String.format("KH%03d", id++);
        this.ten = chuanHoaTen(ten);
        this.gt = gt;
        this.diaChi = diaChi;
        
        String[] t = ns.split("/");
        this.d = Integer.parseInt(t[0]);
        this.m = Integer.parseInt(t[1]);
        this.y = Integer.parseInt(t[2]);
        if(t[0].length() != 2) t[0] = "0" + t[0];
        if(t[1].length() != 2) t[1] = "0" + t[1];
        this.ns = t[0] + "/" + t[1] + "/" + t[2];
    }
    
    public String chuanHoaTen(String x) {
        String res = "";
        String[] t = x.trim().split("\\s+");
        for (int i = 0; i < t.length; i++){
            res += t[i].substring(0, 1).toUpperCase() + t[i].substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gt +  " " + diaChi + " " + ns;
    }
}


//2
// nGuyen VAN     nAm
//Nam
//12/12/1997
//Mo Lao-Ha Dong-Ha Noi
// TRan    vAn     biNh
//Nam
//14/11/1995
//Phung Khoang-Nam Tu Liem-Ha Noi