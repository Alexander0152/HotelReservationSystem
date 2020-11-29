package servlets;

import serviceLayer.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/BookFormServlet")
public class BookFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String costString = request.getParameter("priceForOneNight");
        String roomNumberString = request.getParameter("roomNumber");
        double cost = Double.parseDouble(costString);
        int roomNumber = Integer.parseInt(roomNumberString);

        session.setAttribute("priceForOneNight", cost);
        session.setAttribute("roomNumber", roomNumber);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/bookRoom.jsp");
        dispatcher.forward(request, response);
    }
}