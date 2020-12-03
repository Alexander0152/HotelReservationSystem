package servlets;

import businessLayer.Booking;
import businessLayer.Room;
import serviceLayer.BookingService;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

@WebServlet("/SearchRoomsServlet")
public class SearchRoomsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String propertyFilepath = "D:\\LABS_5_SEM\\OS_i_sist_progr\\CourseWork\\CourseWork\\resources\\connectionInfo.txt";

        RoomService roomService = new RoomService();
        HttpSession session = request.getSession();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar selectedDateIn = Calendar.getInstance();
        Calendar selectedDateOut = Calendar.getInstance();

        try {
            selectedDateIn.setTime(df.parse(request.getParameter("startDate")));
            selectedDateOut.setTime(df.parse(request.getParameter("endDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        session.setAttribute("startDate",request.getParameter("startDate"));
        session.setAttribute("endDate",request.getParameter("endDate"));

        long amountOfNightsInMiliseconds = selectedDateOut.getTimeInMillis() - selectedDateIn.getTimeInMillis();
        long amountOfNights = amountOfNightsInMiliseconds / (24 * 60 * 60 * 1000);
        session.setAttribute("amountOfNights", amountOfNights);
        int cost = Integer.parseInt(request.getParameter("amountOfAdults"));
        session.setAttribute("cost", amountOfNights);

        int amountOfAdults = Integer.parseInt(request.getParameter("amountOfAdults"));
        int amountOfChildren = Integer.parseInt(request.getParameter("amountOfChildren"));
        String type = request.getParameter("roomType");

        boolean separateRoom = false;
        if (request.getParameter("separateRoom") != null) {
            separateRoom = true;
        }

        session.setAttribute("amountOfAdults", amountOfAdults);
        session.setAttribute("amountOfChildren", amountOfChildren);
        session.setAttribute("roomType", type);
        session.setAttribute("separateRoom", separateRoom);

        List<Room> rooms = null;
        List<Room> matchedRooms = new ArrayList<>();

        if (type.compareTo("allTypes") == 0) {     //0-equal

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

            for (Room room : rooms) {
                int roomAmountOfChildren = room.getAmountOfChildren();
                int roomAmountOfAdults = room.getAmountOfAdults();

                if (amountOfChildren + amountOfAdults <= roomAmountOfAdults ||
                        (amountOfAdults <= roomAmountOfAdults && amountOfChildren <= roomAmountOfChildren)) {

                    matchedRooms.add(room);
                }
            }
        } else {
            try {
                rooms = roomService.getAllRoomsByType(propertyFilepath, type);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            for (Room room : rooms) {
                int roomAmountOfChildren = room.getAmountOfChildren();
                int roomAmountOfAdults = room.getAmountOfAdults();
                String roomType = room.getType();

                if (amountOfChildren + amountOfAdults <= roomAmountOfAdults ||
                        (amountOfAdults <= roomAmountOfAdults && amountOfChildren <= roomAmountOfChildren)) {

                    matchedRooms.add(room);
                }
            }
        }

        //check if they are already booked or free
        List<Room> availableRooms = new ArrayList<>();
        BookingService bookingService = new BookingService();
        List<Booking> bookings = null;

        for (Room room : matchedRooms) {

            try {
                bookings = bookingService.getAllBookingsByRoomNumber(propertyFilepath, room.getNumber());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            int amountByDay = amountOfAdults + amountOfChildren;

            boolean availability = true;
            while (selectedDateIn.before(selectedDateOut) || selectedDateIn.equals(selectedDateOut)) {

                for (Booking booking : bookings) {

                    Calendar alreadyBookedDateIn = Calendar.getInstance();
                    alreadyBookedDateIn.setTime(booking.getDateIn());
                    Calendar alreadyBookedDateOut = Calendar.getInstance();
                    alreadyBookedDateOut.setTime(booking.getDateOut());

                    if ((alreadyBookedDateIn.before(selectedDateIn) || alreadyBookedDateIn.equals(selectedDateIn)) &&
                            (alreadyBookedDateOut.after(selectedDateIn) || alreadyBookedDateOut.equals(selectedDateIn))) {

                        if (!separateRoom && !booking.getSeparate()) {
                            amountByDay += booking.getAmountOfAdults();
                        } else {
                            availability = false;
                            break;
                        }

                        if (amountByDay > room.getAmountOfAdults() || room.getType().compareTo("Economy family") == 0
                                || room.getType().compareTo("Lux family") == 0) {
                            availability = false;
                            break;
                        }
                    }
                }
                amountByDay = amountOfAdults + amountOfChildren;
                selectedDateIn.add(Calendar.DAY_OF_MONTH, 1);
            }
            if (availability) {
                availableRooms.add(room);
            }
            availability = true;
        }
        if (availableRooms.size() == 0) {

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user/noRoomsFound.jsp");
            dispatcher.forward(request, response);

        } else {
            //get unique rooms:
            List<Room> uniqueRooms = new ArrayList<>();
            Room firstUniqueRoom = availableRooms.get(0);
            uniqueRooms.add(firstUniqueRoom);

            boolean appearence = false;
            for (Room room : availableRooms) {
                for (Room uniqueRoom : uniqueRooms) {
                    if (uniqueRoom.getAmountOfAdults() == room.getAmountOfAdults() &&
                            uniqueRoom.getAmountOfChildren() == room.getAmountOfChildren() &&
                            uniqueRoom.getAmountOfRooms() == room.getAmountOfRooms() &&
                            uniqueRoom.getType().compareTo(room.getType()) == 0) {
                        appearence = true;
                        break;
                    }
                }
                if (!appearence) {
                    Room newRoom = room;
                    uniqueRooms.add(newRoom);
                }
                appearence = false;
            }


            for (Room room : uniqueRooms) {
                String roomType = room.getType();
                switch (roomType) {
                    case "Economy":
                        room.setImageSrc("images/Economy1.jpg");
                        break;
                    case "Economy family":
                        room.setImageSrc("images/Economy1.jpg");
                        break;
                    case "Lux":
                        room.setImageSrc("images/Lux.jpg");
                        break;
                    case "Lux family":
                        room.setImageSrc("images/Lux.jpg");
                        break;
                    case "Vip":
                        room.setImageSrc("images/Vip.jpg");
                        break;
                    case "President":
                        room.setImageSrc("images/President.jpg");
                        break;
                    default:
                        room.setImageSrc("images/Economy1.jpg");
                }
            }

            request.setAttribute("rooms", uniqueRooms);
            RequestDispatcher dispatcher = null;

            dispatcher = getServletContext().getRequestDispatcher("/user/searchRooms.jsp");
            dispatcher.forward(request, response);
        }
    }
}
