import java.util.*;

public class J02005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        Set<Integer> setA = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int x : a)
            setA.add(x);
        for (int x : b) {
            if (setA.contains(x) && !res.contains(x))
                res.add(x);
        }
        Collections.sort(res);
        for (int x : res)
            System.out.print(x + " ");
    }
}
