package model.manager;

import model.MonHoc;
import model.FileController;
import model.interfaces.IManager;

import java.util.ArrayList;
import java.util.List;

/**
 * MonHocManager quản lý danh sách môn học
 */
public class MonHocManager implements IManager<MonHoc> {
    private static final String FILENAME = "MH.DAT";
    private List<MonHoc> danhSachMonHoc;

    public MonHocManager() {
        danhSachMonHoc = new ArrayList<>();
        try {
            loadFromFile();
        } catch (Exception e) {
            // File chưa tồn tại hoặc rỗng
            danhSachMonHoc = new ArrayList<>();
        }
    }

    @Override
    public void add(MonHoc monHoc) throws Exception {
        if (monHoc == null) {
            throw new Exception("Môn học không được null");
        }
        if (monHoc.getTenMon() == null || monHoc.getTenMon().trim().isEmpty()) {
            throw new Exception("Tên môn học không được rỗng");
        }
        if (monHoc.getTongSoTiet() <= 0) {
            throw new Exception("Tổng số tiết phải lớn hơn 0");
        }

        // Kiểm tra trùng mã
        for (MonHoc mh : danhSachMonHoc) {
            if (mh.getMaMon() == monHoc.getMaMon()) {
                throw new Exception("Mã môn học đã tồn tại");
            }
        }

        danhSachMonHoc.add(monHoc);
        saveToFile();
    }

    @Override
    public void remove(MonHoc monHoc) throws Exception {
        if (!danhSachMonHoc.remove(monHoc)) {
            throw new Exception("Không tìm thấy môn học để xóa");
        }
        saveToFile();
    }

    @Override
    public List<MonHoc> getAll() {
        return new ArrayList<>(danhSachMonHoc);
    }

    @Override
    public void saveToFile() throws Exception {
        try {
            FileController.writeToFile(FILENAME, danhSachMonHoc);
        } catch (Exception e) {
            throw new Exception("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile() throws Exception {
        try {
            danhSachMonHoc = FileController.readFromFile(FILENAME);

            // Cập nhật currentId
            if (!danhSachMonHoc.isEmpty()) {
                int maxId = danhSachMonHoc.stream()
                        .mapToInt(MonHoc::getMaMon)
                        .max()
                        .orElse(99);
                MonHoc.setCurrentId(maxId + 1);
            }
        } catch (Exception e) {
            throw new Exception("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    /**
     * Tìm môn học theo mã
     */
    public MonHoc timMonHoc(int maMon) {
        return danhSachMonHoc.stream()
                .filter(mh -> mh.getMaMon() == maMon)
                .findFirst()
                .orElse(null);
    }

    /**
     * Tìm môn học theo tên
     */
    public List<MonHoc> timMonHocTheoTen(String tenMon) {
        List<MonHoc> result = new ArrayList<>();
        for (MonHoc mh : danhSachMonHoc) {
            if (mh.getTenMon().toLowerCase().contains(tenMon.toLowerCase())) {
                result.add(mh);
            }
        }
        return result;
    }
}
