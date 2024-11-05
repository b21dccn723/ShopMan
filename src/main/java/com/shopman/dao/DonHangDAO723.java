package com.ShopMan.dao;

import com.ShopMan.model.DonHang723;
import com.ShopMan.model.GioHangItem723;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO723 extends DAO723 {

    public DonHangDAO723() {
        super();
    }

    // Hàm lấy danh sách các đơn hàng chưa được duyệt
    public List<DonHang723> getDonHang() {
        List<DonHang723> danhSachDon = new ArrayList<>();
        String sql = "SELECT * FROM tblDonHang723 WHERE trangThaiDonHang = N'Chưa duyệt'";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DonHang723 donHang = new DonHang723(
                        rs.getInt("id"),
                        rs.getString("maDonHang"),
                        rs.getString("trangThaiDonHang"),
                        rs.getString("tinhTrangDonHang"),
                        rs.getDate("ngayTao"),
                        rs.getFloat("tongTien"),
                        rs.getInt("tblGioHangid"),
                        rs.getInt("tblNVGiaoHangid"),
                        rs.getInt("tblNVDuyetDonid"),
                        rs.getInt("tblKhachHangid")
                );
                danhSachDon.add(donHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachDon;
    }

    // Hàm lấy thông tin chi tiết của một đơn hàng
    public DonHang723 getChiTietDon(int id) {
        DonHang723 donHang = null;
        String sql = "SELECT * FROM tblDonHang723 WHERE id = ?";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                donHang = new DonHang723(
                        rs.getInt("id"),
                        rs.getString("maDonHang"),
                        rs.getString("trangThaiDonHang"),
                        rs.getString("tinhTrangDonHang"),
                        rs.getDate("ngayTao"),
                        rs.getFloat("tongTien"),
                        rs.getInt("tblGioHangid"),
                        rs.getInt("tblNVGiaoHangid"),
                        rs.getInt("tblNVDuyetDonid"),
                        rs.getInt("tblKhachHangid")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donHang;
    }

    // Hàm lưu đơn hàng
    public boolean luuDonHang(DonHang723 donhang) {
    String sql = "UPDATE tblDonHang723 SET trangThaiDonHang = ?, tblNVGiaoHangid = ? WHERE id = ?";
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, donhang.getTrangThaiDonHang());
        preparedStatement.setInt(2, donhang.getTblNVGiaoHangid());
        preparedStatement.setInt(3, donhang.getId());
        int affectedRows = preparedStatement.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


    // Hàm lấy danh sách các mặt hàng trong giỏ hàng
    public List<GioHangItem723> getItemsInGioHang(int gioHangId) {
        List<GioHangItem723> danhSachItems = new ArrayList<>();
        String sql = "SELECT m.ten, gi.soLuong, m.donGia FROM tblGioHangItem723 gi JOIN tblMatHang723 m ON gi.tblMatHang723id = m.id WHERE gi.tblGioHang723id = ?";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, gioHangId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                GioHangItem723 item = new GioHangItem723(rs.getString("ten"), rs.getInt("soLuong"), rs.getFloat("donGia"));
                danhSachItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachItems;
    }
}
