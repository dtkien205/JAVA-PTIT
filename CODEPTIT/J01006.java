import java.util.Scanner;

public class J01006 {
    static long[] F = new long[100];

    public static void fibo() {
        F[1] = F[2] = 1;
        for (int i = 3; i <= 93; i++)
            F[i] = F[i - 1] + F[i - 2];
    }

    public static void main(String[] args) {
        fibo();
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            System.out.println(F[n]);
        }
    }
}
