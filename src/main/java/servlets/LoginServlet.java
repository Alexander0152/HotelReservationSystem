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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        UserService userService = new UserService();

        String email = request.getParameter("loginEmail");
        String password = request.getParameter("loginPassword");

        User checkUser = null;
        try {
            checkUser = userService.getUserByEmail(propertyFilepath, email);
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

        if(checkUser == null){
            errorMessage = "suchUserAlreadyExist";
            request.setAttribute("enterSystemErrorMessage", errorMessage);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

        //adding user:
        String userName = request.getParameter("loginName");

        User user = new User();
        user.setName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatus(UserStatus.USER);

        try {
            userService.addUser(propertyFilepath, user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/user.jsp");
        dispatcher.forward(request, response);
    }
}
