import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J03009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            Set<String> se = new TreeSet<>();
            String word[] = s1.split("\\s");
            for (String x : word)
                se.add(x);

            String w[] = s2.split("\\s");
            for (String x : w) {
                if (se.contains(x))
                    se.remove(x);
            }

            se.forEach(x -> System.out.print(x + " "));
            System.out.println();
        }
    }
}
