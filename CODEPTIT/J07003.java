/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class J07003 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        
        BigInteger n = sc.nextBigInteger();
        while(n.toString().length() > 1){
            int length = n.toString().length();
            BigInteger a = new BigInteger(n.toString().substring(0, length / 2));
            BigInteger b = new BigInteger(n.toString().substring(length / 2));
            n = a.add(b);
            System.out.println(n);
        }
    }
}
