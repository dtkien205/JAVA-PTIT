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
public class J05080 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Lop> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Lop(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            if(!a.ma.equals(b.ma)) return a.ma.compareTo(b.ma);
            return a.nhom.compareTo(b.nhom);
        });
        
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String tenGV = sc.nextLine();
             System.out.println("Danh sach cho giang vien " + tenGV + ":"); 
            for (Lop x : ds){
                if(x.tenGV.equals(tenGV)){
                    System.out.println(x);
                }
            }
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
        return ma + " " + ten + " " + nhom; 
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
//Nguyen Binh An