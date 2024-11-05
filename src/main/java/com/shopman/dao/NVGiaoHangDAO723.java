package com.ShopMan.dao;

import com.ShopMan.model.NVGiaoHang723;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NVGiaoHangDAO723 extends DAO723{

    public NVGiaoHangDAO723(){
        super();
    }
    
    // Hàm lấy danh sách tất cả nhân viên giao hàng
    public List<NVGiaoHang723> layNVGiaoHang() {
        List<NVGiaoHang723> danhSachNVGiaoHang = new ArrayList<>();
        String sql = "SELECT nv.id, nv.tblNhanVienid, tv.ten " +
                     "FROM tblNVGiaoHang723 nv " +
                     "JOIN tblNhanVien723 n ON nv.tblNhanVienid = n.tblThanhVienid " +
                     "JOIN tblThanhVien723 tv ON n.tblThanhVienid = tv.id";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NVGiaoHang723 nvGiaoHang = new NVGiaoHang723(
                    rs.getInt("id"),
                    rs.getInt("tblNhanVienid"),
                    rs.getString("ten")
                );
                danhSachNVGiaoHang.add(nvGiaoHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNVGiaoHang;
    }

    // Hàm lấy thông tin của một nhân viên giao hàng theo ID
    public NVGiaoHang723 layChiTietNVGH(int tblNhanVienid) {
        NVGiaoHang723 nvGiaoHang = null;
        String sql = "SELECT nv.id, nv.tblNhanVienid, tv.ten " +
                     "FROM tblNVGiaoHang723 nv " +
                     "JOIN tblNhanVien723 n ON nv.tblNhanVienid = n.tblThanhVienid " +
                     "JOIN tblThanhVien723 tv ON n.tblThanhVienid = tv.id " +
                     "WHERE nv.tblNhanVienid = ?";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, tblNhanVienid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                nvGiaoHang = new NVGiaoHang723(
                    rs.getInt("id"),
                    rs.getInt("tblNhanVienid"),
                    rs.getString("ten")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nvGiaoHang;
    }
}
