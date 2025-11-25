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
public class J05070 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<CLB> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new CLB(sc.nextLine(), sc.nextLine(),
                       Integer.parseInt(sc.nextLine())));
        }
        
        List<TranDau> ds1 = new ArrayList<>();
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String tmp = sc.next();
            long sl = Integer.parseInt(sc.next());
            sc.nextLine();
            
            String maCLB = tmp.substring(1, 3);
            for (CLB x : ds){
                if(x.ma.equals(maCLB)){
                    ds1.add(new TranDau(tmp, x.ten, x.giaVe * sl));
                    break;
                }
            }
        }
                    ds1.sort((a, b) -> {
                if(a.doanhThu != b.doanhThu) return Long.compare(b.doanhThu, a.doanhThu);
                return a.ma.compareTo(b.ma);
            });
            
            for (TranDau x : ds1)
                System.out.println(x);
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

class TranDau {
    String ma, ten;
    long doanhThu;
    
    TranDau(String ma, String ten, long doanhThu) {
        this.ma = ma;
        this.ten = ten;
        this.doanhThu = doanhThu;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + doanhThu;
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