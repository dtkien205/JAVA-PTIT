/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author PC
 */
public class Bai4 {
    public static Map<String, TheLoai> mapTheLoai = new HashMap<>();
    
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        
        String[] firstLine = sc.nextLine().trim().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        
        for (int i = 1; i <= n; i++) {
            String tenTL = sc.nextLine();
            TheLoai tl = new TheLoai(tenTL);
            mapTheLoai.put(tl.ma, tl);
        }
        
        ArrayList<Phim> ds = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String maTL = sc.nextLine();
            String ngay = sc.nextLine();
            String tenPhim = sc.nextLine();
            int soTap = Integer.parseInt(sc.nextLine());

            Phim p = new Phim(maTL, ngay, tenPhim, soTap);
            ds.add(p);
        }
        
        ds.sort((a, b) -> {
            if (!a.time.equals(b.time))
                return a.time.compareTo(b.time);
            if (!a.ten.equals(b.ten))
                return a.ten.compareTo(b.ten);
            return b.soTap - a.soTap;
        });
        
        for (Phim p : ds) {
            System.out.println(p);
        }
    }
}

class TheLoai {
    String ten, ma;
    static int id = 1;
    TheLoai(String ten) {
        this.ten = ten;
        this.ma = String.format("TL%03d", id++);
    }
}

class Phim {
    String ma, ngay, ten;
    int soTap;
    static int id = 1;
    Long time;
    TheLoai theLoai;
    
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    
    Phim(String maTL, String ngay, String ten, int soTap) throws ParseException {
        this.ma = String.format("P%03d", id++);
        this.ngay = ngay;
        this.ten = ten;
        this.soTap = soTap;
        this.time = f.parse(ngay).getTime() / (1000 * 60 * 60);
        
        this.theLoai = Bai4.mapTheLoai.get(maTL);
    }

    @Override
    public String toString() {
        return ma + " " + theLoai.ten + " " + ngay + " " + ten + " " + soTap;
    }   
}
