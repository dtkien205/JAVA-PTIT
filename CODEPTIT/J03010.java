import java.util.*;

public class J03010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> mp = new HashMap<>();

        while (t-- > 0) {
            String s = sc.nextLine().toLowerCase(), res = "";
            String w[] = s.trim().replaceAll("\\s+", " ").split(" ");
            res += w[w.length - 1];
            for (int i = 0; i < w.length - 1; i++)
                res += w[i].charAt(0);

            if (mp.containsKey(res)) {
                mp.put(res, mp.get(res) + 1);
                res += mp.get(res);
            } else
                mp.put(res, 1);
                
            res += "@ptit.edu.vn";
            System.out.println(res);
        }
    }
}
