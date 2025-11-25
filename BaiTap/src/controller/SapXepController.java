package controller;

import model.DangKy;
import model.manager.DangKyManager;
import view.PanelSapXep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * SapXepController - Controller cho sắp xếp danh sách đăng ký
 */
public class SapXepController {
    private DangKyManager dangKyManager;
    private PanelSapXep view;

    public SapXepController(DangKyManager dangKyManager, PanelSapXep view) {
        this.dangKyManager = dangKyManager;
        this.view = view;

        initController();
    }

    private void initController() {
        // Xử lý sự kiện nút Sắp xếp theo tên
        view.getBtnSapXepTheoTen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sapXepTheoTen();
            }
        });

        // Xử lý sự kiện nút Sắp xếp theo thời gian
        view.getBtnSapXepTheoThoiGian().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sapXepTheoThoiGian();
            }
        });
    }

    private void sapXepTheoTen() {
        try {
            List<DangKy> danhSachSapXep = dangKyManager.sapXepTheoTenSV();
            hienThiDanhSach(danhSachSapXep, "SẮP XẾP THEO TÊN SINH VIÊN");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Lỗi: " + ex.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sapXepTheoThoiGian() {
        try {
            List<DangKy> danhSachSapXep = dangKyManager.sapXepTheoThoiGian();
            hienThiDanhSach(danhSachSapXep, "SẮP XẾP THEO THỜI GIAN ĐĂNG KÝ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Lỗi: " + ex.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hienThiDanhSach(List<DangKy> danhSach, String tieuDe) {
        StringBuilder sb = new StringBuilder();

        sb.append("═".repeat(120)).append("\n");
        sb.append(String.format("%-50s %s %-50s\n", " ", tieuDe, " "));
        sb.append("═".repeat(120)).append("\n");
        sb.append(String.format("Tổng số đăng ký: %d\n", danhSach.size()));
        sb.append("═".repeat(120)).append("\n\n");

        if (danhSach.isEmpty()) {
            sb.append("Chưa có đăng ký nào.\n");
        } else {
            for (DangKy dk : danhSach) {
                sb.append(dk.toString()).append("\n");
            }
        }

        view.getTxtDanhSach().setText(sb.toString());
        view.getTxtDanhSach().setCaretPosition(0);
    }
}
