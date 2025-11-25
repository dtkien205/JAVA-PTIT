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
public class J05025 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        List<GiangVien> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            if(!a.getTen().equals(b.getTen()))
                return a.getTen().compareTo(b.getTen());
            return a.ma.compareTo(b.ma);
        });
        
        for (GiangVien x : ds)
            System.out.println(x);
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
    
    public String getTen(){
        String[] t = this.ten.trim().split("\\s+");
        return t[t.length - 1];
    }


    @Override
    public String toString() {
        return ma + " " + ten + " " + boMon(mon);
    }  
}

//3
//Nguyen Manh Son
//Cong nghe phan mem
//Vu Hoai Nam
//Khoa hoc may tinh
//Dang Minh Tuan
//An toan thong tin
