package com.ShopMan.model;

import java.util.Date;

public class HoaDon723 {
    private String maHoaDon;
    private int tblDonHangid;
    private Date ngayTao;
    private double tongTien;

    public HoaDon723(){}
    public HoaDon723(String maHoaDon, int tblDonHangid, Date ngayTao, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.tblDonHangid = tblDonHangid;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getTblDonHangid() {
        return tblDonHangid;
    }

    public void setTblDonHangid(int tblDonHangid) {
        this.tblDonHangid = tblDonHangid;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
