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
public class J05032 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Person> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new Person(sc.next(), sc.next()));
            sc.nextLine();
        }
        
        ds.sort((a, b) -> { 
            if(a.y != b.y) return a.y - b.y;
            if(a.m != b.m) return a.m - b.m;
            return a.d - b.d;
        });
        
        System.out.println(ds.get(n - 1));
        System.out.println(ds.get(0));
    }
}

class Person {
    String ten, ns;
    int y, m, d;
    
    Person(String ten, String ns){
        this.ten = ten;
        this.ns = ns;
        String[] t = this.ns.split("/");
        this.d = Integer.parseInt(t[0]);
        this.m = Integer.parseInt(t[1]);
        this.y = Integer.parseInt(t[2]);
    }

    @Override
    public String toString() {
        return this.ten;
    }
}


//5
//Nam 01/10/1991
//An 30/12/1990
//Binh 15/08/1993
//Tam 18/09/1990
//Truong 20/09/1990