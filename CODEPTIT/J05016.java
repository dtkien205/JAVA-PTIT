import java.util.*;
import java.text.*;

class KhachHang {
    String ma, ten, soPhong;
    Date nhan, tra;
    long phatSinh, soNgay, thanhTien;

    static int id = 1;

    KhachHang(String ten, String soPhong, String ngayNhan, String ngayTra, long ps) throws Exception {
        this.ma = String.format("KH%02d", id++);
        this.ten = ten;
        this.soPhong = soPhong;
        this.phatSinh = ps;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.nhan = sdf.parse(ngayNhan);
        this.tra = sdf.parse(ngayTra);

        long diff = (tra.getTime() - nhan.getTime()) / (1000 * 60 * 60 * 24) + 1;
        this.soNgay = diff;

        int tang = soPhong.charAt(0) - '0';
        long donGia = 0;
        if (tang == 1) donGia = 25;
        else if (tang == 2) donGia = 34;
        else if (tang == 3) donGia = 50;
        else if (tang == 4) donGia = 80;

        this.thanhTien = soNgay * donGia + phatSinh;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soPhong + " " + soNgay + " " + thanhTien;
    }
}

public class J05016 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<KhachHang> ds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String soPhong = sc.nextLine();
            String ngayNhan = sc.nextLine();
            String ngayTra = sc.nextLine();
            long ps = Long.parseLong(sc.nextLine());

            ds.add(new KhachHang(ten, soPhong, ngayNhan, ngayTra, ps));
        }

        ds.sort((a, b) -> Long.compare(b.thanhTien, a.thanhTien));

        for (KhachHang x : ds) {
            System.out.println(x);
        }
    }
}
