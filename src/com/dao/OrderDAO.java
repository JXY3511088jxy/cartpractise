package com.dao;

import com.bean.Order;

import java.sql.*;

public class OrderDAO {
    public void insert(Order o) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?useSSL=false&characterEncoding=UTF-8",
                    "root", "123456");

            String sql = "insert into order_ values(null,?)";

            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, o.getUser().getId());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                o.setId(id);
            }

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
