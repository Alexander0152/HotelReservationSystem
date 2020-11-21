package serviceLayer;

import businessLayer.Booking;
import businessLayer.Room;
import dataAccessLayer.BookingDao;
import dataAccessLayer.RoomDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    public List<Room> roomList;

    public List<Booking> getAllBookings(String filePath) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        BookingDao dao = new BookingDao(filePath);
        return dao.getAllBookings();
    }

}
