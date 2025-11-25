package controller;

import model.manager.LopHocManager;
import model.manager.MonHocManager;
import model.manager.SinhVienManager;
import model.MonHoc;
import view.PanelLopHoc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * LopHocController - Controller cho lập lớp học
 */
public class LopHocController {
    private LopHocManager lopHocManager;
    private MonHocManager monHocManager;
    private SinhVienManager sinhVienManager;
    private PanelLopHoc view;

    public LopHocController(LopHocManager lopHocManager, MonHocManager monHocManager,
            SinhVienManager sinhVienManager, PanelLopHoc view) {
        this.lopHocManager = lopHocManager;
        this.monHocManager = monHocManager;
        this.sinhVienManager = sinhVienManager;
        this.view = view;

        initController();
    }

    private void initController() {
        // Xử lý sự kiện nút Lập lớp theo môn
        view.getBtnLapLopTheoMon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lapLopTheoMon();
            }
        });

        // Xử lý sự kiện nút Lập toàn bộ lớp
        view.getBtnLapToanBoLop().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lapToanBoLop();
            }
        });
    }

    private void lapLopTheoMon() {
        try {
            String maMonStr = view.getTxtMaMon().getText().trim();

            if (maMonStr.isEmpty()) {
                throw new Exception("Mã môn học không được rỗng");
            }

            int maMon = Integer.parseInt(maMonStr);

            // Kiểm tra môn học có tồn tại không
            MonHoc mh = monHocManager.timMonHoc(maMon);
            if (mh == null) {
                throw new Exception("Không tìm thấy môn học có mã: " + maMon);
            }

            // Lấy thông tin lớp học
            String thongTin = lopHocManager.getThongTinLopHoc(maMon);

            // Hiển thị
            view.getTxtDanhSach().setText(thongTin);
            view.getTxtDanhSach().setCaretPosition(0);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view,
                    "Mã môn học phải là số nguyên",
                    "Lỗi nhập liệu",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Lỗi: " + ex.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void lapToanBoLop() {
        try {
            List<MonHoc> danhSachMonHoc = monHocManager.getAll();

            if (danhSachMonHoc.isEmpty()) {
                throw new Exception("Chưa có môn học nào trong hệ thống");
            }

            StringBuilder sb = new StringBuilder();
            sb.append("═".repeat(100)).append("\n");
            sb.append(String.format("%-40s DANH SÁCH TẤT CẢ LỚP HỌC %-40s\n", " ", " "));
            sb.append("═".repeat(100)).append("\n\n");

            int tongLop = 0;
            int tongSV = 0;

            for (MonHoc mh : danhSachMonHoc) {
                Map<Integer, List<Integer>> danhSachLop = lopHocManager.lapDanhSachLopHoc(mh.getMaMon());

                if (!danhSachLop.isEmpty()) {
                    sb.append("MÔN HỌC: ").append(mh.getTenMon())
                            .append(" (Mã: ").append(String.format("%03d", mh.getMaMon())).append(")\n");
                    sb.append("-".repeat(100)).append("\n");

                    for (Map.Entry<Integer, List<Integer>> entry : danhSachLop.entrySet()) {
                        sb.append("  Lớp ").append(entry.getKey())
                                .append(" (").append(entry.getValue().size()).append(" sinh viên): ");

                        // In danh sách mã sinh viên
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            if (i > 0)
                                sb.append(", ");
                            sb.append(String.format("%05d", entry.getValue().get(i)));
                        }
                        sb.append("\n");

                        tongSV += entry.getValue().size();
                    }

                    tongLop += danhSachLop.size();
                    sb.append("\n");
                }
            }

            if (tongLop == 0) {
                sb.append("Chưa có đăng ký nào trong hệ thống.\n");
            } else {
                sb.append("═".repeat(100)).append("\n");
                sb.append(String.format("TỔNG KẾT: %d lớp học | %d sinh viên\n", tongLop, tongSV));
                sb.append("═".repeat(100)).append("\n");
            }

            view.getTxtDanhSach().setText(sb.toString());
            view.getTxtDanhSach().setCaretPosition(0);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                    "Lỗi: " + ex.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
