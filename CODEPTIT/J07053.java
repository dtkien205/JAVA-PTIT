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
public class J07053 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<Person> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Person(sc.nextLine(), sc.nextLine(),
                       Double.parseDouble(sc.nextLine()),
                       Double.parseDouble(sc.nextLine())));
        }
        
        for (Person x : ds)
            System.out.println(x);
    }
}

class Person {
    String ma, ten, ns;
    double lt, th;
    static int id = 1;
    
    
    Person (String ten, String  ns, double lt, double th){
        this.ma = String.format("PH%02d", id++);
        this.ten = chuanHoa(ten);
        this.ns = chuanHoaNgay(ns);
        this.lt = lt;
        this.th = th;
    }
    
    public long diem() {
        double tb = (lt + th) / 2.0 + diemThuong();
        if (tb > 10) tb = 10;
        return Math.round(tb);
    }

    public static String chuanHoaNgay(String s){
        String[] ns = s.split("/");
        if(ns[0].length() != 2) ns[0] = "0" + ns[0];
        if(ns[1].length() != 2) ns[1] = "0" + ns[1];
        return ns[0] + "/" + ns[1] + "/" + ns[2];
    }
    
    public double diemThuong() {
        if (lt >= 8 && th >= 8) return 1;
        if(lt >= 7.5 && th >= 7.5) return 0.5;
        return 0;
    }
    
    public String xepLoai() {
        if (diem() >= 9) return "Xuat sac";
        if (diem() == 8) return "Gioi";
        if (diem() == 7) return "Kha";
        if (diem() >= 5) return "Trung binh";
        return "Truot";
    }
    
    public int tuoi() {
        return 2021 - Integer.parseInt(ns.substring(6));
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
        return ma + " " + ten + " " + tuoi() + " " + diem() + " " + xepLoai();
    } 
}

//3
//Doan Thi Kim
//13/03/1982
//8
//9.5
//dinh Thi NGOC HA
//3/9/1996
//6.5
//8
//  tran thanh mai
//12/9/2004
//8