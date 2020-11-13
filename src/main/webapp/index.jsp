<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<%--    <script type="text/javascript" src="../javascript/jquery/search_jquery.ui.datepicker.js"></script>--%>
    <link rel="stylesheet" href="styleMain.css">
    <title>Main page</title>
</head>
<body>
<div id="navbarLogin">
    <a href="ViewRoomsServlet">Sign in</a>
    <a href="javascript:void(0)">Login</a>
</div>

<div class="header">
    <h1>Claverton</h1>
    <p>Hotel and restaurant</p>
</div>
<%--<div class="navbar">--%>
<%--    <a href="ViewRoomsServlet" style="text-decoration:none;">Rooms</a>--%>
<%--    <a href="#" style="text-decoration:none;">Link</a>--%>
<%--    <a href="#" style="text-decoration:none;">Link</a>--%>
<%--    <a href="#" class="right">Link</a>--%>
<%--</div>--%>
<div id="navbar">
    <a href="ViewRoomsServlet">Rooms</a>
    <a class="active" href="javascript:void(0)">Booking</a>
    <a href="javascript:void(0)">Contact</a>
</div>

<div class="main-page">
    <div class="options">
        <div class="app-title">
            <h1>Booking</h1>
        </div>

        <div class="userInfo-form">
            <h2>Gender</h2>
            <form action="Servlet" method="post">
                <input type="radio" id="gender" name="gender" value="Male"> Male<br>
                <input type="radio" id="gender" value="Female"> Female<br>
                <input type="radio" id="gender" value="Family"> Family

                <p></p>

                <label for="type">Room type</label>
                <select name="roomType" id="type">
                    <option class="comboboxRoomType" value="economy">Economy</option>
                    <option class="comboboxRoomType" value="lux">Lux</option>
                    <option class="comboboxRoomType" value="vip">Vip</option>
                    <option class="comboboxRoomType" value="president">President</option>
                </select>

                <p></p>

                <label for="type">Amount of persons</label>
                <select name="amountOfPersons" id="amountOfPersons">
                    <option class="comboboxRoomType" value="1">1</option>
                    <option class="comboboxRoomType" value="2">2</option>
                    <option class="comboboxRoomType" value="3">3</option>
                </select>

                <p></p>

                <label for="type">Amount of rooms</label>
                <select name="amountOfRooms" id="amountOfRooms">
                    <option class="comboboxRoomType" value="1">1</option>
                    <option class="comboboxRoomType" value="2">2</option>
                    <option class="comboboxRoomType" value="3">3</option>
                </select>

                <p></p>

                <label for="startDate">Check in</label>
                <input type="date" id="startDate" name="startDate" onSelect="getSelectedDate(startDate)">
<%--                       min="2020-11-11" max="2021-11-11">--%>

                <label for="endDate"> Check out</label>
                <input type="date" id="endDate" name="endDate">
<%--                <input type="submit" class="btn btn-primary btn-large btn-block" value="login">--%>
            </form>
            <form>
                <a class="login-link" href="ViewRoomsServlet">Show rooms</a>
            </form>
        </div>
    </div>
</div>
<script>
    window.onscroll = function() {myFunction()};
    var navbar = document.getElementById("navbar");
    var sticky = navbar.offsetTop;

    var startDate = document.getElementById("startDate");
    startDate.value = getTodayDate();
    startDate.setAttribute("min",startDate.value)

    var endDate = document.getElementById("endDate");
    endDate.value = getTodayDatePlusOneDay();
    endDate.setAttribute("min",endDate.value)

    function myFunction() {
        if (window.pageYOffset >= sticky) {
            navbar.classList.add("sticky");
        } else {
            navbar.classList.remove("sticky");
        }
    }

    function getTodayDate() {
        n =  new Date();
        y = n.getFullYear();
        m = n.getMonth() + 1;
        d = n.getDate();
        return y + "-" + d + "-" + m;
    }

    function getTodayDatePlusOneDay() {
        n =  new Date();
        n.setDate(n.getDate() + 1)
        y = n.getFullYear();
        m = n.getMonth() + 1;
        d = n.getDate();
        return y + "-" + d + "-" + m;
    }

    function getSelectedDate(selectedDate) {
        alert(selectedDate);
    }

    // function getSelectedDatePlusOneDay(id) {
    //     n =  new Date();
    //     n.setDate(n.getDate() + 1)
    //     y = n.getFullYear();
    //     m = n.getMonth() + 1;
    //     d = n.getDate();
    //     return y + "-" + d + "-" + m;
    // }
</script>
</body>
</html>