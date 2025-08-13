import java.util.Scanner;

public class J01022 {

    static long[] len = new long[100];

    public static void init() {
        len[1] = 1;
        len[2] = 1;
        for (int i = 3; i <= 93; i++)
            len[i] = len[i - 1] + len[i - 2];
    }

    public static char res(int n, long k) {
        if (n == 1)
            return '0';
        if (n == 2)
            return '1';
        if (k <= len[n - 2])
            return res(n - 2, k);
        else
            return res(n - 1, k - len[n - 2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        init();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(res(n, k));
        }
    }
}
