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
public class J05072 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        Map<String, City> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            City x = new City(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            map.put(x.ma, x);
        }
        
        int m = Integer.parseInt(sc.nextLine());
        List<Call> ds = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            String thueBao = sc.next();
            String st = sc.next();
            String ed = sc.next();
            
            if (thueBao.startsWith("0")) {
                String ma = thueBao.substring(1, 3);
                ds.add(new Call(thueBao, st, ed, map.get(ma)));
            } else {
                ds.add(new  Call(thueBao, st, ed, new City("0", "Noi mang", 800)));
            }
        }
        
        ds.sort((a, b) -> {
            return Long.compare(b.thanhTien(), a.thanhTien());
        });
        
        for (Call x : ds) {
            System.out.println(x);
        }
    }
}

class City {
    String ma, ten;
    long gia;
    
    City (String ma, String ten, long gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }
}

class Call {
    String thueBao;
    City c;
    long time;
    
    SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
    
    Call(String thueBao, String st, String ed, City c) throws ParseException {
        this.thueBao = thueBao;
        this.time = (fm.parse(ed).getTime() - fm.parse(st).getTime()) / (1000 * 60);
        this.c = c;
    }
    
    long phut() {
        if (!thueBao.startsWith("0")) return (long) Math.ceil(time / 3.0);
        return time;
    }
    
    long thanhTien() {
        return phut() * c.gia;
    }

    @Override
    public String toString() {
        return thueBao + " " + c.ten + " " + phut() + " " + thanhTien();
    }
    
}
