/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class Bai1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        
        BigInteger tong = BigInteger.ZERO;
        BigInteger tich = BigInteger.ONE;
        while(sc.hasNext()){
            String x = sc.next();
            BigInteger n = new BigInteger(x);
            
            tong = tong.add(n);
            tich = tich.multiply(n);
        }
        System.out.println(tong);
        System.out.println(tich);
    }
}
