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
public class J05042 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<SV> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ds.add(new SV(sc.nextLine(), Integer.parseInt(sc.next()), Integer.parseInt(sc.next())));
            sc.nextLine();
        }
        
        ds.sort((a, b) -> {
            if(a.soBai != b.soBai) return Integer.compare(b.soBai, a.soBai);
            if(a.submit != b.submit) return Integer.compare(a.submit, b.submit);
            return a.ten.compareTo(b.ten);
        });
        
        for (SV x : ds)
            System.out.println(x);
    }
}

class SV {
    String ten;
    int soBai, submit;
    
    SV(String ten, int soBai, int submit){
        this.ten = ten;
        this.soBai = soBai;
        this.submit = submit;
    }

    @Override
    public String toString() {
        return ten + " " + soBai + " " + submit;
    }
    
    
}
