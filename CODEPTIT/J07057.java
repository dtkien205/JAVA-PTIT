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
public class J07057 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("THISINH.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<TS> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new TS(sc.nextLine(),
                       Double.parseDouble(sc.nextLine()),
                       sc.nextLine(),
                       Integer.parseInt(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            if(a.tong != b.tong)
                return Double.compare(b.tong, a.tong);
            return a.ma.compareTo(b.ma);
        });
        
        for (TS x : ds)
            System.out.println(x);
    }
}

class TS {
    String ma, ten, dantoc;
    int kv;
    double tong;
    static int id = 1;
    
    TS (String ten, double diem, String dantoc, int kv) {
        this.ma = String.format("TS%02d", id++);
        this.ten = chuanHoa(ten);
        this.dantoc = dantoc;
        this.kv = kv;
        this.tong = diem + DT() + uuTien();
    }
    
    double uuTien() {
        if (kv == 1) return 1.5;
        if (kv == 2) return 1;
        return 0;
    }
    
    double DT() {
        if (dantoc.equals("Kinh")) return 0;
        return 1.5;
    }
    
    public String chuanHoa(String s) {
        String[] t = s.trim().toLowerCase().split("\\s+");
        String res = "";
        for (String x : t){
            res += x.substring(0, 1).toUpperCase() + x.substring(1) + " ";
        }
        return res.trim();
    }
    
    String trangThai() {
        if(tong >= 20.5) return "Do";
        return "Truot";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.1f", tong) + " " + trangThai();
    } 
}
