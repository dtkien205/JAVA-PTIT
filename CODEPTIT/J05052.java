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
public class J05052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Hang> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Hang(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        
        for (Hang x : ds)
            System.out.println(x);
    }
}

class Hang {
    String ten, ma;
    int gia, sl;
    
    Hang(String ten, String ma, int gia, int sl){
        this.ten = ten;
        this.ma = ma;
        this.gia = gia;
        this.sl = sl;
    }
    
    public String stt(){
        return this.ma.substring(1, 4);
    }
    
    public long giamGia() {
        char c = ma.charAt(4);
        if (c == '1') return gia * sl / 2;
        return gia * sl * 30 / 100;
    }

    
    public long thanhTien() {
        return gia * sl - giamGia();
    }

    @Override
    public String toString() {
        return ten + " " + ma + " " + stt() + " " + giamGia() + " " + thanhTien();
    }   
}

//3
//Kaki 2
//K0252
//80000
//15
//Jean 1
//J2011
//200000
//24
//Jean 2
//J0982
//150000
//12
