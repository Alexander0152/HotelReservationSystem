package serviceLayer;

import businessLayer.Booking;
import businessLayer.User;
import dataAccessLayer.BookingDao;
import dataAccessLayer.UserDao;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public User getUserByEmail(String filePath, String email) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        UserDao dao = new UserDao(filePath);
        return dao.getUserByEmail(email);
    }

    public void addUser(String filePath, User user) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        UserDao dao = new UserDao(filePath);
        dao.addUser(user);
    }
}
