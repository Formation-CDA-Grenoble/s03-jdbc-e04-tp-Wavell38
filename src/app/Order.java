package app;

import java.sql.*;

public class Order {
    private int id;
    private String reference;
    private Date date;
    private int status;
    private User user;
    private ShippingAddress shippingAddress;

    public Order(int id, String reference, Date date, int status, User user, ShippingAddress shippingAddress) {
        this.id = id;
        this.reference = reference;
        this.date = date;
        this.status = status;
        this.user = user;
        this.shippingAddress = shippingAddress;
    }

    public static Order find(int id) throws Exception {
        ResultSet resultSet = DBManager.sendQuery(
            "SELECT * FROM `_order` WHERE `id` = "+id+""
        );
        Order order = null; 
        while (resultSet.next()) {
            ShippingAddress sa = ShippingAddress.find(resultSet.getInt(6));
            User user = User.find(resultSet.getInt(5));
            order = new Order(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(4), user, sa);
        }

        return order;
    }
}
