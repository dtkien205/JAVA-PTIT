package javacodeptit;
import java.util.*;

public class HELLOJAR {
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}

class Subject {
    String ma, ten;
    int stc;

    Subject(String ma, String ten, int stc) {
        this.ma = ma;
        this.ten = ten;
        this.stc = stc;
    }
}

class Student {
    String msv, hoTen;
    List<Subject> monHoc = new ArrayList<>();

    Student(String msv, String hoTen) {
        this.msv = msv;
        this.hoTen = hoTen;
    }

    public void addSubject(Subject x) {
        monHoc.add(x);
    }

    public int tongTC() {
        int sum = 0;
        for (Subject x : monHoc) sum += x.stc;
        return sum;
    }
}

class Rule {
    String soQD, tenQD;
    double donGia;

    Rule(String soQD, String tenQD, double donGia) {
        this.soQD = soQD;
        this.tenQD = tenQD;
        this.donGia = donGia;
    }
}

class Invoice {
    private Student SV;
    private Rule QD;

    Invoice(Student SV, Rule QD) {
        this.SV = SV;
        this.QD = QD;
    }

    public double tinhHocPhi() {
        return SV.tongTC() * QD.donGia;
    }

    public Student getSV() {
        return SV;
    }
    public Rule getQD() {
        return QD;
    }
}

class PaymentController {
    public Invoice getInvoice() {
        Scanner sc = new Scanner(System.in);

        String msv = sc.nextLine();
        String hoTen = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());

        Student SV = new Student(msv, hoTen);
        for (int i = 0; i < n; i++) {
            String maMon = sc.nextLine();
            String tenMon = sc.nextLine();
            int tc = Integer.parseInt(sc.nextLine());
            SV.addSubject(new Subject(maMon, tenMon, tc));
        }

        String soQD = sc.nextLine();
        String tenQD = sc.nextLine();
        double donGia = Double.parseDouble(sc.nextLine());
        Rule QD = new Rule(soQD, tenQD, donGia);
        
        return new Invoice(SV, QD);
    }
}

class InvoiceView {
    public static void show(Invoice invoice) {
        Student SV = invoice.getSV();
        Rule QD = invoice.getQD();

        System.out.println("Mã sinh viên: " + SV.msv);
        System.out.println("Họ tên: " + SV.hoTen);
        System.out.println("Các môn học:");
        for (Subject x : SV.monHoc)
            System.out.println(x.ten);
        
        System.out.println("Học phí phải nộp là: " + invoice.tinhHocPhi());
        System.out.println("Theo QĐ: " + QD.soQD);
    }
}