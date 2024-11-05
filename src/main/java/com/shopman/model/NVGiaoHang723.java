package com.ShopMan.model;

public class NVGiaoHang723 {
    private int id;
    private int tblNhanVienid;
    private String ten;

    // Constructor
    public NVGiaoHang723(int id, int tblNhanVienid, String ten) {
        this.id = id;
        this.tblNhanVienid = tblNhanVienid;
        this.ten = ten;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTblNhanVienid() {
        return tblNhanVienid;
    }

    public void setTblNhanVienid(int tblNhanVienid) {
        this.tblNhanVienid = tblNhanVienid;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
