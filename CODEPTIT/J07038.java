import java.io.File;
import java.util.*;

public class J07038 {
    public static void main(String[] args) throws Exception{
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        
        int n = Integer.parseInt(sc1.nextLine());
        Map<String, SinhVien> sv = new HashMap<>();
        for (int i = 0; i < n; i++){
            SinhVien x = new SinhVien(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            sv.put(x.msv, x);
        }
        
        Scanner sc2 = new Scanner(new File("DN.in"));
        int m = Integer.parseInt(sc2.nextLine());
        Map<String, DoanhNghiep> dn = new HashMap<>();
        for (int i = 0; i < m; i++){
            DoanhNghiep x = new DoanhNghiep(sc2.nextLine(), sc2.nextLine(), Integer.parseInt(sc2.nextLine()));
            dn.put(x.maDN, x);
        }
        
        Scanner sc3 = new Scanner(new File("THUCTAP.in"));
        int dk = Integer.parseInt(sc3.nextLine());
        Map<String, List<String>> dangKy = new HashMap<>();
        for (int i = 0; i < dk; i++){
            String[] t = sc3.nextLine().split(" ", 2);
            String maSV = t[0];
            String maDN = t[1];
            dangKy.putIfAbsent(maDN, new ArrayList<>());
            dangKy.get(maDN).add(maSV);
        }
        
        int q = Integer.parseInt(sc3.nextLine());
        while(q-- > 0){
            String maDN = sc3.nextLine();
            DoanhNghiep x = dn.get(maDN);
            
            System.out.println("DANH SACH THUC TAP TAI " + x.tenDN + ":");
            
            List<String> list = dangKy.get(maDN);
            if (list == null) continue;
            
            list.sort((a, b) -> {
                return a.compareTo(b);
            });
            
            for (int i = 0; i < Math.min(list.size(), x.soSV); i++){
                System.out.println(sv.get(list.get(i)));
            }
        }
    }
}

class SinhVien {
    String msv, hoten, lop, email, dn;
    
    SinhVien(String msv,String hoten, String lop, String email){
        this.msv = msv;
        this.hoten = chuanHoaTen(hoten);
        this.lop = lop;
        this.email = email;
    }
    
    public static String chuanHoaTen(String s){
        String[] t = s.toLowerCase().trim().split("\\s+");
        String res = "";
        for (String x : t){
            res += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }
    
    @Override
    public String toString() {
        return msv + " " + hoten + " " + lop;
    }
}

class DoanhNghiep {
    String maDN, tenDN;
    int soSV;
    
    DoanhNghiep(String maDN, String tenDN, int soSV){
        this.maDN = maDN;
        this.tenDN = tenDN;
        this.soSV = soSV;
    }
}
