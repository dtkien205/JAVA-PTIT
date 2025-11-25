package controller;

import model.SinhVien;
import model.manager.SinhVienManager;
import view.PanelSinhVien;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * SinhVienController - Controller cho quản lý sinh viên
 */
public class SinhVienController {
    private SinhVienManager sinhVienManager;
    private PanelSinhVien view;

    public SinhVienController(SinhVienManager sinhVienManager, PanelSinhVien view) {
        this.sinhVienManager = sinhVienManager;
        this.view = view;

        initController();
        hienThiDanhSach();
    }

    private void initController() {
        // Xử lý sự kiện nút Thêm
        view.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themSinhVien();
            }
        });

        // Xử lý sự kiện nút Làm mới
        view.getBtnLamMoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lamMoi();
            }
        });
    }

    private void themSinhVien() {
        try {
            // Lấy dữ liệu từ view
            String hoTen = view.getTxtHoTen().getText().trim();
            String diaChi = view.getTxtDiaChi().getText().trim();
            String soDT = view.getTxtSoDT().getText().trim();

            // Validate
            if (hoTen.isEmpty()) {
                throw new Exception("Họ tên không được rỗng");
            }

            if (diaChi.isEmpty()) {
                throw new Exception("Địa chỉ không được rỗng");
            }

            if (soDT.isEmpty()) {
                throw new Exception("Số điện thoại không được rỗng");
            }

            // Validate số điện thoại
            if (!soDT.matches("\\d{10,11}")) {
                throw new Exception("Số điện thoại phải có 10-11 chữ số");
            }

            // Tạo sinh viên mới
            SinhVien sinhVien = new SinhVien(hoTen, diaChi, soDT);
            sinhVienManager.add(sinhVien);

            // Thông báo thành công
            JOptionPane.showMessageDialog(view,
                    "Thêm sinh viên thành công!\nMSSV: " + String.format("%05d", sinhVien.getMaSV()),
                    "Thành công",
                    JOptionPane.INFORMATION_MESSAGE);

            // Làm mới và hiển thị danh sách
            lamMoi();
            hienThiDanhSach();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Lỗi: " + ex.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void lamMoi() {
        view.getTxtHoTen().setText("");
        view.getTxtDiaChi().setText("");
        view.getTxtSoDT().setText("");
        view.getTxtHoTen().requestFocus();
    }

    private void hienThiDanhSach() {
        List<SinhVien> danhSach = sinhVienManager.getAll();
        StringBuilder sb = new StringBuilder();

        sb.append("═".repeat(100)).append("\n");
        sb.append(String.format("%-40s DANH SÁCH SINH VIÊN %-40s\n", " ", " "));
        sb.append("═".repeat(100)).append("\n");
        sb.append(String.format("Tổng số sinh viên: %d\n", danhSach.size()));
        sb.append("═".repeat(100)).append("\n\n");

        if (danhSach.isEmpty()) {
            sb.append("Chưa có sinh viên nào được thêm vào.\n");
        } else {
            for (SinhVien sv : danhSach) {
                sb.append(sv.toString()).append("\n");
            }
        }

        view.getTxtDanhSach().setText(sb.toString());
        view.getTxtDanhSach().setCaretPosition(0);
    }

    public void refresh() {
        hienThiDanhSach();
    }
}
