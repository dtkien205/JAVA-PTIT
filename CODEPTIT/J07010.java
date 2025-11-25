/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author PC
 */
public class J07010 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("SV.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(),
                            Double.parseDouble(sc.nextLine())));
        }
        
        for (SinhVien x : ds)
            System.out.println(x);
    }
}

class SinhVien {
    String msv, hoten, ns, lop;
    double gpa;
    static int id = 1;
    
    SinhVien(String hoten, String lop, String ns, double gpa){
        this.msv = String.format("B20DCCN%03d", id++);
        this.hoten = hoten;
        this.lop = lop;
        this.ns = chuanHoaNgay(ns);
        this.gpa = gpa;
    }
    
    public String chuanHoaNgay(String ns) {
        String[] t = ns.split("/");
        if(t[0].length() != 2) t[0] = "0" + t[0];
        if(t[1].length() != 2) t[1] = "0" + t[1];
        return t[0] + "/" + t[1] + "/" + t[2];
    }

    @Override
    public String toString() {
        return msv + " " + hoten + " " + lop + " " + ns + " " + String.format("%.2f", gpa);
    }  
}

//1
//Nguyen Van An
//D20CQCN01-B
//2/12/2002
//3.19