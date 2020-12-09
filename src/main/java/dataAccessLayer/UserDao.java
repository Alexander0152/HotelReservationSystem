package dataAccessLayer;

import businessLayer.User;
import businessLayer.UserStatus;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDao {
    private String connectionFileName;

    public UserDao(String connectionFileName) {
        this.connectionFileName = connectionFileName;
    }

    public User getUserByEmail(String email) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        String host = "";
        String login = "";
        String password = "";
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream(connectionFileName);
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");

        } catch (IOException e) {
            System.err.println("Error: File doesn't exist!");
        }


        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String sql = String.format("SELECT* FROM users WHERE email = '%s';", email);
        ResultSet rs = st.executeQuery(sql);

        User user = new User();
        if(rs.next()){
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            String status=rs.getString("status");
            switch (status){
                case "admin": { user.setStatus(UserStatus.ADMIN); break; }
                case "user": { user.setStatus(UserStatus.USER); break; }
                case "banned":{ user.setStatus(UserStatus.BANNED); break;}
                default: { break; }
            }
        }
        con.close();

        return user;
    }

    public List<User> getUserByStatus(UserStatus status) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        String host = "";
        String login = "";
        String password = "";
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream(connectionFileName);
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");

        } catch (IOException e) {
            System.err.println("Error: File doesn't exist!");
        }

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String lowerCaseStatus = status.toString().toLowerCase();
        String sql = String.format("SELECT* FROM users WHERE status = '%s';", lowerCaseStatus);
        ResultSet rs = st.executeQuery(sql);

        List<User> users = new ArrayList<>();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            String userstatus=rs.getString("status");
            switch (userstatus){
                case "admin": { user.setStatus(UserStatus.ADMIN); break; }
                case "user": { user.setStatus(UserStatus.USER); break; }
                case "banned":{ user.setStatus(UserStatus.BANNED); break;}
                default: { break; }
            }
            users.add(user);
        }
        con.close();

        return users;
    }

    public void addUser(User user) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String host = "";
        String login = "";
        String password = "";
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(connectionFileName);
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");

        } catch (IOException e) {
            System.err.println("Error: File doesn't exist!");
        }

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String getLastBookingNumber = ("SELECT * FROM users ORDER BY id DESC LIMIT 1;");
        ResultSet rs = st.executeQuery(getLastBookingNumber);

        int lastUserId = 1;
        if(rs.next()){
            lastUserId = rs.getInt("id");
            lastUserId++;
        }

        String sql = "INSERT INTO users (id, name, email, password, status) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, lastUserId);
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getStatus().toString().toLowerCase());
        preparedStatement.executeUpdate();

        con.close();
    }
}
