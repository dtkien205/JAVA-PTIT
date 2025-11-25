import java.util.*;

public class J02026 {
    static int n, k;
    static int[] a;

    public static void Try(int i, int bd, String s) {
        if (i == k) {
            System.out.println(s.trim());
            return;
        }
        for (int j = bd; j < n; j++)
            Try(i + 1, j + 1, s + a[j] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);
            Try(0, 0, "");
        }
        sc.close();
    }
}
