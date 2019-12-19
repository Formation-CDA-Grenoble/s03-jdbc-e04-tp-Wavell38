package app;

import java.sql.*;

public class ShippingAddress {
    private int id;
    private String address;
    private String country;
    private String phone;

    public ShippingAddress(int id, String address, String country, String phone) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.phone = phone;
    }

    public static ShippingAddress find(int id) throws Exception {
        ResultSet resultSet = DBManager.sendQuery(
            "SELECT * FROM `shipping_address` WHERE `id` = "+id+""
        );
        ShippingAddress sa = null; 
        while (resultSet.next()) {
            sa = new ShippingAddress(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        }

        return sa;
    }
}