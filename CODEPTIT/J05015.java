package javacodeptit;

import java.util.*;

public class J05015 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<Person> ds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String ten = sc.nextLine().trim();
            String donVi = sc.nextLine().trim();
            String time = sc.nextLine().trim();
            ds.add(new Person(ten, donVi, time));
        }

        ds.sort((a, b) -> {
            if (a.getTime() != b.getTime())
                return Long.compare(a.getTime(), b.getTime());   
            return a.ma.compareTo(b.ma);
        });
        
        for (Person x : ds)
            System.out.println(x);
    }
}

class Person {
    String ma, ten, donVi;
    long v, time;      
    
    Person(String ten, String donVi, String timeFinish){
        this.ten = ten;
        this.donVi = donVi;
        
        StringBuilder sb = new StringBuilder();
        String[] t = donVi.trim().split("\\s+");
        for (String x : t){
            if (!x.isEmpty())
                sb.append(Character.toUpperCase(x.charAt(0)));
        }
        String[] t1 = ten.trim().split("\\s+");
        for (String x : t1){
            if (!x.isEmpty())
                sb.append(Character.toUpperCase(x.charAt(0)));
        }
        this.ma = sb.toString();
        
        String[] tt = timeFinish.split(":");
        int hour = Integer.parseInt(tt[0]);
        int minute = Integer.parseInt(tt[1]);
        
        this.time = (hour - 6) * 60L + minute;
        
        double hours = this.time / 60.0;
        this.v = Math.round(120.0 / hours);
    }
    
    public long getTime() {   
        return time;
    }
    
    public long getSpeed() {   
        return v;
    }

    public String vTB() {      
        return String.format("%d Km/h", v);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + vTB();
    } 
}