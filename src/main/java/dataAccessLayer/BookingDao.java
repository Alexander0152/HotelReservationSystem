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

    public void addBooking(Booking booking) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
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
        String getLastBookingNumber = ("SELECT * FROM reserved ORDER BY id DESC LIMIT 1;");
        ResultSet rs = st.executeQuery(getLastBookingNumber);

        int lastBookingNumber = 1;
        int lastBookingId = 1;
        if(rs.next()){
            lastBookingNumber = rs.getInt("booking_number");
            lastBookingId = rs.getInt("id");
            lastBookingNumber++;
            lastBookingId++;
        }

        String sql = "INSERT INTO reserved (id, room_number, customer_name, date_in, date_out, separate_room, amount_of_adults, amount_of_children," +
                "booking_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, lastBookingId);
        preparedStatement.setInt(2, booking.getRoomNumber());
        preparedStatement.setString(3, booking.getCustomerName());
        preparedStatement.setDate(4, (Date) booking.getDateIn());
        preparedStatement.setDate(5, (Date) booking.getDateOut());
        preparedStatement.setBoolean(6, booking.getSeparate());
        preparedStatement.setInt(7, booking.getAmountOfAdults());
        preparedStatement.setInt(8, booking.getAmountOfChildren());
        preparedStatement.setInt(9,lastBookingNumber);
        preparedStatement.executeUpdate();

        con.close();
    }

    public void addOptionalPreferences(Booking booking) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
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
        String getLastBookingNumber = ("SELECT * FROM optionals ORDER BY id DESC LIMIT 1;");
        ResultSet rs = st.executeQuery(getLastBookingNumber);

        int lastBookingNumber = 1;
        int lastBookingId = 1;
        if(rs.next()){
            lastBookingNumber = rs.getInt("booking_number");
            lastBookingId = rs.getInt("id");
            lastBookingNumber++;
            lastBookingId++;
        }

        String sql = "INSERT INTO optionals (id, breakfasts, all_inclusive, champagne, booking_number) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, lastBookingId);
        preparedStatement.setBoolean(2, booking.getBreakfasts());
        preparedStatement.setBoolean(3, booking.getAllInclusive());
        preparedStatement.setBoolean(4, booking.getChampagne());
        preparedStatement.setInt(5,lastBookingNumber);
        preparedStatement.executeUpdate();

        con.close();
    }
}
