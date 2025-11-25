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
public class J05054 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<HocSinh> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new HocSinh(sc.nextLine(), Double.parseDouble(sc.nextLine())));
        }
        
        List<HocSinh> sorted =  new ArrayList<>(ds);
        sorted.sort((a, b) -> Double.compare(b.dtb, a.dtb));
        
        sorted.get(0).rank = 1;
        for (int i = 1; i < n; i++){
            if(sorted.get(i).dtb == sorted.get(i - 1).dtb){
                sorted.get(i).rank = sorted.get(i - 1).rank;
            } else {
                sorted.get(i).rank = i + 1;
            }
        }
        
        for (HocSinh hs : ds){
            for (HocSinh s : sorted){
                if(hs.ma.equals(s.ma)){
                    hs.rank = s.rank;
                    break;
                }
            }
        }
        
        for (HocSinh x : ds)
            System.out.println(x);
    }
}

class HocSinh{
    String ma, ten;
    double dtb;
    int rank;
    static int id = 1;
    
    HocSinh(String ten, double dtb){
        this.ma = String.format("HS%02d", id++);
        this.ten = ten;
        this.dtb = dtb;
    }
    
    public String xepLoai() {
        if(dtb >= 9) return "Gioi";
        if(dtb >= 7) return "Kha";
        if(dtb >= 5) return "Trung Binh";
        return "Yeu";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + dtb + " " + xepLoai() + " " + rank;
    }   
}
//3
//Tran Minh Hieu
//5.9
//Nguyen Bao Trung
//8.6
//Le Hong Ha
//9.2

