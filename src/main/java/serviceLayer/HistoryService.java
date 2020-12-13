package serviceLayer;

import businessLayer.Booking;
import businessLayer.History;
import dataAccessLayer.BookingDao;
import dataAccessLayer.HistoryDao;

import java.sql.SQLException;
import java.util.List;

public class HistoryService {

    public List<History> getAllHistory(String filePath) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        HistoryDao dao = new HistoryDao(filePath);
        return dao.getAllHistory();
    }

    public void addBookingToHistory(String filePath, History history) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        HistoryDao dao = new HistoryDao(filePath);
        dao.addBookingToHistory(history);
    }

    public void removeBookingFromHistory(String filePath, String name, String dateIn, String dateOut) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        HistoryDao dao = new HistoryDao(filePath);
        dao.removeBookingFromHistory(name, dateIn, dateOut);
    }
}
