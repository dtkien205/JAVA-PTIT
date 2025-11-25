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
public class J05056 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<VDV> ds = new ArrayList<>();
        
        for (int i = 0; i < n ;i++){
            ds.add(new VDV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            return Integer.compare(a.tt, b.tt);
        });
        
        ds.get(0).rank = 1;
        for(int i = 1; i < n; i++){
            if(ds.get(i).tt == ds.get(i-1).tt)
                ds.get(i).rank = ds.get(i-1).rank;
            else
                ds.get(i).rank = i + 1;
        }
        
        for (VDV x : ds)
            System.out.println(x.ma + " " + x.ten + " " + x.toTime(x.time) + " " + x.toTime(x.getUuTien(x.ns)) + " "
                + x.toTime(x.tt) + " " + x.rank);
    }
}

class VDV{
    String ma, ten, ns;
    int rank, time, tt;
    static int id = 1;
    
    VDV(String ten, String ns, String st, String ed){
        this.ma = String.format("VDV%02d", id++);
        this.ten = ten;
        this.ns = ns;
        this.time = VDV.getTime(ed) - VDV.getTime(st);
        this.tt = time - getUuTien(ns);
    }
    
    public static int getTime(String s){
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 3600 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(t[2]);
    }
    
    public int getUuTien(String s){
        int namSinh = Integer.parseInt(s.substring(6));
        int tuoi = 2021 - namSinh;
        if(tuoi >= 32) return 3;
        if(tuoi >= 25) return 2;
        if(tuoi >= 18) return 1;
        return 0;
    }
    
    public String toTime(int x){
        int h = x / 3600;
        x %= 3600;
        int m = x / 60;
        x %= 60;
        int s = x % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    } 
}

//3
//Nguyen Van Thanh
//20/03/1990
//07:00:00
//07:10:01
//Nguyen Hoa Binh
//01/10/1993
//07:02:00
//07:11:20
//Le Thanh Van
//15/03/1998
//07:05:00
//07:15:30