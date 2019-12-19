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

    public Product[] getProducts() throws Exception {
        ResultSet resultSet = DBManager.sendQuery(
            "SELECT * FROM `product` JOIN `orders_in_products` ON `product`.id = `orders_in_products`.`product_id` WHERE `orders_in_products`.`order_id` = "+id+""
        );
        Product[] products = new Product[resultSet.getRow()];
        int i = 0;
        while (resultSet.next()) {
            products[i] = new Product(
                resultSet.getInt(1), 
                resultSet.getString(2), 
                resultSet.getString(3), 
                resultSet.getString(4), 
                resultSet.getFloat(5),
                resultSet.getInt(6),
                resultSet.getInt(7),
                resultSet.getString(8),
                resultSet.getInt(9)
            );
            i++;
        }
        return products;
    }
}
