package serviceLayer;

import businessLayer.Booking;
import businessLayer.Room;
import dataAccessLayer.RoomDao;

import java.sql.SQLException;
import java.util.*;

public class RoomService {

    public List<Room> getAllExistingRooms(String filePath) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        RoomDao dao = new RoomDao(filePath);
        return dao.getAllExistingRooms();
    }

    public List<Room> getAllRoomsByType(String filePath, String type) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        RoomDao dao = new RoomDao(filePath);
        return dao.getAllRoomsByType(type);
    }
}
