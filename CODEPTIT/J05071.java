package javacodeptit;

import java.text.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class J05071 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        Map<String, City> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            City x = new City(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            map.put(x.ma, x);
        }
        
        List<Call> ds = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String thueBao = sc.next();
            String st = sc.next();
            String ed = sc.next();
            
            if (thueBao.startsWith("0")) {
                String ma = thueBao.substring(1, 3);
                ds.add(new Call(thueBao, st, ed, map.get(ma)));
            } else {
                ds.add(new Call(thueBao, st, ed, new City("0", "Noi mang", 800)));
            }
            
        }
        
        for (Call x : ds) System.out.println(x);
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
    long time;
    City city;
    
    SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
    Call (String thueBao, String st, String ed, City x) throws ParseException {
        this.thueBao = thueBao;
        this.time = (fm.parse(ed).getTime() - fm.parse(st).getTime()) / (1000 * 60);
        this.city = x;
    }
    
    long soPhut() {
        if (!thueBao.startsWith("0")) return (long) Math.ceil(time / 3.0); 
        return time;
    }
    
    long thanhTien() {
        return soPhut() * city.gia;
    }

    @Override
    public String toString() {
        return thueBao + " " + city.ten + " " + soPhut() + " " + thanhTien();
    } 
}
