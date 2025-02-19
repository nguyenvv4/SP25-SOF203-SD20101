package com.example.sd20101.model;

import java.util.Date;

public class SanPhamDTO {
    private Integer id;
    private String ten;
    private String tenDanhMuc;
    private Date ngayTao;
    private String trangThai;
    private String moTa;

    public SanPhamDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }


    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "tsanPhamen='" + ten + '\'' +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }
}
