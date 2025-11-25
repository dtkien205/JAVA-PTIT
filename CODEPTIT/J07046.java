/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07046 {
    public static void main(String[] args) throws FileNotFoundException, ParseException{
        Scanner sc = new Scanner(new File("KHACH.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<Khach> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String hoTen = sc.nextLine();
            String maPhong = sc.nextLine();
            String ngayDen = sc.nextLine();
            String ngayDi = sc.nextLine();
            
            ds.add(new Khach(hoTen, maPhong, ngayDen, ngayDi));
        }
        
        ds.sort((a, b) -> {
            return Integer.compare(b.day, a.day);
        });
        
        for (Khach kh : ds) {
            System.out.println(kh);
        }
    }
}

class Khach {
    String ma, hoten, maPhong;
    int day;
    static int id = 1;
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
    
    Khach(String hoten, String maPhong, String in, String out) throws ParseException {
        this.ma = String.format("KH%02d", id++);
        this.hoten = chuanHoaTen(hoten);
        this.maPhong = maPhong;
        
        Date vao = fm.parse(in);
        Date ra = fm.parse(out);
        this.day = (int) ((ra.getTime() - vao.getTime()) / (24 * 3600 * 1000L));
    }
    
    public static String chuanHoaTen(String s){
        s = s.trim().toLowerCase();
        String[] ten = s.split("\\s+");
        String res = "";
        for (String x : ten){
            res += x.substring(0, 1).toUpperCase() + x.substring(1) + " ";
        }
        return res.trim();
    }    

    @Override
    public String toString() {
        return ma + " " + hoten + " " + maPhong + " " + day;
    }  
}
