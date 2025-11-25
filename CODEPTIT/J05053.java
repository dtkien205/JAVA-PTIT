import java.util.*;

public class J05053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Hang> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ds.add(new Hang(sc.nextLine(),
                    sc.nextLine(),
                    Long.parseLong(sc.nextLine()),
                    Long.parseLong(sc.nextLine())));
        }

        ds.sort((a, b) -> {
            return a.stt().compareTo(b.stt());
        });

        for (Hang x : ds) {
            System.out.println(x);
        }
    }
}

class Hang {
    String ma, ten;
    long donGia, sl;

    Hang(String ten, String ma, long donGia, long sl) {
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
        this.sl = sl;
    }

    public long giamGia() {
        if (ma.endsWith("1"))
            return Math.round(donGia * sl * 50.0 / 100);
        return Math.round(donGia * sl * 30.0 / 100);
    }

    public String stt() {
        return ma.substring(1, 4);
    }

    public long thanhTien() {
        return donGia * sl - giamGia();
    }

    @Override
    public String toString() {
        return ten + " " + ma + " " + stt() + " " + giamGia() + " " + thanhTien();
    }
}