import java.util.Scanner;

public class J01007 {
    static long[] F = new long[100];

    public static void init() {
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= 93; i++)
            F[i] = F[i - 1] + F[i - 2];
    }

    public static boolean check(long n) {
        for (int i = 0; i <= 93; i++) {
            if (F[i] == n)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        init();
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            long n;
            n = sc.nextLong();
            System.out.println(check(n) ? "YES" : "NO");
        }
    }
}
