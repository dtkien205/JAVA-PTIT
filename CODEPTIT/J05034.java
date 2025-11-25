/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.util.*;

/**
 *
 * @author PC
 */
public class J05034 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        ds.sort((a, b) -> {
            return a.ten.compareTo(b.ten);
        });
        
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String dn = sc.nextLine();
            for (SinhVien x : ds){
                if(dn.equals(x.dn))
                    System.out.println(x);
            }
        }
    }
}

class SinhVien {
    int stt;
    String msv, ten, lop, email, dn;
    static int id = 1;
    
    SinhVien(String msv, String ten, String lop, String email, String dn){
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
        this.dn = dn;
        this.stt = id++;
    }

    @Override
    public String toString() {
        return stt + " " + msv + " " + ten + " " + lop + " " + email + " " + dn;
    } 
}

//6
//B17DCCN016 
//Le Khac Tuan Anh 
//D17HTTT2   
//test1@stu.ptit.edu.vn
//VIETTEL
//B17DCCN107 
//Dao Thanh Dat    
//D17CNPM5   
//test2@stu.ptit.edu.vn
//FPT
//B17DCAT092 
//Cao Danh Huy     
//D17CQAT04-B
//test3@stu.ptit.edu.vn
//FPT
//B17DCCN388 
//Cao Sy Hai Long  
//D17CNPM2   
//test4@stu.ptit.edu.vn
//VNPT
//B17DCCN461 
//Dinh Quang Nghia 
//D17CNPM2   
//test5@stu.ptit.edu.vn
//FPT
//B17DCCN554 
//Bui Xuan Thai    
//D17CNPM1   
//test6@stu.ptit.edu.vn
//GAMELOFT
//1
//FPT
