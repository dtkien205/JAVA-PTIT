package javacodeptit;
import java.io.*;
import java.util.*;

public class J07007 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("VANBAN.in"));
        
        Set<String> st = new TreeSet<>();
        
        while(sc.hasNext()){
            String tmp = sc.next().toLowerCase();
            st.add(tmp);
        }
        
        st.forEach(x -> {
            System.out.println(x);
        });
    }
}
