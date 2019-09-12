package com.dao;

import com.bean.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static void main(String[] args) {

        System.out.println(new ProductDAO().getProduct(3).getName());

    }

    public Product getProduct(int id) {
        Product result = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?useSSL=false&characterEncoding=UTF-8",
                    "root", "123456");

            String sql = "select * from product where id = ?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new Product();
                result.setId(id);

                String name = rs.getString(2);
                float price = rs.getFloat(3);

                result.setName(name);
                result.setPrice(price);

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
        return result;
    }

    public List<Product> ListProduct() {
        List<Product> products = new ArrayList<Product>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?useSSL=false&characterEncoding=UTF-8",
                    "root", "123456");

            String sql = "select * from product order by id desc";

            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);

                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);

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
        return products;
    }
}
