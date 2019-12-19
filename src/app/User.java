package app;
import java.sql.*;

public class User extends DefaultManager {
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
}