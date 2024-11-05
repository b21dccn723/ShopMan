package com.ShopMan.model;

public class ThanhVien723 {
    private int id;
    private String ten;
    private String tendangnhap;
    private String matkhau;
    private String ngaysinh;
    private String diachi;
    private String sdt;
    private String vaitro;

    // Constructor
    public ThanhVien723(int id, String ten, String tendangnhap, String matkhau, String ngaysinh, String diachi, String sdt, String vaitro) {
        this.id = id;
        this.ten = ten;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.vaitro = vaitro;
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

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }
}
