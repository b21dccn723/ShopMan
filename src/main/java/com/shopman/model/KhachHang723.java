package com.ShopMan.model;

public class KhachHang723 {
    private String maKH;
    private int tblThanhVienid;
    private String ten;

    public KhachHang723(String maKH, int tblThanhVienid, String ten) {
        this.maKH = maKH;
        this.tblThanhVienid = tblThanhVienid;
        this.ten = ten;
    }

    public String getMaKH() {
        return maKH;
    }

    public int getTblThanhVienid() {
        return tblThanhVienid;
    }

    public String getTen() {
        return ten;
    }
}
