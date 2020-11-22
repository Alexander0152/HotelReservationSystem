package dataAccessLayer;

import businessLayer.Booking;
import businessLayer.Room;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookingDao {
    private String connectionFileName;

    public BookingDao(String connectionFileName) {
        this.connectionFileName = connectionFileName;
    }

    public List<Booking> getAllBookings() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

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

        List<Booking> bookings = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String sql = ("SELECT * FROM reserved");
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Booking booking = new Booking();

            booking.setId(Integer.parseInt(rs.getString("id")));
            booking.setRoomNumber(rs.getInt("room_number"));
            booking.setCustomerName(rs.getString("customer_name"));
            booking.setDateIn(rs.getDate("date_in"));
            booking.setDateOut(rs.getDate("date_out"));
            booking.setSeparate(rs.getBoolean("date_out"));

            bookings.add(booking);
        }
        con.close();

        return bookings;
    }

    public List<Booking> getAllBookingsByRoomNumber(int number) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

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

        List<Booking> bookings = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String sql = String.format("SELECT* FROM reserved WHERE room_number = %d;", number);
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Booking booking = new Booking();

            booking.setId(Integer.parseInt(rs.getString("id")));
            booking.setRoomNumber(rs.getInt("room_number"));
            booking.setCustomerName(rs.getString("customer_name"));
            booking.setDateIn(rs.getDate("date_in"));
            booking.setDateOut(rs.getDate("date_out"));
            booking.setSeparate(rs.getBoolean("separate_room"));
            booking.setAmountOfAdults(rs.getInt("amount_of_adults"));
            booking.setAmountOfChildren(rs.getInt("amount_of_children"));

            bookings.add(booking);
        }
        con.close();

        return bookings;
    }
}
