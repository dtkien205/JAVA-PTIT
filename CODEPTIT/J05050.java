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
public class J05050 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<TienDien> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new TienDien(sc.nextLine(),
                                Integer.parseInt(sc.nextLine()),
                                Integer.parseInt(sc.nextLine())));
        }
        
        for (TienDien x : ds)
            System.out.println(x);
    }
}

class TienDien {
    String ma, loai;
    int cu, moi;
    static int id = 1;
    
    TienDien(String loai, int cu, int moi){
        this.loai = loai;
        this.cu = cu;
        this.moi = moi;
        this.ma = String.format("KH%02d", id++);
    }
    
    public int heSo(){
        if(loai.equals("KD")) return 3;
        if(loai.equals("NN")) return 5;
        if(loai.equals("TT")) return 4;
        return 2;
    }
    
    public long thanhTien(){
        return (moi - cu) * heSo() * 550;
    }
    
    public long phuTroi() {
        int so = moi - cu;
        long tt = thanhTien();
        if(so > 100) return tt;
        if(so >= 50) return (long)Math.ceil(tt * 0.35);
        return 0;
    }
    
    public long tongTien() {
        return phuTroi() + thanhTien();
    }

    @Override
    public String toString() {
        return ma + " " + heSo() + " " + thanhTien() + " " + phuTroi() + " " + tongTien();
    }
    
    
}
