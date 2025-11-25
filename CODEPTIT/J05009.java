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
public class J05009 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        List<ThiSinh> ds = new ArrayList();
        
        for (int i = 0; i < n; i++){
            ds.add(new ThiSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        
        double res = 0;
        for (ThiSinh x : ds){
            res = Math.max(res, x.sum);
        }
        
        for (ThiSinh x : ds) {
            if(x.sum == res)
                System.out.println(x);
        }
    }
}

class ThiSinh {
    String hoten, ns;
    int ma;
    double sum;
    static int id = 1;
    
    ThiSinh(String hoten, String ns, double d1, double d2, double d3){
        this.hoten = hoten;
        this.ns = ns;
        this.sum = d1 + d2 + d3;
        this.ma = id++;
    }

    @Override
    public String toString() {
        return ma + " " + hoten + " " + ns + " " + sum;
    }  
}

//3
//Nguyen Van A
//12/12/1994
//3.5
//7.0
//5.5
//Nguyen Van B
//1/9/1994
//7.5
//9.5
//9.5
//Nguyen Van C
//6/7/1994
//8.5
//9.5
//8.5
