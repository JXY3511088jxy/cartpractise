package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bean.OrderItem;
import com.bean.Product;

public class OrderItemDAO {

    public static void main(String[] args) {

    }

    public void insert(OrderItem oi) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?useSSL=false&characterEncoding=UTF-8",
                    "root", "123456");

            String sql = "insert into orderitem values(null,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1,oi.getProduct().getId());
            ps.setInt(2,oi.getNum());
            ps.setInt(3,oi.getOrder().getId());

            ps.execute();

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
