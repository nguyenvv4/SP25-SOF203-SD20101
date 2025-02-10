package com.example.sd20101.repository;

import com.example.sd20101.model.User;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UserRepo {

    // lay ra danh sach User(nam trong csdl)

    public List<User> getUsers() {

        String sql = "select * from users";
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                User user = new User();
                user.setId(re.getInt("id"));
                user.setHoTen(re.getString("hoTen"));
                user.setTuoi(re.getInt("tuoi"));
                user.setDiaChi(re.getString("diaChi"));
                user.setGioiTinh(re.getString("gioiTinh"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
