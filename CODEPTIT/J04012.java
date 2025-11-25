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
public class J04012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String ten = sc.nextLine();
        long luong = Long.parseLong(sc.nextLine());
        long ngaycong = Long.parseLong(sc.nextLine());
        String chucvu = sc.nextLine();
        Employee x = new Employee (ten, luong, ngaycong, chucvu);
        System.out.println(x);
    }
   
}

class Employee {
    String mnv, hoTen, chucVu;
    long luong, ngayCong;
    static int stt = 1;
    
    public Employee(String ten, long luong, long ngayCong, String chucVu){
        this.mnv = String.format("NV%02d", stt++);
        this.hoTen = ten;
        this.luong = luong;
        this.ngayCong = ngayCong;
        this.chucVu = chucVu;
    }
    
    private long getTienLuong(){
        return luong * ngayCong;
    }
    
    private long getTienThuong(){
        long luongThang = getTienLuong();
        if(ngayCong >= 25) return luongThang * 20 / 100;
        else if(ngayCong >= 22) return luongThang * 10 / 100;
        else return 0;
    }
    
    private long getPhuCap(){
        if (chucVu.equals("GD")) return 250000;
        if (chucVu.equals("PGD")) return 200000;
        if (chucVu.equals("TP")) return 180000;
        if (chucVu.equals("NV")) return 150000;
        return 0;
    }
    
    private long getThuNhap(){
        return getTienLuong() + getTienThuong() + getPhuCap();
    }
    
    @Override
    public String toString() {
        return mnv + " " + hoTen + " " + getTienLuong() + " " + getTienThuong() + " " + getPhuCap() + " " + getThuNhap();
    }
}
