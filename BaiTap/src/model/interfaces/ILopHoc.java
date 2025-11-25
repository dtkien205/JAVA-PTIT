package model.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Interface cho quản lý lớp học
 */
public interface ILopHoc {
    Map<Integer, List<Integer>> lapDanhSachLopHoc(int maMon);

    Map<Integer, List<Integer>> lapToanBoLopHoc();
}
