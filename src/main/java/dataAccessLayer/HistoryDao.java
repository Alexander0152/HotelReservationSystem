package dataAccessLayer;

import businessLayer.Booking;
import businessLayer.History;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HistoryDao {
    private String connectionFileName;

    public HistoryDao(String connectionFileName) {
        this.connectionFileName = connectionFileName;
    }

    public List<History> getAllHistory() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

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

        List<History> historyList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String sql = ("SELECT * FROM history");
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            History history = new History();

            history.setRoomNumber(rs.getInt("room_number"));
            history.setCustomerName(rs.getString("customer_name"));
            history.setCustomerEmail(rs.getString("customer_email"));
            history.setContactNumber(rs.getString("contact_number"));
            history.setDateIn(rs.getDate("date_in"));
            history.setDateOut(rs.getDate("date_out"));;

            historyList.add(history);
        }
        con.close();

        return historyList;
    }

    public void addBookingToHistory(History history) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
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
        String getLastBookingNumber = ("SELECT * FROM history ORDER BY id DESC LIMIT 1;");
        ResultSet rs = st.executeQuery(getLastBookingNumber);

        int lastHistoryId = 1;
        if (rs.next()) {
            lastHistoryId = rs.getInt("id");
            lastHistoryId++;
        }

        String sql = "INSERT INTO history (id, room_number, customer_name, customer_email, contact_number, date_in, date_out)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, lastHistoryId);
        preparedStatement.setInt(2, history.getRoomNumber());
        preparedStatement.setString(3, history.getCustomerName());
        preparedStatement.setString(4, history.getCustomerEmail());
        preparedStatement.setString(5, history.getContactNumber());
        preparedStatement.setDate(6, (Date) history.getDateIn());
        preparedStatement.setDate(7, (Date) history.getDateOut());

        preparedStatement.executeUpdate();

        con.close();
    }

    public void removeBookingFromHistory(String userName, String dateIn, String dateOut) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
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

        String delete = String.format("DELETE FROM history WHERE customer_name = '%s' AND date_in = '%s' AND date_out = '%s';", userName,
                dateIn, dateOut);

        PreparedStatement preparedStatement = con.prepareStatement(delete);
        preparedStatement.executeUpdate();

        con.close();
    }
}
