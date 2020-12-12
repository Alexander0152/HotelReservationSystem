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

    public List<Booking> getAllBookingsByRoomNumber(String filePath, int number) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        BookingDao dao = new BookingDao(filePath);
        return dao.getAllBookingsByRoomNumber(number);
    }

    public void addBooking(String filePath, Booking newBoooking) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        BookingDao dao = new BookingDao(filePath);
        dao.addBooking(newBoooking);
    }

    public void addOptionalPreferences(String filePath, Booking newBoooking) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        BookingDao dao = new BookingDao(filePath);
        dao.addOptionalPreferences(newBoooking);
    }

    public void removeBooking(String filePath, int bookingNumber) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        BookingDao dao = new BookingDao(filePath);
        dao.removeBooking(bookingNumber);
    }

}
