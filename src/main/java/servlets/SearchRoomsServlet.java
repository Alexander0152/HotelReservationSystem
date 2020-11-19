package servlets;

import businessLayer.Room;
import serviceLayer.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/SearchRoomsServlet")
public class SearchRoomsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RoomService roomService = new RoomService();
        HttpSession session=request.getSession();

        List<Room> rooms = null;
        try {
            rooms = roomService.getAllRooms("D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        request.setAttribute("rooms",rooms);
        RequestDispatcher dispatcher=null;

        dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
