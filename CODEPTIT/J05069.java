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
public class J05069 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<CLB> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new CLB(sc.nextLine(), sc.nextLine(),
                       Integer.parseInt(sc.nextLine())));
        }
        
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String tmp = sc.next();
            long sl = Integer.parseInt(sc.next());
            sc.nextLine();
            
            String maCLB = tmp.substring(1, 3);
            for (CLB x : ds){
                if(x.ma.equals(maCLB)){
                    System.out.println(tmp + " " + x.ten + " " + x.giaVe * sl);
                    break;
                }
            }
        }   
    }
}

class CLB {
    String ma, ten;
    long giaVe;
    
    CLB(String ma, String ten, long giaVe){
        this.ma = ma;
        this.ten = ten;
        this.giaVe = giaVe;
    }
}


//2
//AC
//AC Milan
//12
//MU
//Manchester United
//10
//2
//IAC1 80000
//EMU2 60000