package servlets;

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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

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

            if (status == UserStatus.ADMIN) {

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
                request.setAttribute("userPageName", user.getName());
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
