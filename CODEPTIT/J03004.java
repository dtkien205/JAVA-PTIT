import java.util.Scanner;

public class J03004 {
    public static String chuanHoa(String s) {
        String s1 = s.substring(0, 1).toUpperCase();
        String s2 = s.substring(1, s.length()).toLowerCase();
        return s1 + s2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            s = s.replaceAll("\\s+", " ").trim();
            String word[] = s.split("\\s");

            for (String x : word)
                System.out.print(chuanHoa(x) + " ");
            System.out.println();
        }
    }
}
