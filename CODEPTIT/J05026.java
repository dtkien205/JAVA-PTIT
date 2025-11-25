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
public class J05026 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        List<GiangVien> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        }
        
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String mon = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN BO MON " + GiangVien.boMon(mon) + ":");
            for (GiangVien x : ds){
                if(mon.equals(x.mon))
                    System.out.println(x);
            }
        }
    }
}

class GiangVien {
    String ma, ten, mon;
    static int id = 1;
    
    GiangVien(String ten, String mon){
        this.ma = String.format("GV%02d", id++);
        this.ten = ten;
        this.mon = mon;
    }
    
    public static String boMon(String s){
        String[] t = s.split("\\s+");
        String res = "";
        for (int i = 0; i < t.length; i++){
            res += t[i].toUpperCase().charAt(0);
        }
        return res;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + boMon(mon);
    }  
}
