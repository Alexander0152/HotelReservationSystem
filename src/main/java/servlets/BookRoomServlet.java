package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/successfullyBooked.jsp");
        dispatcher.forward(request, response);

        String amountOfAdults = request.getParameter("fname");
        String amountOfChildren = request.getParameter("breakfasts");

        String type = request.getParameter("roomType");
    }
}
