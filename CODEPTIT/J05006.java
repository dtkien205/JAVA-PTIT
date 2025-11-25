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
public class J05006 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        List<NhanVien> ds = new ArrayList();
        for (int i = 0; i < n; i++){
            ds.add(new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(),  sc.nextLine()));
        }
        
        for (NhanVien x : ds)
            System.out.println(x);
    }
}

class NhanVien {
    String mnv, hoten, gt, ns, dc, mst, nkhd;
    static int id = 1;
    
    NhanVien (String hoten, String gt, String ns, String dc, String mst, String nkhd){
        this.mnv = String.format("000%02d", id++);
        this.hoten = hoten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
        this.mst = mst;
        this.nkhd = nkhd;
    }

    @Override
    public String toString() {
        return mnv + " " + hoten + " " + gt + " " + ns + " " + dc + " " + mst + " " + nkhd;
    }   
}

//3
//Nguyen Van A
//Nam
//22/10/1982
//Mo Lao-Ha Dong-Ha Noi
//8333012345
//31/12/2013
//Ly Thi B
//Nu
//15/10/1988
//Mo Lao-Ha Dong-Ha Noi
//8333012346
//22/08/2011
//Hoang Thi C
//Nu
//04/02/1981
//Mo Lao-Ha Dong-Ha Noi
//8333012347
//22/08/2011
