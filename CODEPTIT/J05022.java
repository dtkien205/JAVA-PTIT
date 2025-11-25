package javacodeptit;

import java.util.*;

public class J05022 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<SinhVien> ds = new ArrayList<>();

        for (int i = 0; i < n; i++){
            ds.add(new SinhVien(
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine()
            ));
        }

        int q = sc.nextInt();
        sc.nextLine();

        while(q-- > 0){
            String lop = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + lop + ":");
            for (SinhVien x : ds){
                if(x.lop.equals(lop))
                    System.out.println(x);
            }
        }
    }
}

class SinhVien {
    String msv, hoten, lop, email;

    SinhVien(String msv, String hoten, String lop, String email){
        this.msv = msv;
        this.hoten = hoten;
        this.lop = lop;
        this.email = email;
    }

    @Override
    public String toString() {
        return msv + " " + hoten + " " + lop + " " + email;
    }
}
