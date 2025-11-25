import java.util.Scanner;

public class J03008 {
    public static boolean prime(char n) {
        return n == '2' || n == '3' || n == '5' || n == '7';
    }

    public static boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            if (!prime(s.charAt(l)) || !prime(s.charAt(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(check(s) ? "YES" : "NO");
        }
    }
}
