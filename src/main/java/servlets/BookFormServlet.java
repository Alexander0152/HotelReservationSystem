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
        double cost = Double.parseDouble(costString);
        session.setAttribute("priceForOneNight", cost);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/bookRoom.jsp");
        dispatcher.forward(request, response);
    }
}