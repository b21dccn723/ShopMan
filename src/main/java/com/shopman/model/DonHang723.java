package com.ShopMan.model;

import java.util.Date;

public class DonHang723 {
    private int id;
    private String maDonHang;
    private String trangThaiDonHang;
    private String tinhTrangDonHang;
    private Date ngayTao;
    private float tongTien;
    private int tblGioHangid;
    private int tblNVGiaoHangid;
    private int tblNVDuyetDonid;
    private int tblKhachHangid;

    public DonHang723(){}
    // Constructor
    public DonHang723(int id, String maDonHang, String trangThaiDonHang, String tinhTrangDonHang, Date ngayTao, float tongTien, int tblGioHangid, int tblNVGiaoHangid, int tblNVDuyetDonid, int tblKhachHangid) {
        this.id = id;
        this.maDonHang = maDonHang;
        this.trangThaiDonHang = trangThaiDonHang;
        this.tinhTrangDonHang = tinhTrangDonHang;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.tblGioHangid = tblGioHangid;
        this.tblNVGiaoHangid = tblNVGiaoHangid;
        this.tblNVDuyetDonid = tblNVDuyetDonid;
        this.tblKhachHangid = tblKhachHangid;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getTrangThaiDonHang() {
        return trangThaiDonHang;
    }

    public void setTrangThaiDonHang(String trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }

    public String getTinhTrangDonHang() {
        return tinhTrangDonHang;
    }

    public void setTinhTrangDonHang(String tinhTrangDonHang) {
        this.tinhTrangDonHang = tinhTrangDonHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public int getTblGioHangid() {
        return tblGioHangid;
    }

    public void setTblGioHangid(int tblGioHangid) {
        this.tblGioHangid = tblGioHangid;
    }

    public int getTblNVGiaoHangid() {
        return tblNVGiaoHangid;
    }

    public void setTblNVGiaoHangid(int tblNVGiaoHangid) {
        this.tblNVGiaoHangid = tblNVGiaoHangid;
    }

    public int getTblNVDuyetDonid() {
        return tblNVDuyetDonid;
    }

    public void setTblNVDuyetDonid(int tblNVDuyetDonid) {
        this.tblNVDuyetDonid = tblNVDuyetDonid;
    }

    public int getTblKhachHangid() {
        return tblKhachHangid;
    }

    public void setTblKhachHangid(int tblKhachHangid) {
        this.tblKhachHangid = tblKhachHangid;
    }
}
