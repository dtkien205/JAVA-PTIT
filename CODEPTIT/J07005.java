package javacodeptit;

import java.io.*;
import java.util.*;

public class J07005 {
    public static void main(String[] args) throws Exception, FileNotFoundException{
        DataInputStream is = new DataInputStream(new FileInputStream("DATA.IN"));
        
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int i = 1; i <= 100000; i++){
            int x = is.readInt();
            if(mp.get(x) == null) mp.put(x, 1);
            else mp.put(x, mp.get(x) + 1);
        }
        
        mp.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }
}
