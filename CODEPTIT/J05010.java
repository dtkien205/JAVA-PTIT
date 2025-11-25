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
public class J05010 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        List<Hang> ds = new ArrayList();
        for (int i = 0; i < n; i++){
            ds.add(new Hang(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            return Double.compare(b.lai, a.lai);
        });
        
        for (Hang x : ds){
            System.out.println(x);
        }
    }
}

class Hang {
    String ten, nhom;
    double mua, ban, lai;
    int ma;
    static int id = 1;
    
    Hang(String ten, String nhom, double mua, double ban){
        this.ma = id++;
        this.ten = ten;
        this.nhom = nhom;
        this.lai = ban - mua;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + nhom + " " + String.format("%.2f", lai);
    }   
}

//3
//May tinh SONY VAIO
//Dien tu
//16400
//17699
//Tu lanh Side by Side
//Dien lanh
//18300
//25999
//Banh Chocopie
//Tieu dung
//27.5
//37
