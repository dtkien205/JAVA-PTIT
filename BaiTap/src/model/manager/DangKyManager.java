package model.manager;

import model.DangKy;
import model.SinhVien;
import model.MonHoc;
import model.FileController;
import model.interfaces.IManager;
import model.interfaces.IDangKy;
import model.interfaces.ISortDangKy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DangKyManager quản lý đăng ký môn học
 */
public class DangKyManager implements IManager<DangKy>, IDangKy, ISortDangKy {
    private static final String FILENAME = "QLDK.DAT";
    private static final int MAX_MON_HOC = 8;

    private List<DangKy> danhSachDangKy;
    private SinhVienManager sinhVienManager;
    private MonHocManager monHocManager;

    public DangKyManager(SinhVienManager sinhVienManager, MonHocManager monHocManager) {
        this.sinhVienManager = sinhVienManager;
        this.monHocManager = monHocManager;
        danhSachDangKy = new ArrayList<>();
        try {
            loadFromFile();
        } catch (Exception e) {
            // File chưa tồn tại hoặc rỗng
            danhSachDangKy = new ArrayList<>();
        }
    }

    @Override
    public void dangKyMonHoc(int maSV, int maMon) throws Exception {
        // Kiểm tra sinh viên tồn tại
        SinhVien sv = sinhVienManager.timSinhVien(maSV);
        if (sv == null) {
            throw new Exception("Không tìm thấy sinh viên có mã: " + maSV);
        }

        // Kiểm tra môn học tồn tại
        MonHoc mh = monHocManager.timMonHoc(maMon);
        if (mh == null) {
            throw new Exception("Không tìm thấy môn học có mã: " + maMon);
        }

        // Kiểm tra đã đăng ký chưa
        if (kiemTraDaDangKy(maSV, maMon)) {
            throw new Exception("Sinh viên đã đăng ký môn học này rồi");
        }

        // Kiểm tra số môn đã đăng ký
        if (soMonDaDangKy(maSV) >= MAX_MON_HOC) {
            throw new Exception("Sinh viên đã đăng ký đủ " + MAX_MON_HOC + " môn học");
        }

        DangKy dangKy = new DangKy(maSV, maMon);
        danhSachDangKy.add(dangKy);
        saveToFile();
    }

    @Override
    public List<DangKy> getDanhSachDangKyTheoSV(int maSV) {
        return danhSachDangKy.stream()
                .filter(dk -> dk.getMaSV() == maSV)
                .collect(Collectors.toList());
    }

    @Override
    public boolean kiemTraDaDangKy(int maSV, int maMon) {
        return danhSachDangKy.stream()
                .anyMatch(dk -> dk.getMaSV() == maSV && dk.getMaMon() == maMon);
    }

    @Override
    public int soMonDaDangKy(int maSV) {
        return (int) danhSachDangKy.stream()
                .filter(dk -> dk.getMaSV() == maSV)
                .count();
    }

    @Override
    public void add(DangKy dangKy) throws Exception {
        dangKyMonHoc(dangKy.getMaSV(), dangKy.getMaMon());
    }

    @Override
    public void remove(DangKy dangKy) throws Exception {
        if (!danhSachDangKy.remove(dangKy)) {
            throw new Exception("Không tìm thấy đăng ký để xóa");
        }
        saveToFile();
    }

    @Override
    public List<DangKy> getAll() {
        // Cập nhật thông tin tên sinh viên và tên môn học
        List<DangKy> result = new ArrayList<>();
        for (DangKy dk : danhSachDangKy) {
            SinhVien sv = sinhVienManager.timSinhVien(dk.getMaSV());
            MonHoc mh = monHocManager.timMonHoc(dk.getMaMon());

            if (sv != null)
                dk.setTenSV(sv.getHoTen());
            if (mh != null)
                dk.setTenMon(mh.getTenMon());

            result.add(dk);
        }
        return result;
    }

    @Override
    public void saveToFile() throws Exception {
        try {
            FileController.writeToFile(FILENAME, danhSachDangKy);
        } catch (Exception e) {
            throw new Exception("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile() throws Exception {
        try {
            danhSachDangKy = FileController.readFromFile(FILENAME);
        } catch (Exception e) {
            throw new Exception("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    @Override
    public List<DangKy> sapXepTheoTenSV() {
        List<DangKy> sorted = getAll();
        sorted.sort(Comparator.comparing(DangKy::getTenSV,
                Comparator.nullsLast(Comparator.naturalOrder())));
        return sorted;
    }

    @Override
    public List<DangKy> sapXepTheoThoiGian() {
        List<DangKy> sorted = getAll();
        sorted.sort(Comparator.comparing(DangKy::getThoiGianDangKy));
        return sorted;
    }

    /**
     * Lấy danh sách đăng ký theo môn học
     */
    public List<DangKy> getDanhSachDangKyTheoMon(int maMon) {
        return danhSachDangKy.stream()
                .filter(dk -> dk.getMaMon() == maMon)
                .collect(Collectors.toList());
    }
}
