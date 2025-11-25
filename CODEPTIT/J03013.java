import java.math.BigInteger;
import java.util.Scanner;

public class J03013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger x = new BigInteger(sc.next());
            BigInteger y = new BigInteger(sc.next());
            int cnt = Math.max(x.toString().length(), y.toString().length());
            String res = x.subtract(y).abs().toString();
            while (res.length() < cnt)
                res = "0" + res;
            System.out.println(res);
        }
    }
}
