/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07054 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<SV> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new SV(sc.nextLine(),
                       Double.parseDouble(sc.nextLine()),
                       Double.parseDouble(sc.nextLine()),
                       Double.parseDouble(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            if(a.dtb != b.dtb) return Double.compare(b.dtb, a.dtb);
            return a.ma.compareTo(b.ma);
        });
        
        ds.get(0).rank = 1;
        for (int i = 1; i < n; i++){
            if(ds.get(i).dtb == ds.get(i - 1).dtb)
                ds.get(i).rank = ds.get(i - 1).rank;
            else ds.get(i).rank = i + 1;
        }
        
        for (SV x : ds)
            System.out.println(x);
    }
}

class SV {
    String ma, ten;
    double dtb;
    int rank;
    static int id = 1;
    
    SV (String ten, double d1, double d2, double d3) {
        this.ma = String.format("SV%02d", id++);
        this.ten = chuanHoa(ten);
        this.dtb = (d1 * 3 + d2 * 3 + d3 * 2) / 8;
    }

    public String chuanHoa(String s) {
        String[] t = s.trim().toLowerCase().split("\\s+");
        String res = "";
        for (String x : t){
            res += x.substring(0, 1).toUpperCase() + x.substring(1) + " ";
        }
        return res.trim();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.2f", dtb) + " " + rank;
    }  
}

//2
// ha Thi kieu     anh
//7
//6
//7
//Pham    THI  HAO
//6
//7
//6
