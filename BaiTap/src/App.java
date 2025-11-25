import controller.*;
import model.manager.*;
import view.MainFrame;

import javax.swing.*;

/**
 * App - Điểm khởi đầu của ứng dụng
 * Quản lý Đăng ký Học theo Tín chỉ
 */
public class App {
    public static void main(String[] args) {
        // Sử dụng look and feel của hệ thống
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Chạy ứng dụng trên Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Khởi tạo các Manager
                MonHocManager monHocManager = new MonHocManager();
                SinhVienManager sinhVienManager = new SinhVienManager();
                DangKyManager dangKyManager = new DangKyManager(sinhVienManager, monHocManager);
                LopHocManager lopHocManager = new LopHocManager(dangKyManager, monHocManager);

                // Tạo giao diện chính
                MainFrame mainFrame = new MainFrame();

                // Khởi tạo các Controller
                MonHocController monHocController = new MonHocController(
                        monHocManager, mainFrame.getPanelMonHoc());

                SinhVienController sinhVienController = new SinhVienController(
                        sinhVienManager, mainFrame.getPanelSinhVien());

                DangKyController dangKyController = new DangKyController(
                        dangKyManager, mainFrame.getPanelDangKy());

                SapXepController sapXepController = new SapXepController(
                        dangKyManager, mainFrame.getPanelSapXep());

                LopHocController lopHocController = new LopHocController(
                        lopHocManager, monHocManager, sinhVienManager, mainFrame.getPanelLopHoc());

                // Hiển thị giao diện
                mainFrame.setVisible(true);

                System.out.println("╔════════════════════════════════════════════════════════════╗");
                System.out.println("║   QUẢN LÝ ĐĂNG KÝ HỌC THEO TÍN CHỈ                         ║");
                System.out.println("║   Ứng dụng đã khởi động thành công!                        ║");
                System.out.println("╚════════════════════════════════════════════════════════════╝");
            }
        });
    }
}
