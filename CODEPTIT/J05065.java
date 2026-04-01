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
public class J05065 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<NhanVien> ds = new ArrayList<>();
        
        int cntGD = 0;
        int cntTP = 0;
        int cntPP = 0;
        
        for (int i = 0; i < n; i++) {
            String ma = sc.next();
            String ten = sc.next();
            sc.nextLine();
            NhanVien x = new NhanVien(ma, ten);
            
            String chucVuGoc = x.chucVu;
            
            if (chucVuGoc.equals("GD")){
                cntGD++;
            }
            
            ds.add(x);
        }
        
        ds.sort((a, b) -> {
            if (a.bacLuong != b.bacLuong) return Integer.compare(b.bacLuong, a.bacLuong);
            return Integer.compare(a.soHieu, b.soHieu);
        });
        
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String cv = sc.nextLine();
            for (NhanVien x : ds){
                if(cv.equals(x.chucVu)){
                    System.out.println(x);
                }
            }
            System.out.println();
        }
    }
}

class NhanVien {
    String ma, ten, chucVu;
    int bacLuong, soHieu;
    
    NhanVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        
        this.chucVu = ma.substring(0, 2);
        this.bacLuong = Integer.parseInt(ma.substring(2, 4));
        this.soHieu = Integer.parseInt(ma.substring(4));
    }

    @Override
    public String toString() {
        return ten + " " + chucVu + " " + String.format("%03d", soHieu) + " " + String.format("%02d", bacLuong);
    }  
}

//6
//GD08001 Nguyen Kim Loan
//TP05002 Hoang Thanh Tuan
//TP05001 Tran Binh Nguyen
//PP06002 Phan Trung Tuan
//PP06001 Tran Quoc Huy
//NV04003 Vo Van Lan
//2
//TP
//PP