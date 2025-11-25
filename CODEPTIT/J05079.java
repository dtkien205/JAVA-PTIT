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
public class J05079 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Lop> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Lop(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        int q = Integer.parseInt(sc.nextLine());
        List<Lop> ds1 = new ArrayList<>();
        while(q-- > 0){
            ds1.clear();
            String ma = sc.nextLine();
            String ten = "";
            for (Lop x : ds){
                if(x.ma.equals(ma)){
                    ds1.add(x);
                    ten = x.ten;
                }
            }
            
            ds1.sort((a, b) -> {
                return a.nhom.compareTo(b.nhom);
            });
            
            System.out.println("Danh sach nhom lop mon " + ten + ":");
            for (Lop x : ds1)
                System.out.println(x);
        }
    }
}

class Lop {
    String ma, ten, nhom, tenGV;
    
    Lop(String ma, String ten, String nhom, String tenGV){
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.tenGV = tenGV; 
    }

    @Override
    public String toString() {
        return nhom + " " + tenGV; 
    }  
}

//4
//THCS2D20
//Tin hoc co so 2 - D20
//01
//Nguyen Binh An
//CPPD20
//Ngon ngu lap trinh C++ - D20
//01
//Le Van Cong
//THCS2D20
//Tin hoc co so 2 - D20
//02
//Nguyen Trung Binh
//LTHDTD19
//Lap trinh huong doi tuong - D19
//01
//Nguyen Binh An
//1
//THCS2D20