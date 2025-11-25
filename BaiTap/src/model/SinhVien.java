package model;

import java.io.Serializable;

/**
 * Lớp SinhVien đại diện cho sinh viên
 * Mã sinh viên: số nguyên 5 chữ số, tự động tăng
 */
public class SinhVien implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int currentId = 10000; // Bắt đầu từ 10000 (5 chữ số)

    private int maSV;
    private String hoTen;
    private String diaChi;
    private String soDT;

    public SinhVien(String hoTen, String diaChi, String soDT) {
        this.maSV = currentId++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    // Getters and Setters
    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public static void setCurrentId(int id) {
        currentId = id;
    }

    public static int getCurrentId() {
        return currentId;
    }

    @Override
    public String toString() {
        return String.format("MSSV: %05d | Họ tên: %-25s | ĐT: %-12s | Địa chỉ: %s",
                maSV, hoTen, soDT, diaChi);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        SinhVien sinhVien = (SinhVien) obj;
        return maSV == sinhVien.maSV;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(maSV);
    }
}
