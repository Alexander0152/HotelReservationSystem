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

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        HttpSession session = request.getSession();

        UserService userService = new UserService();


        String email = request.getParameter("signInEmail");
        String password = request.getParameter("signInPassword");

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

        String errorMessage = new String();

        if (user.getEmail() == null) {
            errorMessage = "noSuchUser";
            request.setAttribute("enterSystemErrorMessage", errorMessage);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

        if (user.getPassword().compareTo(password) == 0) {     //0-equal
            UserStatus status = user.getStatus();

            if (status == UserStatus.ADMIN || status == UserStatus.EMPLOYEE) {

                session.setAttribute("status", UserStatus.ADMIN);
                if(status == UserStatus.EMPLOYEE) {
                    session.setAttribute("status", UserStatus.EMPLOYEE);
                }

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
            if (status == UserStatus.USER) {
                session.setAttribute("status", UserStatus.USER);

                String customerName = user.getName();

                BookingService bookingService = new BookingService();

                List<Booking> bookingList = null;
                try {
                    bookingList = bookingService.getAllBookingsByCustomerName(propertyFilepath, customerName);
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
                request.setAttribute("userName", customerName);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/user.jsp");
                dispatcher.forward(request, response);
            }
            if (status == UserStatus.BANNED) {
                errorMessage = "ban";
                request.setAttribute("enterSystemErrorMessage", errorMessage);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            errorMessage = "wrongSignInPassword";
            request.setAttribute("enterSystemErrorMessage", errorMessage);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
