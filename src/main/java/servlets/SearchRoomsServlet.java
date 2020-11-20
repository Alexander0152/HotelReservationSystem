package servlets;

import businessLayer.Room;
import serviceLayer.RoomService;

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

@WebServlet("/SearchRoomsServlet")
public class SearchRoomsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RoomService roomService = new RoomService();
        HttpSession session=request.getSession();

        List<Room> rooms = null;
        try {
            rooms = roomService.getAllRooms("D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int amountOfAdults = Integer.parseInt(request.getParameter("amountOfAdults"));
        int amountOfChildren = Integer.parseInt(request.getParameter("amountOfChildren"));
        String type = request.getParameter("roomType");
        String separateRoom = request.getParameter("separateRoom");

        List<Room> matchedRooms = new ArrayList<>();

        if(type.compareTo("allTypes") == 0){

            for(Room room:rooms){
                int roomAmountOfChildren = room.getAmountOfChildren();
                int roomAmountOfAdults = room.getAmountOfAdults();

                if(amountOfChildren + amountOfAdults <= roomAmountOfAdults ||
                        (amountOfAdults <= roomAmountOfAdults && amountOfChildren <= roomAmountOfChildren)){

                    matchedRooms.add(room);
                }
            }
        }
        else{
            for(Room room:rooms){
                int roomAmountOfChildren = room.getAmountOfChildren();
                int roomAmountOfAdults = room.getAmountOfAdults();
                String roomType = room.getType();

                if(roomType.compareTo(type) == 0) {
                    if(amountOfChildren + amountOfAdults <= roomAmountOfAdults ||
                            (amountOfAdults <= roomAmountOfAdults && amountOfChildren <= roomAmountOfChildren)){

                        matchedRooms.add(room);
                    }
                }
            }
        }
                                //get unique rooms:
        List<Room> uniqueRooms = new ArrayList<>();
        Room firstUniqueRoom = matchedRooms.get(0);
        uniqueRooms.add(firstUniqueRoom);

        boolean appearence = false;
        for(Room room:matchedRooms){
            for(Room uniqueRoom:uniqueRooms) {
                if (uniqueRoom.getAmountOfAdults() == room.getAmountOfAdults() &&
                        uniqueRoom.getAmountOfChildren() == room.getAmountOfChildren() &&
                        uniqueRoom.getAmountOfRooms() == room.getAmountOfRooms() &&
                        uniqueRoom.getType().compareTo(room.getType()) == 0) {
                    appearence = true;
                    break;
                }
            }
            if(!appearence){
                Room newRoom = room;
                uniqueRooms.add(newRoom);
            }
            appearence = false;
        }

        request.setAttribute("rooms",uniqueRooms);
        RequestDispatcher dispatcher=null;

        dispatcher = getServletContext().getRequestDispatcher("/user/searchRooms.jsp");
        dispatcher.forward(request, response);
    }
}
