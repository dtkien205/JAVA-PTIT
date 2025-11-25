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
public class J07040 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ob = new ObjectInputStream(new FileInputStream("NHIPHAN.in")); 
        ArrayList<String> ds1 = (ArrayList<String>) ob.readObject();
        
        Set<String> set = new HashSet<>();
        for (String line : ds1){
            String[] w = line.trim().toLowerCase().split("\\s+");
            for (String x : w){
                if(!x.isEmpty()){
                    set.add(x);
                }
            }
        }
        
        Scanner sc = new Scanner(new File("VANBAN.in"));
        Set<String> res = new LinkedHashSet<>();
        
        while (sc.hasNext()) {
            String w = sc.next().toLowerCase();
            if(set.contains(w)) {
                res.add(w);
            }
        }
        
        for (String w : res)
            System.out.println(w);
    }
}
