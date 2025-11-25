package javacodeptit;

import java.util.*;

public class J05024 {
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
            String nganh = sc.nextLine();     
            System.out.println("DANH SACH SINH VIEN NGANH " + nganh.toUpperCase() + ":");
            
            String key = "";
            if(nganh.equals("Ke toan")) key = "KT";
            else if(nganh.equals("Cong nghe thong tin")) key = "CN";
            else if(nganh.equals("An toan thong tin")) key = "AT";
            else if(nganh.equals("Vien thong")) key = "VT";
            else if(nganh.equals("Dien tu")) key = "DT";
             
            for (SinhVien x : ds){
                if(x.msv.contains(key)) {
                    if((key.equals("CN") || key.equals("AT")) && x.lop.startsWith("E"))
                        continue;
                    System.out.println(x);
                }
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

