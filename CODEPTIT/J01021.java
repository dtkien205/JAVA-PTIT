import java.util.Scanner;

public class J01021 {

    static int mod = (int) 1e9 + 7;

    public static long MOD(long a, long b) {
        if (b == 0)
            return 1;
        long tmp = MOD(a, b / 2);
        if (b % 2 == 0)
            return tmp * tmp % mod;
        return ((tmp * tmp) % mod) * a % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a, b;
        while (true) {
            a = sc.nextLong();
            b = sc.nextLong();
            if (a == 0 && b == 0)
                break;
            System.out.println(MOD(a, b));
        }
    }
}
