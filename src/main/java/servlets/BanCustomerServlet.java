package servlets;

import businessLayer.Booking;
import businessLayer.UserStatus;
import serviceLayer.BookingService;
import serviceLayer.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/BanCustomerServlet")
public class BanCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        int bookingNumber = Integer.parseInt(request.getParameter("banBookingNumber"));
        String userName = request.getParameter("banCustomerName");

        UserService userService  = new UserService();
        try {
            userService.changeUserStatus(propertyFilepath, userName, UserStatus.BANNED);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/roomInfo.jsp");
        dispatcher.forward(request, response);

    }
}
