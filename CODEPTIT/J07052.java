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
public class J07052 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("THISINH.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<ThiSinh> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new ThiSinh(sc.nextLine(), sc.nextLine(), 
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine())));
        }
        
        ds.sort((a, b) -> {
            if(a.tong != b.tong)
                return Double.compare(b.tong, a.tong);
            return a.ma.compareTo(b.ma);
        });
        
        int chiTieu = sc.nextInt();
        double diemChuan = ds.get(chiTieu - 1).tong;
        
        System.out.printf("%.1f\n", diemChuan);
        for (ThiSinh x : ds){
            System.out.println(x.ma + " " + x.hoten + " " + fm(x.uuTien()) + " " + fm(x.tong) + " " + x.trangThai(diemChuan));
        }   
    }
    
    public static String fm(double n) {
        if(n == (int)n) return String.format("%d", (int)n);
        else return String.format("%.1f", n);
    }
}

class ThiSinh {
    String ma, hoten, trangThai;
    double tong;
    
    ThiSinh(String ma, String hoten, double d1, double d2, double d3){
        this.ma = ma;
        this.hoten = chuanHoa(hoten);
        this.tong = d1 * 2 + d2 + d3 + uuTien();
    }
    
    public double uuTien() {
        if(ma.startsWith("KV1")) return 0.5;
        if(ma.startsWith("KV2")) return 1;
        return 2.5;
    }
    
    public String trangThai(double x) {
        if(tong >= x) return "TRUNG TUYEN";
        return "TRUOT";
    }
    
    public String chuanHoa(String s) {
        String[] t = s.trim().toLowerCase().split("\\s+");
        String res = "";
        for (String x : t){
            res += x.substring(0, 1).toUpperCase() + x.substring(1) + " ";
        }
        return res.trim();
    }
}

//2
//KV2A002
//Hoang THAnh tuan
//5
//6
//5
//KV3B123
// LY Thi   THU ha
//8
//6.5
//7
//1