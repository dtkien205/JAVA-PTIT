import java.util.Scanner;

public class J01008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t;
        t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            System.out.print("Test " + k + ": ");
            int n;
            n = sc.nextInt();

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    int mu = 0;
                    while (n % i == 0) {
                        mu++;
                        n /= i;
                    }
                    System.out.print(i + "(" + mu + ") ");
                    if (n == 1)
                        System.out.print("\n");
                }
            }

            if (n > 1)
                System.out.println(n + "(1)");
        }
    }
}
