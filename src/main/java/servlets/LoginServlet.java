package servlets;

import businessLayer.Booking;
import businessLayer.Room;
import businessLayer.User;
import businessLayer.UserStatus;
import serviceLayer.BookingService;
import serviceLayer.RoomService;
import serviceLayer.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        UserService userService = new UserService();


        String email = request.getParameter("loginEmail");
        String password = request.getParameter("loginPassword");

        User user = null;
        try {
            user = userService.getUserByEmail(propertyFilepath, email);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (user.getPassword().compareTo(password) == 0) {     //0-equal
            UserStatus status = user.getStatus();

            if(status == UserStatus.ADMIN){

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
            if(status == UserStatus.USER){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/user.jsp");
                dispatcher.forward(request, response);
            }
            if(status == UserStatus.BANNED){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/user.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
