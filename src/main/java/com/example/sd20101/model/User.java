package com.example.sd20101.model;

public class User {

    private Integer id;

    private String hoTen;

    private Integer tuoi;

    private String diaChi;

    public User(Integer id, String hoTen, Integer tuoi, String diaChi) {
        this.id = id;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
