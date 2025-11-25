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
public class J05029  {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());    
        List<DoanhNghiep> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new DoanhNghiep(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }
        
        ds.sort((a, b) ->{
            if(a.sl != b.sl) return Integer.compare(b.sl, a.sl);
            return a.ma.compareTo(b.ma);
        });
        
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + a + " DEN " + b + " SINH VIEN:");
            for (DoanhNghiep x : ds){
                if(x.sl >= a && x.sl <= b)
                    System.out.println(x);
            }
        }
    }
}

class DoanhNghiep {
    String ma, ten;
    int sl;
    
    DoanhNghiep(String ma, String ten, int sl){
        this.ma = ma;
        this.ten = ten;
        this.sl = sl;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + sl;
    }  
}

//4
//VIETTEL
//TAP DOAN VIEN THONG QUAN DOI VIETTEL
//40
//FSOFT
//CONG TY TNHH PHAN MEM FPT - FPT SOFTWARE
//300
//VNPT
//TAP DOAN BUU CHINH VIEN THONG VIET NAM
//200
//SUN
//SUN*
//50
//1
//30 50
