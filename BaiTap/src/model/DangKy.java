package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Lớp DangKy đại diện cho bảng đăng ký môn học của sinh viên
 */
public class DangKy implements Serializable {
    private static final long serialVersionUID = 1L;

    private int maSV;
    private int maMon;
    private LocalDateTime thoiGianDangKy;

    // Thêm thông tin để hiển thị
    private transient String tenSV;
    private transient String tenMon;

    public DangKy(int maSV, int maMon) {
        this.maSV = maSV;
        this.maMon = maMon;
        this.thoiGianDangKy = LocalDateTime.now();
    }

    public DangKy(int maSV, int maMon, LocalDateTime thoiGianDangKy) {
        this.maSV = maSV;
        this.maMon = maMon;
        this.thoiGianDangKy = thoiGianDangKy;
    }

    // Getters and Setters
    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public LocalDateTime getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(LocalDateTime thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("MSSV: %05d | Mã MH: %03d | Tên SV: %-25s | Tên MH: %-30s | Thời gian: %s",
                maSV, maMon,
                tenSV != null ? tenSV : "N/A",
                tenMon != null ? tenMon : "N/A",
                thoiGianDangKy.format(formatter));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DangKy dangKy = (DangKy) obj;
        return maSV == dangKy.maSV && maMon == dangKy.maMon;
    }

    @Override
    public int hashCode() {
        return 31 * maSV + maMon;
    }
}
