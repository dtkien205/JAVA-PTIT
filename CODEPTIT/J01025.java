import java.util.Scanner;

public class J01025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1a = sc.nextInt(), y1a = sc.nextInt(), x2a = sc.nextInt(), y2a = sc.nextInt();
        int x1b = sc.nextInt(), y1b = sc.nextInt(), x2b = sc.nextInt(), y2b = sc.nextInt();

        int minX = Math.min(x1a, x1b);
        int maxX = Math.max(x2a, x2b);
        int minY = Math.min(y1a, y1b);
        int maxY = Math.max(y2a, y2b);

        int width = maxX - minX;
        int height = maxY - minY;

        int side = Math.max(width, height);
        long area = 1L * side * side;

        System.out.println(area);
    }
}
