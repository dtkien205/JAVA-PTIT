/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07045 {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-- > 0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        
        Collections.sort(ds);
        
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}

class LoaiPhong implements Comparable<LoaiPhong>{
    String kyHieu, ten, donGia, phiPV;
    
    LoaiPhong(String line){
        String[] w = line.split("\\s+");
        this.kyHieu = w[0];
        this.ten = w[1];
        this.donGia = w[2];
        this.phiPV = w[3];
    }
    
    @Override
    public int compareTo(LoaiPhong x) {
        return this.ten.compareTo(x.ten);
    }

    @Override
    public String toString() {
        return kyHieu + " " + ten + " " + donGia + " " + phiPV;
    }  
}
