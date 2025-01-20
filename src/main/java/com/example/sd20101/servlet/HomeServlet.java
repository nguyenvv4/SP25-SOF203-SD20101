package com.example.sd20101.servlet;

import com.example.sd20101.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", value = {"/HomeServlet",
        "/home",
        "/user/hien-thi",// hien thi 1 danh sach user
        "/user/add", //post
        "/user/detail",

})
public class HomeServlet extends HttpServlet {
    ArrayList<User> listUser = new ArrayList<>();

    public HomeServlet() {
        // thuc hien hien thi danh sach user
        listUser.add(new User(1, "Nguyen Van A", 15, "Ha Noi"));
        listUser.add(new User(2, "Nguyen Van B", 16, "Ha Nam"));
        listUser.add(new User(3, "Nguyen Van C", 20, "Thai Binh"));
        listUser.add(new User(4, "Nguyen Van B", 19, "Ha Noi"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/home")) {
            System.out.println("day la trang  home");
            // mo trang jsp
            String hoTen = "Nguyen Van A";
            // set gia tri cho jsp
            request.setAttribute("hoTen", hoTen);

            User user = new User(1, "Nguyen Van A", 25, "Ha Noi");
            request.setAttribute("user", user);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else if (uri.equals("/HomeServlet")) {
            System.out.println("HomeServlet");
        } else if (uri.equals("/user/hien-thi")) {

            request.setAttribute("listUser", listUser);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else if (uri.contains("/user/detail")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            User detail = new User();
            for (User user : listUser) {
                if (id.equals(user.getId())) {
                    detail = user;
                }
            }
            request.setAttribute("detail", detail);

            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post");
        String uri = request.getRequestURI();
        if (uri.contains("/user/add")) {
            // b1. lay duoc thong tin cua form
            String id = request.getParameter("id");
            String hoTen = request.getParameter("hoTen");
            String tuoi = request.getParameter("tuoi");
            String diaChi = request.getParameter("diaChi");

            // b2. Tao doi tuong user tu thong tin vua lay duoc
            User user = new User(Integer.parseInt(id), hoTen, Integer.parseInt(tuoi), diaChi);
            listUser.add(user);
            response.sendRedirect("/user/hien-thi");
        }
    }

    /*
    Tao doi tuong hoc sinh: id, ho ten, diem, ngay sinh, gioi tinh
    Hien thi 10 hoc sinh len giao dien, nếu điểm <5 => Trạng thái fail, ngưược lại pass
     */
}
