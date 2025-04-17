/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Manh
 */

public class SinhVien {
    private int id;
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private String vaiTro;
    private String maSinhVien;
    private int lopId;
    private String nganh;
    private String khoa;
    private String gioiTinh;
    private int monHocId;
    private int diemRenLuyenId;

    // Constructor
    public SinhVien(int id, String tenDangNhap, String matKhau, String hoTen, String vaiTro,
                    String maSinhVien, int lopId, String nganh, String khoa, String gioiTinh,
                    int monHocId, int diemRenLuyenId) {
        this.id = id;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
        this.maSinhVien = maSinhVien;
        this.lopId = lopId;
        this.nganh = nganh;
        this.khoa = khoa;
        this.gioiTinh = gioiTinh;
        this.monHocId = monHocId;
        this.diemRenLuyenId = diemRenLuyenId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public int getLopId() {
        return lopId;
    }

    public void setLopId(int lopId) {
        this.lopId = lopId;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getMonHocId() {
        return monHocId;
    }

    public void setMonHocId(int monHocId) {
        this.monHocId = monHocId;
    }

    public int getDiemRenLuyenId() {
        return diemRenLuyenId;
    }

    public void setDiemRenLuyenId(int diemRenLuyenId) {
        this.diemRenLuyenId = diemRenLuyenId;
    }

    @Override
    public String toString() {
        return "SinhVien [id=" + id + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", hoTen=" + hoTen
                + ", vaiTro=" + vaiTro + ", maSinhVien=" + maSinhVien + ", lopId=" + lopId + ", nganh=" + nganh
                + ", khoa=" + khoa + ", gioiTinh=" + gioiTinh + ", monHocId=" + monHocId + ", diemRenLuyenId="
                + diemRenLuyenId + "]";
    }
}

