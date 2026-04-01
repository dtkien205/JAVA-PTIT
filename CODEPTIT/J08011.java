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
public class J08011 {
    public static boolean check(String s) {
        if (s.length() < 2) return true;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, num> mp = new HashMap<>();
        List<num> ds = new ArrayList<>();
        int i = 0;
        while(sc.hasNext()) {
            String s = sc.next();
            if(check(s)) {
                if (mp.get(s) == null) {
                    num x = new num(s, 1, ++i);
                    mp.put(s, x);
                    ds.add(x);
                } else mp.get(s).cnt += 1;
            }
        }
        
        ds.sort((a, b) -> {
            if (a.cnt != b.cnt) return b.cnt - a.cnt;
            return a.stt - b.stt;
        });
        for (num x : ds) System.out.println(x);
    }
}

class num {
    String num;
    int cnt, stt;
    
    public num(String num, int cnt, int stt) {
        this.num = num;
        this.cnt = cnt;
        this.stt = stt;
    }
    
    @Override 
    public String toString() {
        return num + " " + cnt;
    }
}


