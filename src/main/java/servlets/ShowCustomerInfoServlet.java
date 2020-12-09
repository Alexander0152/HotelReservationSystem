package servlets;

import businessLayer.*;
import serviceLayer.BookingService;
import serviceLayer.CustomerService;
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

@WebServlet("/ShowCustomerInfoServlet")
public class ShowCustomerInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        String customerName = request.getParameter("customerName");

        CustomerService customerService = new CustomerService();

        Customer customer = new Customer();
        try {
            customer = customerService.getCustomerByName(propertyFilepath, customerName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        request.setAttribute("customer", customer);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/customerInfo.jsp");
        dispatcher.forward(request, response);
    }

}
