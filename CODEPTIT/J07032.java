package javacodeptit;

import java.io.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class J07032 {
    public static boolean check(int n){
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++){
            if ((s.charAt(i) - '0') % 2 == 0) return false;
        }
        
        if(s.length() % 2 == 0 || s.length() == 1) return false;
        
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ob1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ob2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        ArrayList<Integer> ds1 = (ArrayList<Integer>) ob1.readObject();
        ArrayList<Integer> ds2 = (ArrayList<Integer>) ob2.readObject();
        
        int MAX = 1000000;
        int[] cnt = new int[MAX + 1];
        boolean[] in1 = new boolean[MAX + 1];
        boolean[] in2 = new boolean[MAX + 1];
        
        for (Integer x : ds1){
            cnt[x]++;
            in1[x] = true;
        }
        
        for (Integer x : ds2){
            cnt[x]++;
            in2[x] = true;
        }
        
        int dem = 0;
        for (int i = 1; i <= MAX && dem < 10; i++) {
            if (in1[i] && in2[i] && check(i)){
                System.out.println(i + " " + cnt[i]);
                dem++;
            }
        }
    }
}
