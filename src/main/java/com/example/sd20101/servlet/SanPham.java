package com.example.sd20101.servlet;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.example.sd20101.model.DanhMuc;
import com.example.sd20101.model.SanPhamDTO;
import com.example.sd20101.repository.SanPhamRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SanPhamServlet", value = {"/SanPham/hienThi",
        "/SanPham/add",
        "/SanPham/detail",
})
public class SanPham extends HttpServlet {

    SanPhamRepo sanPhamRepo = new SanPhamRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/SanPham/hienThi")) {
            List<SanPhamDTO> list = sanPhamRepo.getAll();
            request.setAttribute("list", list);

            List<DanhMuc> listDanhMuc = sanPhamRepo.getListDanhMuc();
            request.setAttribute("listDanhMuc", listDanhMuc);
            request.getRequestDispatcher("/SanPham.jsp").forward(request, response);
        }else if (uri.equals("/SanPham/detail")) {
            String id = request.getParameter("id");
            List<DanhMuc> listDanhMuc = sanPhamRepo.getListDanhMuc();
            request.setAttribute("listDanhMuc", listDanhMuc);
            com.example.sd20101.model.SanPham sanPhamDetail = sanPhamRepo.getDetail(Integer.parseInt(id));
            request.setAttribute("sanPhamDetail", sanPhamDetail);
            request.getRequestDispatcher("/SanPhamDetail.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/SanPham/add")) {
            String tenSanPham = request.getParameter("tenSanPham");
            String maSanPham = request.getParameter("maSanPham");
            String trangThai = request.getParameter("trangThai");
            String moTa = request.getParameter("moTa");
            String idDanhMuc = request.getParameter("idDanhMuc");
            com.example.sd20101.model.SanPham sanPham = new com.example.sd20101.model.SanPham();
            sanPham.setTenSanPham(tenSanPham);
            sanPham.setMaSanPham(maSanPham);
            sanPham.setTrangThai(trangThai);
            sanPham.setMoTa(moTa);
            sanPham.setIdDanhMuc(Integer.parseInt(idDanhMuc));
            sanPham.setNgayTao(new Date());
            sanPham.setNgaySua(new Date());
            // goi insert into




        }
    }
}