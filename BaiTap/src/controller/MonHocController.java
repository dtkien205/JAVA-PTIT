package controller;

import model.MonHoc;
import model.manager.MonHocManager;
import view.PanelMonHoc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * MonHocController - Controller cho quản lý môn học
 */
public class MonHocController {
    private MonHocManager monHocManager;
    private PanelMonHoc view;

    public MonHocController(MonHocManager monHocManager, PanelMonHoc view) {
        this.monHocManager = monHocManager;
        this.view = view;

        initController();
        hienThiDanhSach();
    }

    private void initController() {
        // Xử lý sự kiện nút Thêm
        view.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themMonHoc();
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

    private void themMonHoc() {
        try {
            // Lấy dữ liệu từ view
            String tenMon = view.getTxtTenMon().getText().trim();
            String soTietStr = view.getTxtSoTiet().getText().trim();
            int loaiMonIndex = view.getCboLoaiMon().getSelectedIndex();

            // Validate
            if (tenMon.isEmpty()) {
                throw new Exception("Tên môn học không được rỗng");
            }

            if (soTietStr.isEmpty()) {
                throw new Exception("Số tiết không được rỗng");
            }

            int soTiet = Integer.parseInt(soTietStr);
            if (soTiet <= 0) {
                throw new Exception("Số tiết phải lớn hơn 0");
            }

            // Chuyển đổi loại môn học
            MonHoc.LoaiMonHoc loaiMonHoc;
            switch (loaiMonIndex) {
                case 0:
                    loaiMonHoc = MonHoc.LoaiMonHoc.DAI_CUONG;
                    break;
                case 1:
                    loaiMonHoc = MonHoc.LoaiMonHoc.CO_SO_NGANH;
                    break;
                case 2:
                    loaiMonHoc = MonHoc.LoaiMonHoc.CHUYEN_NGANH_BAT_BUOC;
                    break;
                case 3:
                    loaiMonHoc = MonHoc.LoaiMonHoc.CHUYEN_NGANH_TU_CHON;
                    break;
                default:
                    loaiMonHoc = MonHoc.LoaiMonHoc.DAI_CUONG;
            }

            // Tạo môn học mới
            MonHoc monHoc = new MonHoc(tenMon, soTiet, loaiMonHoc);
            monHocManager.add(monHoc);

            // Thông báo thành công
            JOptionPane.showMessageDialog(view,
                    "Thêm môn học thành công!\nMã môn: " + String.format("%03d", monHoc.getMaMon()),
                    "Thành công",
                    JOptionPane.INFORMATION_MESSAGE);

            // Làm mới và hiển thị danh sách
            lamMoi();
            hienThiDanhSach();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view,
                    "Số tiết phải là số nguyên",
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
        view.getTxtTenMon().setText("");
        view.getTxtSoTiet().setText("");
        view.getCboLoaiMon().setSelectedIndex(0);
        view.getTxtTenMon().requestFocus();
    }

    private void hienThiDanhSach() {
        List<MonHoc> danhSach = monHocManager.getAll();
        StringBuilder sb = new StringBuilder();

        sb.append("═".repeat(100)).append("\n");
        sb.append(String.format("%-40s DANH SÁCH MÔN HỌC %-40s\n", " ", " "));
        sb.append("═".repeat(100)).append("\n");
        sb.append(String.format("Tổng số môn học: %d\n", danhSach.size()));
        sb.append("═".repeat(100)).append("\n\n");

        if (danhSach.isEmpty()) {
            sb.append("Chưa có môn học nào được thêm vào.\n");
        } else {
            for (MonHoc mh : danhSach) {
                sb.append(mh.toString()).append("\n");
            }
        }

        view.getTxtDanhSach().setText(sb.toString());
        view.getTxtDanhSach().setCaretPosition(0);
    }

    public void refresh() {
        hienThiDanhSach();
    }
}
