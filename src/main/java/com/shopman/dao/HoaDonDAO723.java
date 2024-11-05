package com.ShopMan.dao;

import com.ShopMan.model.HoaDon723;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class HoaDonDAO723 extends DAO723 {
    
    // Hàm lưu hóa đơn
    public boolean luuHoaDon(HoaDon723 hoaDon) {
        String sql = "INSERT INTO tblHoaDon723 (maHoaDon, tblDonHangid, ngayTao, tongTien) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, hoaDon.getMaHoaDon());
            preparedStatement.setInt(2, hoaDon.getTblDonHangid());
            preparedStatement.setDate(3, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            preparedStatement.setDouble(4, hoaDon.getTongTien());
            
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
