import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J02006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        Set<Integer> A = new HashSet<>();
        for (int x : a)
            A.add(x);
        for (int x : b)
            A.add(x);

        ArrayList<Integer> res = new ArrayList<>(A);
        Collections.sort(res);

        for (int x : res)
            System.out.print(x + " ");
    }
}
