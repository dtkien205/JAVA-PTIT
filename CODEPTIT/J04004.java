import java.util.Scanner;

public class J04004 {
    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a + b;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t1 = sc.nextLong();
        long p1 = sc.nextLong();
        long t2 = sc.nextLong();
        long p2 = sc.nextLong();
        long m1 = gcd(t1, p1), m2 = gcd(t2, p2);
        t1 /= m1;
        p1 /= m1;
        t2 /= m2;
        p2 /= m2;
        long m = lcm(p1, p2);
        long t = t1 * (m / p1) + t2 * (m / p2);
        long u = gcd(t, m);
        t /= u;
        m /= u;
        System.out.printf("%d/%d", t, m);
    }
}
