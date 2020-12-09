package dataAccessLayer;

import businessLayer.Booking;
import businessLayer.Customer;
import businessLayer.User;
import businessLayer.UserStatus;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class CustomerDao {
    private String connectionFileName;

    public CustomerDao(String connectionFileName) {
        this.connectionFileName = connectionFileName;
    }

    public void addCustomer(Customer customer) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

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

        String getLasCustomerId = ("SELECT * FROM customers_info ORDER BY id DESC LIMIT 1;");
        ResultSet rs = st.executeQuery(getLasCustomerId);

        int lastCustomerId = 1;
        if (rs.next()) {
            lastCustomerId = rs.getInt("id");
            lastCustomerId++;
        }

        String sql = "INSERT INTO customers_info (id, first_name, last_name, country, city, email, contact_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, lastCustomerId);
        preparedStatement.setString(2, customer.getFirstName());
        preparedStatement.setString(3, customer.getLastName());
        preparedStatement.setString(4, customer.getCountry());
        preparedStatement.setString(5, customer.getCity());
        preparedStatement.setString(6, customer.getEmail());
        preparedStatement.setString(7, customer.getContactNumber());

        preparedStatement.executeUpdate();

        con.close();
    }

    public Customer getCustomerByName(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

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

        String delimeter = " "; // Разделитель
        String[] subStr = name.split(delimeter);
        String firsName = subStr[0];
        String lastName = subStr[1];

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String sql = String.format("SELECT* FROM customers_info WHERE first_name = '%s' AND last_name = '%s' ;", firsName, lastName);
        ResultSet rs = st.executeQuery(sql);

        Customer customer = new Customer();
        while (rs.next()) {

            customer.setId(Integer.parseInt(rs.getString("id")));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setCountry(rs.getString("country"));
            customer.setCity(rs.getString("city"));
            customer.setEmail(rs.getString("email"));
            customer.setContactNumber(rs.getString("contact_number"));
        }

        con.close();
        return customer;
    }
}
