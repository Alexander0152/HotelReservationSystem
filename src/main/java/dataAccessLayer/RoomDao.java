package dataAccessLayer;

import businessLayer.Room;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RoomDao {

    private String connectionFileName;

    public RoomDao(String connectionFileName) {
        this.connectionFileName = connectionFileName;
    }

    public List<Room> getAllExistingRooms() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

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

        List<Room> rooms = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String sql = ("SELECT * FROM rooms");
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Room room = new Room();

            room.setId(Integer.parseInt(rs.getString("id")));
            room.setNumber(rs.getInt("number"));
            room.setAmountOfAdults(rs.getInt("amount_of_adults"));
            room.setAmountOfChildren(rs.getInt("amount_of_children"));
            room.setAmountOfRooms(rs.getInt("amount_of_rooms"));
            room.setType(rs.getString("type"));
            room.setPriceForOneNight(rs.getDouble("price_for_one_night"));

            rooms.add(room);
        }
        con.close();
//        return (ArrayList<Room>) rooms;
        return rooms;
    }

    public List<Room> getAllRoomsByType(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

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

        List<Room> rooms = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(host, login, password);

        Statement st = con.createStatement();
        String sql = String.format("SELECT* FROM rooms WHERE type = '%s';", type);
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Room room = new Room();

            room.setId(Integer.parseInt(rs.getString("id")));
            room.setNumber(rs.getInt("number"));
            room.setAmountOfAdults(rs.getInt("amount_of_adults"));
            room.setAmountOfChildren(rs.getInt("amount_of_children"));
            room.setAmountOfRooms(rs.getInt("amount_of_rooms"));
            room.setType(rs.getString("type"));
            room.setPriceForOneNight(rs.getDouble("price_for_one_night"));

            rooms.add(room);
        }
        con.close();

        return rooms;
    }

}