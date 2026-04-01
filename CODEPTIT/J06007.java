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
public class J06007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++)
            sc.nextLine();
        
        List<GiangVien> ds = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String maGV = sc.next();
            String ten = sc.nextLine().trim();
            ds.add(new GiangVien(maGV, ten));
        }
        
        int p = sc.nextInt();
        for (int i = 0; i < p; i++) {
            String maGV = sc.next();
            String maMon = sc.next();
            double gio = sc.nextDouble();
            for (GiangVien x : ds) {
                if (maGV.equals(x.ma)){
                    x.themGio(gio);
                }
            }
        }
        
        for (GiangVien x : ds) System.out.println(x);
    }
}

class GiangVien {
    String ma, ten;
    double soGio;
    
    GiangVien (String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.soGio = 0;
    }
    
    public void themGio(double gio) {
        this.soGio += gio;
    }

    @Override
    public String toString() {
        return ten + " " + String.format("%.2f", soGio);
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
