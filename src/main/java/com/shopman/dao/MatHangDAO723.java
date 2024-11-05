package com.ShopMan.dao;

import com.ShopMan.model.MatHang723;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MatHangDAO723 extends DAO723 {

    public MatHangDAO723() {
        super();
    }

    // Phương thức chuẩn hóa chuỗi thành không dấu
    private String normalizeString(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").toLowerCase();
    }

    // Tìm kiếm mặt hàng theo từ khóa với chuẩn hóa chuỗi
    public List<MatHang723> TimKiemMH(String keyword) {
        List<MatHang723> danhSachMatHang = new ArrayList<>();
        String TIM_KIEM_MH = "SELECT * FROM tblMatHang723";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(TIM_KIEM_MH)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                double donGia = rs.getDouble("donGia");
                int soLuongCon = rs.getInt("soLuongCon");
                String moTa = rs.getString("moTa");
                String xuatXu = rs.getString("xuatXu");
                MatHang723 matHang = new MatHang723(id, ten, donGia, soLuongCon, moTa, xuatXu);

                // Kiểm tra nếu tên mặt hàng chứa từ khóa sau khi chuẩn hóa
                if (normalizeString(ten).contains(normalizeString(keyword))) {
                    danhSachMatHang.add(matHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachMatHang;
    }

    // Hàm lấy tất cả mặt hàng
    public List<MatHang723> LayTatCaMH() {
        List<MatHang723> danhSachMatHang = new ArrayList<>();
        String LAY_TAT_CA_MH = "SELECT * FROM tblMatHang723";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(LAY_TAT_CA_MH)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                double donGia = rs.getDouble("donGia");
                int soLuongCon = rs.getInt("soLuongCon");
                String moTa = rs.getString("moTa");
                String xuatXu = rs.getString("xuatXu");
                MatHang723 matHang = new MatHang723(id, ten, donGia, soLuongCon, moTa, xuatXu);
                danhSachMatHang.add(matHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachMatHang;
    }

    // Hàm lấy thông tin chi tiết mặt hàng
    public MatHang723 LayThongTinMH(int id) {
        MatHang723 matHang = null;
        String LAY_THONG_TIN_MH = "SELECT * FROM tblMatHang723 WHERE id = ?";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(LAY_THONG_TIN_MH)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String ten = rs.getString("ten");
                double donGia = rs.getDouble("donGia");
                int soLuongCon = rs.getInt("soLuongCon");
                String moTa = rs.getString("moTa");
                String xuatXu = rs.getString("xuatXu");
                matHang = new MatHang723(id, ten, donGia, soLuongCon, moTa, xuatXu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matHang;
    }
}
