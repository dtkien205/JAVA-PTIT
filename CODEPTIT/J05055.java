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
public class J05055 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List <Time> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new Time(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        List<Time> ds1 = new ArrayList<>(ds);
        ds1.sort((a, b) -> {
            return Integer.compare(a.tt, b.tt);
        });
        
        ds1.get(0).rank = 1;
        for (int i = 1; i < n; i++){
            if (ds1.get(i).tt == ds1.get(i - 1).tt)
                ds1.get(i).rank = ds1.get(i - 1).rank;
            else ds1.get(i).rank = i + 1;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
            if(ds.get(i).ma.equals(ds1.get(j).ma))
                ds.get(i).rank = ds1.get(j).rank;
            }
        }
        
        for (Time x : ds){
            System.out.println(x);
        }
    }
}

class Time {
    String ma, ten, ns;
    int rank, tt, time;
    static int id = 1;
    
    Time (String ten, String ns, String st, String ed){
        this.ma = String.format("VDV%02d", id++);
        this.ten = ten;
        this.ns = ns;
        this.time = getTime(ed) - getTime(st);
        this.tt = time - uuTien();
    }
    
    public int getTime(String s) {
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 3600 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(t[2]);
    }
    
    public String toTime(int x) {
        int h = x /  3600;
        x %= 3600;
        int m = x / 60;
        x %= 60;
        int s = x % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    
    public int uuTien() {
        int tuoi = 2021 - Integer.parseInt(ns.substring(6));
        if(tuoi >= 32) return 3;
        if(tuoi >= 25) return 2;
        if(tuoi >= 18) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + toTime(time) + " " + toTime(uuTien()) + " " + toTime(tt) + " " + rank;
    }  
}
