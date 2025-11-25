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
public class J05019 {
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Tram> ds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String st = sc.nextLine();
            String ed = sc.nextLine();
            double luongMua = Double.parseDouble(sc.nextLine());
            
            boolean check = false;
            for (Tram x : ds){
                if(x.ten.equals(ten)){
                    check = true;
                    x.Update(luongMua, st, ed);
                    break;
                }
            }
            if(!check) {
                Tram moi = new Tram(ten);
                moi.Update(luongMua, st, ed);
                ds.add(moi);
            }
        }
        
        for (Tram t : ds) {
            System.out.println(t);
        }
    }
}

class Tram {
    String ma, ten;
    double tongLuongMua;
    int tongThoiGian;
    static int id = 1;
    
    Tram(String ten){
        this.ma = String.format("T%02d", id++);
        this.ten = ten;
        this.tongLuongMua = 0;
        this.tongThoiGian = 0;
    }
    
    public void Update(double luongMua, String st, String ed) throws ParseException{
        this.tongLuongMua += luongMua;
        this.tongThoiGian += tinhPhut(st, ed);
    }
    
    SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
    public long tinhPhut(String st, String ed) throws ParseException {
        Date start = fm.parse(st);
        Date end = fm.parse(ed);
        return  (end.getTime() - start.getTime()) / (1000 * 60);
    }
    
    public double trungBinh() {
        return tongLuongMua * 60 / tongThoiGian;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %.2f", ma, ten, trungBinh());
    }
}

//10
//Dong Anh
//07:30
//08:00
//60
//Cau Giay
//07:45
//08:12
//50
//Soc Son
//08:00
//09:15
//78
//Dong Anh
//18:50
//20:00
//88
//Cau Giay
//19:01
//20:00
//77
//Soc Son
//19:06
//20:21
//66
//Dong Anh
//21:00
//21:40
//49
//Cau Giay
//21:50
//22:20
//68
//Dong Anh
//22:15
//23:45
//30
//Cau Giay
//22:50
//23:45
//35