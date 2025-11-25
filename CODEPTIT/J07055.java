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
public class J07055 {
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
            return Double.compare(b.dtb, a.dtb);
        });
        
        for (SV x : ds)
            System.out.println(x);
    }
}

class SV {
    String ma, ten;
    double dtb;
    static int id = 1;
    
    SV (String ten, double d1, double d2, double d3) {
        this.ma = String.format("SV%02d", id++);
        this.ten = chuanHoa(ten);
        this.dtb = (d1 * 0.25 + d2 * 0.35 + d3 * 0.4);
    }

    public String chuanHoa(String s) {
        String[] t = s.trim().toLowerCase().split("\\s+");
        String res = "";
        for (String x : t){
            res += x.substring(0, 1).toUpperCase() + x.substring(1) + " ";
        }
        return res.trim();
    }
    
    public String xepLoai() {
        if (dtb >= 8) return "GIOI";
        if (dtb >= 6.5) return "KHA";
        if(dtb >= 5) return "TRUNG BINH";
        return "KEM";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.2f", dtb) + " " + xepLoai();
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

