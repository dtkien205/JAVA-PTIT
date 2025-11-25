package javacodeptit;

import java.util.*;

public class J05018 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        List<HocSinh> ds = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            ds.add(new HocSinh(
                sc.nextLine(),
                sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(),
                sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(),
                sc.nextDouble(), sc.nextDouble()
            ));
            sc.nextLine(); 
        }
        
        ds.sort((a, b) -> {
            if(a.tb != b.tb) return Double.compare(b.tb, a.tb);
            return a.ma.compareTo(b.ma);
        });
        
        for (HocSinh x : ds)
            System.out.println(x);
    }
}

class HocSinh {
    String ma, ten;
    double d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, tb;
    static int id = 1;
    
    HocSinh(String ten, double d1, double d2, double d3, double d4, double d5, double d6, 
            double d7, double d8, double d9, double d10){
        this.ma = String.format("HS%02d", id++);
        this.ten = ten;
        this.tb = ((d1 + d2) * 2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10) / 12;
        this.tb = Math.round(this.tb * 10.0) / 10.0; 
    }
    
    public String Loai(){
        if(tb >= 9) return "XUAT SAC";
        if(tb >= 8) return "GIOI";
        if(tb >= 7) return "KHA";
        if(tb >= 5) return "TB";
        return "YEU";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.1f", tb) + " " + Loai();
    }   
}

//3
//Luu Thuy Nhi
//9.3  9.0  7.1  6.5  6.2  6.0  8.2  6.7  4.8  5.5
//Le Van Tam
//8.0  8.0  5.5  9.0  6.8  9.0  7.2  8.3  7.2  6.8
//Nguyen Thai Binh
//9.0  6.4  6.0  7.5  6.7  5.5  5.0  6.0  6.0  6.0