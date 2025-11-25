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
public class J05005 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        List<SinhVien> list = new ArrayList();
        
        for (int i = 0; i < n; i++){
            list.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()))) ;
        }
        
        list.sort((a, b) -> {
            return Double.compare(b.gpa, a.gpa);
        });
        
//        for (int i = 0; i < n; i++){
//            System.out.print(list.get(i));
//        }
        for (SinhVien x : list)
            System.out.println(x);  
    }
}

class SinhVien {
    String msv, hoTen, lop, ns;
    double gpa;
    static int id = 1;
    
    SinhVien(String hoTen, String lop, String ns, double gpa){
        this.msv = String.format("B20DCCN%03d", id++);
        this.hoTen = chuanHoaTen(hoTen);
        this.lop = lop;
        this.ns = chuanHoaNgay(ns);
        this.gpa = gpa;
    }

    public static String chuanHoaTen(String s){
        s = s.trim().toLowerCase();
        String[] ten = s.split("\\s+");
        String res = "";
        for (String x : ten){
            res += x.substring(0, 1).toUpperCase() + x.substring(1) + " ";
        }
        return res;
    }
    
    public static String chuanHoaNgay(String s){
        String[] ns = s.split("/");
        if(ns[0].length() != 2) ns[0] = "0" + ns[0];
        if(ns[1].length() != 2) ns[1] = "0" + ns[1];
        return ns[0] + "/" + ns[1] + "/" + ns[2];
    }

    @Override
    public String toString() {
        return msv + " " + hoTen + " " + lop + " " + ns + " " + String.format("%.2f", gpa);
    }    
}


//2
//ngUYen Van NaM
//D20DCCN01-B
//2/12/1994
//2.17
//Nguyen QuanG hAi
//D20DCCN02-B
//1/9/1994
//3.0