import java.util.*;

public class J01013 {
    static final int maxn = 2000000;
    static int[] spf = new int[maxn + 1];

    static void sieve() {
        for (int i = 2; i <= maxn; i++)
            spf[i] = i;
        for (int i = 2; i * i <= maxn; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxn; j += i)
                    if (spf[j] == j)
                        spf[j] = i;
            }
        }
    }

    public static void main(String[] args) {
        sieve();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        while (n-- > 0) {
            int x = sc.nextInt();
            while (x > 1) {
                sum += spf[x];
                x /= spf[x];
            }
        }
        System.out.println(sum);
    }
}