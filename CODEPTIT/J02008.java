package javacodeptit;

import java.util.*;

public class J02008 {
    
    public static long gcd(long a, long b){
        while(b != 0){
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a + b;
    }
    
    public static long lcm(long a, long b){
        return a / gcd(a, b) * b;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            long n = sc.nextLong();
            long res = 1;
            for (int i = 1; i <= n; i++)
                res = lcm(res, i);
            
            System.out.println(res);
        }
    }
}
