package com.ShopMan.dao;

import com.ShopMan.model.KhachHang723;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHangDAO723 extends DAO723 {

    public KhachHangDAO723() {
        super();
    }

    // Hàm lấy thông tin chi tiết của khách hàng
    public KhachHang723 layThongTinKhachHang(int tblThanhVienid) {
        KhachHang723 khachHang = null;
        String sql = "SELECT k.maKH, t.ten FROM tblKhachHang723 k JOIN tblThanhVien723 t ON k.tblThanhVienid = t.id WHERE k.tblThanhVienid = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, tblThanhVienid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                khachHang = new KhachHang723(rs.getString("maKH"), tblThanhVienid, rs.getString("ten"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;
    }
}
