package com.example.sd20101.servlet;

import com.example.sd20101.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", value = {"/HomeServlet",
        "/home",
        "/user/hien-thi" // hien thi 1 danh sach user
})
public class HomeServlet extends HttpServlet {

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
            // thuc hien hien thi danh sach user
            ArrayList<User> listUser = new ArrayList<>();
            listUser.add(new User(1, "Nguyen Van A", 15, "Ha Noi"));
            listUser.add(new User(2, "Nguyen Van B", 16, "Ha Nam"));
            listUser.add(new User(3, "Nguyen Van C", 20, "Thai Binh"));
            listUser.add(new User(4, "Nguyen Van B", 19, "Ha Noi"));

            request.setAttribute("listUser", listUser);

            for (User user : listUser) {

            }
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post");
    }
}
