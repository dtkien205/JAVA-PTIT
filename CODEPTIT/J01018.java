import java.util.Scanner;

public class J01018 {

    public static boolean check(String s) {
        int sum = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != 2)
                return false;
        }
        return sum % 10 == 0;
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
