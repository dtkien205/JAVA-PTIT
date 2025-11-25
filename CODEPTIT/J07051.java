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
public class J07051 {
    public static void main(String[] args) throws ParseException, FileNotFoundException{
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<Khach> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new Khach(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(),
                        Long.parseLong(sc.nextLine())));
        }
        ds.sort((a, b) -> {
            return Long.compare(b.thanhTien(), a.thanhTien());
        });
        for (Khach x : ds){
            System.out.println(x);
        }
    }
}

class Khach {
    String ma, ten, soPhong;
    long phatSinh, soNgay;
    static int id = 1;
    
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
    
    Khach (String ten, String soPhong, String in, String out, long phatSinh) throws ParseException {
        this.ma = String.format("KH%02d", id++);
        this.ten = chuanHoa(ten);
        this.soPhong = soPhong;
        this.phatSinh = phatSinh;
        
        Date vao = fm.parse(in);
        Date ra = fm.parse(out);
        this.soNgay = (ra.getTime() - vao.getTime()) / (1000 * 24 * 3600) + 1;
    }
    
    public long thanhTien() {
        long donGia = 0;
        if(soPhong.startsWith("1")) donGia = 25;
        if(soPhong.startsWith("2")) donGia = 34;
        if(soPhong.startsWith("3")) donGia = 50;
        if(soPhong.startsWith("4")) donGia = 80;
        return soNgay * donGia + phatSinh;
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
        return ma + " " + ten + " " + soPhong + " " + soNgay + " " + thanhTien();
    } 
}

//3
//Huynh VAN Thanh   
//103 
//5/6/2010   
//5/6/2010   
//15
//le   DUC cong  
//106 
//08/3/2010   
//1/5/2010   
//220
//Tran Thi Bich Tuyen   
//207 
//10/4/2010   
//21/4/2010   
//96
