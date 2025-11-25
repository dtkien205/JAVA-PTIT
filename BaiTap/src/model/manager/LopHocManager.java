package model.manager;

import model.DangKy;
import model.MonHoc;
import model.interfaces.ILopHoc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LopHocManager quản lý việc lập lớp học
 */
public class LopHocManager implements ILopHoc {
    private static final int MAX_SINH_VIEN = 30;

    private DangKyManager dangKyManager;
    private MonHocManager monHocManager;

    public LopHocManager(DangKyManager dangKyManager, MonHocManager monHocManager) {
        this.dangKyManager = dangKyManager;
        this.monHocManager = monHocManager;
    }

    @Override
    public Map<Integer, List<Integer>> lapDanhSachLopHoc(int maMon) {
        // Lấy danh sách đăng ký theo môn học
        List<DangKy> danhSachDK = dangKyManager.getDanhSachDangKyTheoMon(maMon);

        // Sắp xếp theo thời gian đăng ký
        danhSachDK.sort(Comparator.comparing(DangKy::getThoiGianDangKy));

        // Chia thành các lớp
        Map<Integer, List<Integer>> danhSachLop = new LinkedHashMap<>();
        int soLop = 0;
        List<Integer> lopHienTai = new ArrayList<>();

        for (DangKy dk : danhSachDK) {
            if (lopHienTai.size() >= MAX_SINH_VIEN) {
                danhSachLop.put(++soLop, new ArrayList<>(lopHienTai));
                lopHienTai.clear();
            }
            lopHienTai.add(dk.getMaSV());
        }

        // Thêm lớp cuối cùng nếu còn sinh viên
        if (!lopHienTai.isEmpty()) {
            danhSachLop.put(++soLop, lopHienTai);
        }

        return danhSachLop;
    }

    @Override
    public Map<Integer, List<Integer>> lapToanBoLopHoc() {
        Map<Integer, List<Integer>> tatCaLopHoc = new LinkedHashMap<>();

        // Lấy tất cả môn học
        List<MonHoc> danhSachMonHoc = monHocManager.getAll();

        for (MonHoc mh : danhSachMonHoc) {
            Map<Integer, List<Integer>> lopHocCuaMon = lapDanhSachLopHoc(mh.getMaMon());
            if (!lopHocCuaMon.isEmpty()) {
                tatCaLopHoc.putAll(lopHocCuaMon);
            }
        }

        return tatCaLopHoc;
    }

    /**
     * Lấy thông tin chi tiết lớp học theo môn
     */
    public String getThongTinLopHoc(int maMon) {
        MonHoc mh = monHocManager.timMonHoc(maMon);
        if (mh == null) {
            return "Không tìm thấy môn học";
        }

        Map<Integer, List<Integer>> danhSachLop = lapDanhSachLopHoc(maMon);

        StringBuilder sb = new StringBuilder();
        sb.append("MÔN HỌC: ").append(mh.getTenMon())
                .append(" (Mã: ").append(String.format("%03d", maMon)).append(")\n");
        sb.append("=".repeat(80)).append("\n");

        if (danhSachLop.isEmpty()) {
            sb.append("Chưa có sinh viên đăng ký môn học này.\n");
        } else {
            int tongSV = 0;
            for (Map.Entry<Integer, List<Integer>> entry : danhSachLop.entrySet()) {
                sb.append("Lớp ").append(entry.getKey())
                        .append(" (").append(entry.getValue().size()).append(" sinh viên):\n");

                for (int maSV : entry.getValue()) {
                    sb.append("  - MSSV: ").append(String.format("%05d", maSV)).append("\n");
                }
                sb.append("\n");
                tongSV += entry.getValue().size();
            }
            sb.append("Tổng số lớp: ").append(danhSachLop.size()).append("\n");
            sb.append("Tổng số sinh viên: ").append(tongSV).append("\n");
        }

        return sb.toString();
    }
}
