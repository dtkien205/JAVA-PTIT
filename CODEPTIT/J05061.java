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
public class J05061 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Person> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Person(sc.nextLine(), sc.nextLine(),
                       Double.parseDouble(sc.nextLine()),
                       Double.parseDouble(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            if(a.diem() != b.diem()) return Long.compare(b.diem(), a.diem());
            return a.ma.compareTo(b.ma);
        });
        
        for (Person x : ds)
            System.out.println(x);
    }
}

class Person {
    String ma, ten, ns;
    double lt, th;
    static int id = 1;
    
    Person (String ten, String  ns, double lt, double th){
        this.ma = String.format("PH%02d", id++);
        this.ten = ten;
        this.ns = ns;
        this.lt = lt;
        this.th = th;
    }
    
    public long diem() {
        double tb = (lt + th) / 2.0 + diemThuong();
        if (tb > 10) tb = 10;
        return Math.round(tb);
    }

    
    public double diemThuong() {
        if (lt >= 8 && th >= 8) return 1;
        if(lt >= 7.5 && th >= 7.5) return 0.5;
        return 0;
    }
    
    public String xepLoai() {
        if (diem() >= 9) return "Xuat sac";
        if (diem() == 8) return "Gioi";
        if (diem() == 7) return "Kha";
        if (diem() >= 5) return "Trung binh";
        return "Truot";
    }
    
    public int tuoi() {
        return 2021 - Integer.parseInt(ns.substring(6));
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tuoi() + " " + diem() + " " + xepLoai();
    } 
}

//3
//Doan Thi Kim
//13/03/1982
//8
//9.5
//Dinh Thi Ngoc Ha
//03/09/1996
//6.5
//8
//Tran Thanh Mai
//12/09/2004
//8
//9
