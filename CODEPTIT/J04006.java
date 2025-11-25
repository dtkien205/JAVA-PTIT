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
public class J04006 {
    static class SinhVien{
        String msv, hoTen, lop, ngaySinh;
        double gpa;
        
        public void out(){
            System.out.printf("%s %s %s %s %.2f\n", msv, hoTen, lop, ngaySinh, gpa);
        }
        
        public void in(Scanner sc){
            msv = "B20DCCN001";
            hoTen = sc.nextLine();
            lop = sc.next();
            String[] tmp = sc.next().split("/");
            if(tmp[0].length() == 1) tmp[0] = "0" + tmp[0];
            if(tmp[1].length() == 1) tmp[1] = "0" + tmp[1];
            ngaySinh = tmp[0] + "/" + tmp[1] + "/" + tmp[2];
            gpa = sc.nextDouble();
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SinhVien x = new SinhVien();
        x.in(sc);
        x.out();
    }
}
