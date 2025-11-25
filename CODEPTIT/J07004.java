package javacodeptit;
import java.io.File;
import java.util.*;

public class J07004 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("DATA.in"));
        
        Map<Integer, Integer> mp = new TreeMap<>();
        while(sc.hasNext()){
            int x = Integer.parseInt(sc.next());
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        
        for (Integer x : mp.keySet()){
            System.out.println(x + " " + mp.get(x));
        }
    }
}
