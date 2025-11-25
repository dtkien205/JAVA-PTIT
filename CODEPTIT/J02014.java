package javacodeptit;
import java.util.*;

public class J02014 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] a = new long[n + 1];
            long[] prefix = new long[n + 1];
            
            for (int i = 1; i <= n; i++){
                a[i] = sc.nextLong();
                prefix[i] = prefix[i-1] + a[i];
            }
            
            int cnt = -1;
            for (int i = 1; i <= n - 1; i++){
                if(prefix[i - 1] == prefix[n] - prefix[i]){
                    cnt = i;
                    break;
                }
            }
            
            System.out.println(cnt);
        }
    }
}
