/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07034 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("MONHOC.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<MonHoc> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new MonHoc(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }
        ds.sort((a, b) ->{
           return a.ten.compareTo(b.ten);
        });
        
        for(MonHoc x : ds)
            System.out.println(x);
    }
}

class MonHoc {
    String ma, ten;
    int tc;
    
    MonHoc(String ma, String ten, int tc){
        this.ma = ma;
        this.ten = ten;
        this.tc = tc;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tc;
    } 
    
    
}
