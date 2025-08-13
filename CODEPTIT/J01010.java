import java.util.Scanner;

public class J01010 {

    public static char convert(char c) {
        if (c == '8' || c == '9' || c == '0')
            return '0';
        else if (c == '1')
            return '1';
        else
            return '2';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String n = sc.next();
            String res = "";
            boolean ok = true;

            for (char c : n.toCharArray()) {
                if (c == '0' || c == '8' || c == '9')
                    res += "0";
                else if (c == '1')
                    res += "1";
                else {
                    ok = false;
                    break;
                }
            }
            res = res.replaceFirst("^0+", "");
            if (!ok || res.isEmpty()) {
                System.out.println("INVALID");
            } else
                System.out.println(res);
        }
    }
}
