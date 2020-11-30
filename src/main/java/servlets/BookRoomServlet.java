package servlets;

import businessLayer.Booking;
import serviceLayer.BookingService;
import serviceLayer.RoomService;

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

@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        BookingService bookingService = new BookingService();

        Booking newBooking = new Booking();

        int roomNumber = (Integer)session.getAttribute("roomNumber");
        String customerFirstName = request.getParameter("fname");
        String customerLastName = request.getParameter("lname");
        String customerFullName = customerFirstName + " "+ customerLastName;
        Date dateIn = Date.valueOf((String) session.getAttribute("startDate"));
        Date dateOut = Date.valueOf((String) session.getAttribute("endDate"));

        Boolean separateRoom = (Boolean) session.getAttribute("separateRoom");
        int amountOfAdults = (Integer)session.getAttribute("amountOfAdults");
        int amountOfChildren = (Integer)session.getAttribute("amountOfChildren");

        newBooking.setAllinclusive(false);
        newBooking.setBreakfasts(false);
        newBooking.setChampagne(false);
        String meals = request.getParameter("meals");
        switch (meals){
            case("allInclusive"):
                newBooking.setAllinclusive(true);
                break;
            case("breakfasts"):
                newBooking.setBreakfasts(true);
                break;
        }
        if(request.getParameter("champagne") != null){
            newBooking.setChampagne(true);
        }
        double totalCost = Double.parseDouble(request.getParameter("totalCost"));

        newBooking.setRoomNumber(roomNumber);
        newBooking.setCustomerName(customerFullName);
        newBooking.setDateIn(dateIn);
        newBooking.setDateOut(dateOut);
        newBooking.setSeparate(separateRoom);
        newBooking.setAmountOfAdults(amountOfAdults);
        newBooking.setAmountOfChildren(amountOfChildren);
        newBooking.setTotalCost(totalCost);

        try {
            bookingService.addBooking(propertyFilepath, newBooking);
            bookingService.addOptionalPreferences(propertyFilepath, newBooking);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/successfullyBooked.jsp");
        dispatcher.forward(request, response);
    }
}
