package com.ShopMan.model;

public class MatHang723 {
    private int id;
    private String ten;
    private double donGia;
    private int soLuongCon;
    private String moTa;
    private String xuatXu;

    // Constructor
    public MatHang723(int id, String ten, double donGia, int soLuongCon, String moTa, String xuatXu) {
        this.id = id;
        this.ten = ten;
        this.donGia = donGia;
        this.soLuongCon = soLuongCon;
        this.moTa = moTa;
        this.xuatXu = xuatXu;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
}
