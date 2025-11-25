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
public class J05011 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        List<Time> ds = new ArrayList();
        for (int i = 0; i < n; i++){
            ds.add(new Time(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            return Integer.compare(b.m, a.m);
        });
        
        for (Time x : ds){
            System.out.println(x);
        }
    }
}

class Time {
    String ma, ten, vao, ra;
    int m;
    
    Time(String ma, String ten, String vao, String ra){
        this.ma = ma;
        this.ten = ten;
        this.vao = vao;
        this.ra = ra;
        this.m = mins(vao, ra);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + m / 60 + String.format(" gio %d phut", m % 60);
    }

    public static int mins(String vao, String ra) {
        String[] t1 = vao.split(":");
        String[] t2 = ra.split(":");
        int in = Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1]);
        int out = Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1]);
        return out - in;
    }
    
}

//3
//01T
//Nguyen Van An
//09:00
//10:30
//06T
//Hoang Van Nam
//15:30
//18:00
//02I
//Tran Hoa Binh
//09:05
//10:00
