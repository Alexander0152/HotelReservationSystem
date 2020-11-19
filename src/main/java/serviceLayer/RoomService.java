package serviceLayer;

import businessLayer.Room;
import dataAccessLayer.RoomDao;

import java.sql.SQLException;
import java.util.*;

public class RoomService {

    public List<Room> roomList;

    public List<Room> getAllRooms(String filePath) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        RoomDao dao = new RoomDao(filePath);
        return dao.getRooms();
    }

    public List<Room> finedRooomsByСriterias(List<Room> list) {
        List<Room> roomList = new ArrayList<>();
        for(Room book: list){


        }
        return roomList;
    }
}
