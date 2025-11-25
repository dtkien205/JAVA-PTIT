/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;
import java.util.*;
import java.io.*;

/**
 *
 * @author PC
 */
public class J07058 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("MONHOC.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        Subject[] a = new Subject[n];
        for (int i = 0; i < n; i++){
            a[i] = new Subject(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        
//        for (int i = 0; i < n - 1; i++){
//            for (int j = i + 1; j < n; j++){
//                if(a[i].cmp(a[j])){
//                    Subject tmp = a[i];
//                    a[i] = a[j];
//                    a[j] = tmp;
//                }
//            }
//        }
        Arrays.sort(a, (s1, s2) -> s1.maMon.compareTo(s2.maMon));
        
        for(int i = 0; i < n; i++) System.out.println(a[i]); 
    }
}

class Subject {
    String maMon;
    String tenMon;
    String hinhThuc;
    
    Subject(String maMon, String tenMon, String hinhThuc){
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThuc = hinhThuc;
    }
    
//    public boolean cmp(Subject x){
//        if(this.maMon.compareTo(x.maMon) > 0) return true;
//        return false;
//    }
    
    @Override
    public String toString() {
        return maMon + " " + tenMon + " " + hinhThuc;
    }
}
