package controller;

import model.DangKy;
import model.manager.DangKyManager;
import view.PanelDangKy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * DangKyController - Controller cho đăng ký môn học
 */
public class DangKyController {
    private DangKyManager dangKyManager;
    private PanelDangKy view;

    public DangKyController(DangKyManager dangKyManager, PanelDangKy view) {
        this.dangKyManager = dangKyManager;
        this.view = view;

        initController();
        hienThiDanhSach();
    }

    private void initController() {
        // Xử lý sự kiện nút Đăng ký
        view.getBtnDangKy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dangKyMonHoc();
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

    private void dangKyMonHoc() {
        try {
            // Lấy dữ liệu từ view
            String maSVStr = view.getTxtMaSV().getText().trim();
            String maMonStr = view.getTxtMaMon().getText().trim();

            // Validate
            if (maSVStr.isEmpty()) {
                throw new Exception("Mã sinh viên không được rỗng");
            }

            if (maMonStr.isEmpty()) {
                throw new Exception("Mã môn học không được rỗng");
            }

            int maSV = Integer.parseInt(maSVStr);
            int maMon = Integer.parseInt(maMonStr);

            // Đăng ký môn học
            dangKyManager.dangKyMonHoc(maSV, maMon);

            // Thông báo thành công
            JOptionPane.showMessageDialog(view,
                    "Đăng ký môn học thành công!",
                    "Thành công",
                    JOptionPane.INFORMATION_MESSAGE);

            // Làm mới và hiển thị danh sách
            lamMoi();
            hienThiDanhSach();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view,
                    "Mã sinh viên và mã môn học phải là số nguyên",
                    "Lỗi nhập liệu",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Lỗi: " + ex.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void lamMoi() {
        view.getTxtMaSV().setText("");
        view.getTxtMaMon().setText("");
        view.getTxtMaSV().requestFocus();
    }

    private void hienThiDanhSach() {
        List<DangKy> danhSach = dangKyManager.getAll();
        StringBuilder sb = new StringBuilder();

        sb.append("═".repeat(120)).append("\n");
        sb.append(String.format("%-50s DANH SÁCH ĐĂNG KÝ MÔN HỌC %-50s\n", " ", " "));
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

    public void refresh() {
        hienThiDanhSach();
    }
}
