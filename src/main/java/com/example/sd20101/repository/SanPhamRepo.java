package com.example.sd20101.repository;

import com.example.sd20101.model.DanhMuc;
import com.example.sd20101.model.SanPham;
import com.example.sd20101.model.SanPhamDTO;
import com.example.sd20101.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepo {

    public List<SanPhamDTO> getAll() {

        String sql = "select sp.id, sp.ten_san_pham, d.ten_danh_muc, sp.mo_ta, sp.ngay_tao, sp.trang_thai from san_pham sp inner join danh_muc d\n" +
                "on d.id = sp.id_danh_muc";
        List<SanPhamDTO> list = new ArrayList<>();
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                SanPhamDTO sanPhamDTO = new SanPhamDTO();
                sanPhamDTO.setId(re.getInt("id"));
                sanPhamDTO.setMoTa(re.getString("mo_ta"));
                sanPhamDTO.setTen(re.getString("ten_san_pham"));
                sanPhamDTO.setNgayTao(re.getDate("ngay_tao"));
                sanPhamDTO.setTrangThai(re.getString("trang_thai"));
                sanPhamDTO.setTenDanhMuc(re.getString("ten_danh_muc"));
                list.add(sanPhamDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DanhMuc> getListDanhMuc() {
        String sql = "select * from danh_muc";
        List<DanhMuc> list = new ArrayList<>();

        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setId(re.getInt("id"));
                danhMuc.setMaDanhMuc(re.getString("ma_danh_muc"));
                danhMuc.setTenDanhMuc(re.getString("ten_danh_muc"));
                list.add(danhMuc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public SanPham getDetail(int id) {
        String sql = "select * from san_pham where id = ?";
        SanPham sanPham = new SanPham();
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                sanPham.setId(re.getInt("id"));
                sanPham.setIdDanhMuc(re.getInt("id_danh_muc"));
                sanPham.setMoTa(re.getString("mo_ta"));
                sanPham.setTrangThai(re.getString("trang_thai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;

    }
}
