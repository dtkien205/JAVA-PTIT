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
public class J06003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        Map<Integer, String> mapNhom = new HashMap<>();
        List<SinhVien> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++ ) {
            String msv = sc.nextLine();
            String ten = sc.nextLine();
            String sdt = sc.nextLine();
            int stt = Integer.parseInt(sc.nextLine());
            SinhVien x = new SinhVien(msv, ten, sdt, stt);
            ds.add(x);
        }
        
        for (int i = 1; i <= m; i++) {
            String x = sc.nextLine();
            mapNhom.put(i, x);
        }
        
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            int nhom = sc.nextInt();
            System.out.println("DANH SACH NHOM " + nhom + ":");
            for (SinhVien x : ds) {
                if(x.stt == nhom) {
                    System.out.println(x);
                }
            }
            System.out.println("Bai tap dang ky: " + mapNhom.get(nhom));
        }
    }
}

class SinhVien {
    String msv, ten, sdt;
    int stt;
    
    SinhVien (String msv, String ten, String sdt, int stt) {
        this.msv = msv;
        this.ten = ten;
        this.sdt = sdt;
        this.stt = stt;
    }

    @Override
    public String toString() {
        return msv + " " + ten + " " + sdt;
    }
}


//5 2
//B17DTCN001
//Nguyen Chi  Linh
//0987345543
//1
//B17DTCN011
//Vu Viet Thang
//0981234567
//1
//B17DTCN023
//Pham Trong Thang
//0992123456
//1
//B17DTCN022
//Nguyen Van  Quyet
//0977865432
//2
//B17DTCN031
//Ngo Thanh Vien
//0912313111
//2
//Xay dung website ban dien thoai truc tuyen
//Xay dung ung dung quan ly benh nhan Covid-19
//1
//1