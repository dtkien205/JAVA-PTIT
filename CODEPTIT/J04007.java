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
public class J04007 {
    static class NhanVien {
        String mnv, hoTen, gioiTinh, ngaySinh, diaChi, mst, nkhd;
        
        public static String convert(String s){
            String[] tmp = s.split("/");
            if(tmp[0].length() == 1) tmp[0] = "0" + tmp[0];
            if(tmp[1].length() == 1) tmp[1] = "0" + tmp[1];
            return tmp[0] + "/" + tmp[1] + "/" + tmp[2];
        }
        
        public void in(Scanner sc){
            mnv = "00001";
            hoTen = sc.nextLine();
            gioiTinh = sc.nextLine();
            ngaySinh = sc.nextLine();
            diaChi = sc.nextLine();
            mst = sc.nextLine();
            nkhd = sc.nextLine();
        }
        
        public void out(){
            System.out.printf("%s %s %s %s %s %s %s\n", mnv, hoTen, gioiTinh, convert(ngaySinh), diaChi, mst, convert(nkhd));
        }
    }
    
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        NhanVien x = new NhanVien();
        x.in(sc);
        x.out();
    }
}
