package app;
import java.sql.*;

public class User {
    private int id;
    private String email;
    private String password;
    private String username;

    public User(int id, String email, String password, String username) {
        this.id = id; 
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public static User find(int id) throws Exception {
        ResultSet resultSet = DBManager.sendQuery(
            "SELECT * FROM `user` WHERE `id` = "+id+""
        );
        User user = null; 
        while (resultSet.next()) {
            user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        }

        return user;
    }
}