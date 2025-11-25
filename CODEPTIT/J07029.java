/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.io.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07029 {    
    public static void main(String[]args) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> ds = (ArrayList<Integer>) sc.readObject();
        
        int MAX = 1000000;
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++){
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i){
                    isPrime[j] = false;
                }
            }
        }
        
        int[] cnt = new int[MAX + 1];
        for (Integer x : ds){
            if (isPrime[x]) {
                cnt[x]++;
            }
        }
        
//        System.out.println("Ghi 10 số nguyên tố lớn nhất và số lần");
//        System.out.println("Ví dụ:");
        
        int dem = 0;
        for (int i = MAX; i >= 2; i--){
            if(cnt[i] > 0) {
                System.out.println(i + " " + cnt[i]);
                dem++;
                if(dem == 10) break;
            }
        }
    }
}
