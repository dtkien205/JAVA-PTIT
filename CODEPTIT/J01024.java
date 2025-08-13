import java.util.Scanner;

public class J01024 {

    public static boolean check(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            System.out.println(check(String.valueOf(n)) ? "YES" : "NO");
        }
    }
}
