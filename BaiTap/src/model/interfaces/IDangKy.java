package model.interfaces;

import model.DangKy;
import java.util.List;

/**
 * Interface cho quản lý đăng ký môn học
 */
public interface IDangKy {
    void dangKyMonHoc(int maSV, int maMon) throws Exception;

    List<DangKy> getDanhSachDangKyTheoSV(int maSV);

    boolean kiemTraDaDangKy(int maSV, int maMon);

    int soMonDaDangKy(int maSV);
}
