package servlets;

import businessLayer.Booking;
import businessLayer.Room;
import businessLayer.User;
import businessLayer.UserStatus;
import serviceLayer.RoomService;
import serviceLayer.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UsersSettingsServlet")
public class UsersSettingsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        UserService userService = new UserService();

        List<User> users = null;
        try {
            users = userService.getUserByStatus(propertyFilepath, UserStatus.USER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        request.setAttribute("customers", users);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/usersSettings.jsp");
        dispatcher.forward(request, response);
    }
}
