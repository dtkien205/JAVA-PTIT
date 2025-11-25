package view;

import javax.swing.*;
import java.awt.*;

/**
 * MainFrame - Giao diện chính của ứng dụng
 */
public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private PanelMonHoc panelMonHoc;
    private PanelSinhVien panelSinhVien;
    private PanelDangKy panelDangKy;
    private PanelSapXep panelSapXep;
    private PanelLopHoc panelLopHoc;

    public MainFrame() {
        setTitle("QUẢN LÝ ĐĂNG KÝ HỌC THEO TÍN CHỈ");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();

        // Tạo các panel
        panelMonHoc = new PanelMonHoc();
        panelSinhVien = new PanelSinhVien();
        panelDangKy = new PanelDangKy();
        panelSapXep = new PanelSapXep();
        panelLopHoc = new PanelLopHoc();

        // Thêm các tab
        tabbedPane.addTab("Mon hoc", null, panelMonHoc, "Them va quan ly mon hoc");
        tabbedPane.addTab("Sinh vien", null, panelSinhVien, "Them va quan ly sinh vien");
        tabbedPane.addTab("Dang ky", null, panelDangKy, "Dang ky mon hoc cho sinh vien");
        tabbedPane.addTab("Sap xep", null, panelSapXep, "Sap xep danh sach dang ky");
        tabbedPane.addTab("Lop hoc", null, panelLopHoc, "Lap danh sach lop hoc");

        // Thiết lập font cho tab
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));

        add(tabbedPane);
    }

    public PanelMonHoc getPanelMonHoc() {
        return panelMonHoc;
    }

    public PanelSinhVien getPanelSinhVien() {
        return panelSinhVien;
    }

    public PanelDangKy getPanelDangKy() {
        return panelDangKy;
    }

    public PanelSapXep getPanelSapXep() {
        return panelSapXep;
    }

    public PanelLopHoc getPanelLopHoc() {
        return panelLopHoc;
    }
}
