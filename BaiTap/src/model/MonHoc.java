package model;

import java.io.Serializable;

/**
 * Lớp MonHoc đại diện cho môn học
 * Mã môn học: số nguyên 3 chữ số, tự động tăng
 */
public class MonHoc implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int currentId = 100; // Bắt đầu từ 100 (3 chữ số)

    private int maMon;
    private String tenMon;
    private int tongSoTiet;
    private LoaiMonHoc loaiMonHoc;

    public enum LoaiMonHoc {
        DAI_CUONG("Đại cương"),
        CO_SO_NGANH("Cơ sở ngành"),
        CHUYEN_NGANH_BAT_BUOC("Chuyên ngành bắt buộc"),
        CHUYEN_NGANH_TU_CHON("Chuyên ngành tự chọn");

        private String displayName;

        LoaiMonHoc(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    public MonHoc(String tenMon, int tongSoTiet, LoaiMonHoc loaiMonHoc) {
        this.maMon = currentId++;
        this.tenMon = tenMon;
        this.tongSoTiet = tongSoTiet;
        this.loaiMonHoc = loaiMonHoc;
    }

    // Getters and Setters
    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public LoaiMonHoc getLoaiMonHoc() {
        return loaiMonHoc;
    }

    public void setLoaiMonHoc(LoaiMonHoc loaiMonHoc) {
        this.loaiMonHoc = loaiMonHoc;
    }

    public static void setCurrentId(int id) {
        currentId = id;
    }

    public static int getCurrentId() {
        return currentId;
    }

    @Override
    public String toString() {
        return String.format("Mã: %03d | Tên: %-30s | Số tiết: %3d | Loại: %s",
                maMon, tenMon, tongSoTiet, loaiMonHoc.getDisplayName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MonHoc monHoc = (MonHoc) obj;
        return maMon == monHoc.maMon;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(maMon);
    }
}
