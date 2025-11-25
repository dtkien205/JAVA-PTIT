import java.io.File;
import java.util.*;

public class J07021 {

    public static String chuanHoaTen(String ten) {
        ten = ten.trim().toLowerCase();
        String[] arr = ten.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String x : arr) {
            sb.append(Character.toUpperCase(x.charAt(0)));
            sb.append(x.substring(1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DATA.in"));

        while (true) {
            String ten = sc.nextLine();
            if (ten.equals("END"))
                break;
            System.out.println(chuanHoaTen(ten));
        }
    }
}
