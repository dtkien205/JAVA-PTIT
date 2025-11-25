import java.util.*;

public class J02007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            System.out.println("Test " + x + ":");
            int n = sc.nextInt();
            int[] a = new int[n];
            Map<Integer, Integer> map = new LinkedHashMap<>();

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            map.forEach((k, v) -> {
                System.out.println(k + " xuat hien " + v + " lan");
            });
        }
    }
}
