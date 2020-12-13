package servlets;

import businessLayer.User;
import businessLayer.UserStatus;
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

@WebServlet("/MakeUserAnEmployeeServlet")
public class MakeUserAnEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        String userEmail = request.getParameter("userEmail");

        UserService userService  = new UserService();
        try {
            userService.changeUserStatus(propertyFilepath, userEmail, UserStatus.EMPLOYEE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

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
