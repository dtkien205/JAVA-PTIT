package model.interfaces;

import model.DangKy;
import java.util.List;

/**
 * Interface cho sắp xếp danh sách đăng ký
 */
public interface ISortDangKy {
    List<DangKy> sapXepTheoTenSV();

    List<DangKy> sapXepTheoThoiGian();
}
