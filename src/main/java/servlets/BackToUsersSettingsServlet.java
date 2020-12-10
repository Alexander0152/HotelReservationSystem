package servlets;

import businessLayer.Room;
import serviceLayer.RoomService;
import serviceLayer.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BackToUsersSettingsServlet")
public class BackToUsersSettingsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        UserService userService = new UserService();

        List<Room> rooms = new ArrayList<>();
        RoomService roomService = new RoomService();
        try {
            rooms = roomService.getAllExistingRooms(propertyFilepath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        request.setAttribute("allRooms", rooms);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/roomsSettings.jsp");
        dispatcher.forward(request, response);
    }
}
