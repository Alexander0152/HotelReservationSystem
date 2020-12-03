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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowInfoAboutRoomServlet")
public class ShowInfoAboutRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));

        BookingService bookingService = new BookingService();

        List<Booking> bookingList = null;
        try {
            bookingList = bookingService.getAllBookingsByRoomNumber(propertyFilepath, roomNumber);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for (Booking booking:bookingList){
            String allInclusive = new String();
            String breakfasts = new String();
            String champagne = new String();
            if(booking.getAllInclusive()){
                allInclusive = "All inclusive";
            }
            if(booking.getBreakfasts()){
                breakfasts = "Breakfasts";
            }
            if(booking.getChampagne()){
                champagne = "Champagne and chocolate";
            }

            String optionals = new String(allInclusive + breakfasts + "\n" + champagne);
            booking.setOptionals(optionals);
        }
        request.setAttribute("bookingList", bookingList);
        request.setAttribute("currentRoomNumber", roomNumber);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/roomInfo.jsp");
        dispatcher.forward(request, response);
    }

}
