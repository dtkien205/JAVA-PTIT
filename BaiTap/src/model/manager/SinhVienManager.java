package model.manager;

import model.SinhVien;
import model.FileController;
import model.interfaces.IManager;

import java.util.ArrayList;
import java.util.List;

/**
 * SinhVienManager quản lý danh sách sinh viên
 */
public class SinhVienManager implements IManager<SinhVien> {
    private static final String FILENAME = "SV.DAT";
    private List<SinhVien> danhSachSinhVien;

    public SinhVienManager() {
        danhSachSinhVien = new ArrayList<>();
        try {
            loadFromFile();
        } catch (Exception e) {
            // File chưa tồn tại hoặc rỗng
            danhSachSinhVien = new ArrayList<>();
        }
    }

    @Override
    public void add(SinhVien sinhVien) throws Exception {
        if (sinhVien == null) {
            throw new Exception("Sinh viên không được null");
        }
        if (sinhVien.getHoTen() == null || sinhVien.getHoTen().trim().isEmpty()) {
            throw new Exception("Họ tên không được rỗng");
        }
        if (sinhVien.getSoDT() == null || sinhVien.getSoDT().trim().isEmpty()) {
            throw new Exception("Số điện thoại không được rỗng");
        }

        // Kiểm tra trùng mã
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getMaSV() == sinhVien.getMaSV()) {
                throw new Exception("Mã sinh viên đã tồn tại");
            }
        }

        danhSachSinhVien.add(sinhVien);
        saveToFile();
    }

    @Override
    public void remove(SinhVien sinhVien) throws Exception {
        if (!danhSachSinhVien.remove(sinhVien)) {
            throw new Exception("Không tìm thấy sinh viên để xóa");
        }
        saveToFile();
    }

    @Override
    public List<SinhVien> getAll() {
        return new ArrayList<>(danhSachSinhVien);
    }

    @Override
    public void saveToFile() throws Exception {
        try {
            FileController.writeToFile(FILENAME, danhSachSinhVien);
        } catch (Exception e) {
            throw new Exception("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile() throws Exception {
        try {
            danhSachSinhVien = FileController.readFromFile(FILENAME);

            // Cập nhật currentId
            if (!danhSachSinhVien.isEmpty()) {
                int maxId = danhSachSinhVien.stream()
                        .mapToInt(SinhVien::getMaSV)
                        .max()
                        .orElse(9999);
                SinhVien.setCurrentId(maxId + 1);
            }
        } catch (Exception e) {
            throw new Exception("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    /**
     * Tìm sinh viên theo mã
     */
    public SinhVien timSinhVien(int maSV) {
        return danhSachSinhVien.stream()
                .filter(sv -> sv.getMaSV() == maSV)
                .findFirst()
                .orElse(null);
    }

    /**
     * Tìm sinh viên theo tên
     */
    public List<SinhVien> timSinhVienTheoTen(String hoTen) {
        List<SinhVien> result = new ArrayList<>();
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getHoTen().toLowerCase().contains(hoTen.toLowerCase())) {
                result.add(sv);
            }
        }
        return result;
    }
}
