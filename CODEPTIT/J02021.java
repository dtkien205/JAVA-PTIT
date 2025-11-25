package javacodeptit;
import java.util.*;

public class J02021 {
    static int n, k, cnt = 0;
    static int[] a = new int[20];
    
    public static void Try(int i, int bd) {
        for (int j = bd; j <= n; j++) {
            a[i] = j;
            if (i == k) {
                cnt++;
                for (int u = 1; u <= k; u++) {
                    System.out.print(a[u]);
                }
                System.out.print(" ");
            } else {
                Try(i + 1, j + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        Try(1, 1);
        System.out.println();
        System.out.println("Tong cong co "+ cnt +" to hop");
    }
}
