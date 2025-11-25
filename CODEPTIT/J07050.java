import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MatHang implements Comparable<MatHang> {
    private String ma, ten, nhom;
    private double giaMua, giaBan, loiNhuan;

    public MatHang(int id, String ten, String nhom, double giaMua, double giaBan) {
        this.ma = String.format("MH%02d", id);
        this.ten = ten;
        this.nhom = nhom;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.loiNhuan = giaBan - giaMua;
    }

    @Override
    public int compareTo(MatHang o) {
        if (this.loiNhuan < o.loiNhuan) return 1;
        if (this.loiNhuan > o.loiNhuan) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + nhom + " " + String.format("%.2f", loiNhuan);
    }
}

public class J07050 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("MATHANG.in");
        Scanner sc = new Scanner(file);

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MatHang> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            double giaMua = Double.parseDouble(sc.nextLine());
            double giaBan = Double.parseDouble(sc.nextLine());
            list.add(new MatHang(i + 1, ten, nhom, giaMua, giaBan));
        }

        Collections.sort(list);

        for (MatHang mh : list) {
            System.out.println(mh);
        }
    }
}