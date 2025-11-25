import java.io.*;
import java.util.*;

public class J07048 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        List<SanPham> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int gia = Integer.parseInt(sc.nextLine());
            int baoHanh = Integer.parseInt(sc.nextLine());
            
            ds.add(new SanPham(ma, ten, gia, baoHanh));
        }
        
        Collections.sort(ds);
        
        for (SanPham sp : ds) {
            System.out.println(sp);
        }
    }
}

class SanPham implements Comparable<SanPham>{
    private String ma;
    private String ten;
    private int gia;
    private int baoHanh;

    public SanPham(String ma, String ten, int gia, int baoHanh) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.baoHanh = baoHanh;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gia + " " + baoHanh;
    }

    @Override
    public int compareTo(SanPham o) {
        if (this.gia != o.gia) {
            return o.gia - this.gia;
        }
        return this.ma.compareTo(o.ma);
    }
}