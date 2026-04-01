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
public class J06008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<String, Mon> mapMon = new HashMap<>();
        Map<String, GiangVien> mapGV = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++){
            String maMon = sc.next();
            String ten = sc.nextLine().trim();
            Mon x = new Mon(maMon, ten);
            mapMon.put(maMon, x);
        }
        
        List<Lop> ds = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String maGV = sc.next();
            String ten = sc.nextLine().trim();
            GiangVien x = new GiangVien(maGV, ten);
            mapGV.put(maGV, x);
        }
        
        int p = sc.nextInt();
        for (int i = 0; i < p; i++) {
            String maGV = sc.next();
            String maMon = sc.next();
            double gio = sc.nextDouble();
            Lop x = new Lop(maGV, mapMon.get(maMon), gio);
            ds.add(x);
        }
        
        String s = sc.next();
        double tong = 0;
        System.out.println("Giang vien: " + mapGV.get(s).ten);
        for (Lop x : ds) {
            if (x.maGV.equals(s)){
                System.out.println(x);
                tong += x.gio;
            }
        }
        System.out.printf("Tong: %.2f\n", tong);
    }
}

class Mon {
    String ma, ten;
    
    Mon(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}

class GiangVien {
    String ma, ten;
    
    GiangVien (String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}

class Lop {
    String maGV;
    Mon mon;
    double gio;
    
    Lop (String maGV, Mon mon, double gio) {
        this.maGV = maGV;
        this.mon = mon;
        this.gio = gio;
    }

    @Override
    public String toString() {
        return mon.ten + " " + gio;
    }
}

//2
//INT1155 Tin hoc co so 2
//INT1306 Cau truc du lieu va giai thuat
//2
//GV01 Nguyen Van An
//GV02 Hoang Binh Minh
//2
//GV01 INT1155 113.2
//GV02 INT1306 126.72
