/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author PC
 */

public class J05081 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n =  Integer.parseInt(sc.nextLine());
        ArrayList<Hang> a = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            a.add(new Hang(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        
        Collections.sort(a);
        
        for (Hang x : a)
            System.out.println(x);
    }
}


class Hang implements Comparable<Hang>{
    static int id = 0;
    String ma, ten, dv;
    int mua, ban, lai;
    
    Hang(String ten, String dv, int mua, int ban){
        this.ma = String.format("MH%03d", ++id);
        this.ten = ten;
        this.dv = dv;
        this.mua = mua;
        this.ban = ban;
        this.lai = ban - mua;
    }
    
    @Override
    public int compareTo(Hang a){
        if(this.lai != a.lai)
            return a.lai - this.lai;
        return this.ma.compareTo(a.ma);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + dv + " " + mua + " " + ban + " " + lai;
    }
}


//2
//Ao phong tre em
//Cai
//25000
//41000
//Ao khoac nam
//Cai
//240000
//515000
