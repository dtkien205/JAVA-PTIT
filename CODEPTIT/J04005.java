import java.util.Scanner;

public class J04005 {
    static class ThiSinh {
        String hoTen;
        String ngaySinh;
        double d1;
        double d2;
        double d3;

        public void output() {
            System.out.printf("%s %s %.1f", hoTen, ngaySinh, d1 + d2 + d3);
        }

        public void input(Scanner sc) {
            hoTen = sc.nextLine();
            ngaySinh = sc.next();
            d1 = sc.nextDouble();
            d2 = sc.nextDouble();
            d3 = sc.nextDouble();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThiSinh a = new ThiSinh();
        a.input(sc);
        a.output();
    }
}
