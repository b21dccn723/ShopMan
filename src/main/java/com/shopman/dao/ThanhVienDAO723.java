package com.ShopMan.dao;

import com.ShopMan.model.ThanhVien723;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThanhVienDAO723 extends DAO723 {

    public ThanhVienDAO723(){
        super();
    }
    
    public ThanhVien723 login(String username, String password) {
        ThanhVien723 user = null;
        String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM tblThanhVien723 WHERE tendangnhap = ? AND matkhau = ?";

        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String tendangnhap = rs.getString("tendangnhap");
                String matkhau = rs.getString("matkhau");
                String ngaysinh = rs.getString("ngaysinh");
                String diachi = rs.getString("diachi");
                String sdt = rs.getString("sdt");
                String vaitro = rs.getString("vaitro");

                user = new ThanhVien723(id, ten, tendangnhap, matkhau, ngaysinh, diachi, sdt, vaitro);
                System.out.println("User found: " + user.getTendangnhap());
            } else {
                System.out.println("User not found with provided credentials.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception: " + e.getMessage());
        }

        return user;
    }
}
