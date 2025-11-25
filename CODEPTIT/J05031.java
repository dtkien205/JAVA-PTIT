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
public class J05031 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());    
        List<SinhVien> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(),
                        Double.parseDouble(sc.nextLine()),
                        Double.parseDouble(sc.nextLine()),
                        Double.parseDouble(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            return a.ten.compareTo(b.ten);
        });
        
        for (int i = 0; i < ds.size(); i++){
            System.out.print(i + 1 + " ");
            System.out.println(ds.get(i));
        } 
    }
}

class SinhVien {
    String msv, ten, lop;
    double d1, d2, d3;
    
    SinhVien(String msv, String ten, String lop, double d1, double d2, double d3){
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    @Override
    public String toString() {
        return msv + " " + ten + " " + lop + " " + d1 + " " + d2 + " " + d3;
    }  
}

//3
//B20DCCN999
//Nguyen Van An
//D20CQCN04-B
//10.0
//9.0
//8.0
//B20DCAT001
//Le Van Nam
//D20CQAT02-B
//6.0
//6.0
//4.0
//B20DCCN111
//Tran Hoa Binh
//D20CQCN04-B
//9.0
//5.0
//6.0
