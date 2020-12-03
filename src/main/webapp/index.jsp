<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%--    <script type="text/javascript" src="../javascript/jquery/search_jquery.ui.datepicker.js"></script>--%>
    <link rel="stylesheet" href="styleMain.css">
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/momentjs/2.5.1/moment.js"></script>
    <script src="webjars/bootstrap/4.5.3/js/bootstrap.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css.map">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap-reboot.min.css.map">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min-jsf.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap-reboot.min-jsf.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap-grid.min-jsf.css">
    <title>Main page</title>
</head>
<body>
<jsp:include page="user/home.jsp"/>

<div id="navbar">
    <a href="ViewRoomsServlet">Rooms</a>
    <a class="active" href="javascript:void(0)">Booking</a>
    <a href="javascript:void(0)">Contact</a>
</div>

<div class="main-page">
    <div class="options p-5 text-center">
        <h3 class="font-weight-bold text-center">Booking</h3>
        <form action="SearchRoomsServlet" method="get" class="container font-weight-bold text-center">
            <form role="form">
                <div class="form-row">
                    <div class="form-group">
                        <label for="type">Adults</label>
                        <select class="form-control" name="amountOfAdults" id="amountOfAdults">
                            <option class="comboboxRoomType" value="1">1</option>
                            <option class="comboboxRoomType" value="2">2</option>
                            <option class="comboboxRoomType" value="3">3</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="type">Children</label>
                        <select class="form-control" name="amountOfChildren" id="amountOfChildren">
                            <option class="comboboxRoomType" value="0">0</option>
                            <option class="comboboxRoomType" value="1">1</option>
                            <option class="comboboxRoomType" value="2">2</option>
                            <option class="comboboxRoomType" value="3">3</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="type">Room type</label>
                        <select class="form-control" name="roomType" id="type" onchange="disableCheckbox()">
                            <option class="comboboxRoomType" value="allTypes">All types</option>
                            <option class="comboboxRoomType" value="Economy">Economy</option>
                            <option class="comboboxRoomType" value="Economy family">Economy family</option>
                            <option class="comboboxRoomType" value="Lux">Lux</option>
                            <option class="comboboxRoomType" value="Lux family">Lux family</option>
                            <option class="comboboxRoomType" value="Vip">Vip</option>
                            <option class="comboboxRoomType" value="President">President</option>
                        </select>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label" for="separateRoom">
                            <input class="form-control" type="checkbox" class="form-check-input" id="separateRoom"
                                   name="separateRoom"
                                   checked onchange="getCost()">
                            Separate room
                        </label>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="startDate">Check in</label>
                        <input class="form-control" type="date" id="startDate" name="startDate"
                               onchange="getSelectedDate();">
                    </div>
                    <div class="form-group">
                        <label for="endDate"> Check out</label>
                        <input class="form-control" type="date" id="endDate" name="endDate">
                    </div>
                </div>
                <button class="searchRoomsButton btn-primary" input type="submit" style="vertical-align:middle">
                    <span>Search rooms</span></button>
            </form>
        </form>
    </div>
</div>
<script>
    // Get the modal
    var modalSignIn = document.getElementById('SignInModal');
    var modalLogin = document.getElementById('LoginModal');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modalSignIn) {
            modalSignIn.style.display = "none";
        }
        if (event.target == modalLogin) {
            modalLogin.style.display = "none";
        }
    }

    window.onscroll = function () {
        myFunction()
    };
    var navbar = document.getElementById("navbar");
    var sticky = navbar.offsetTop;

    var startDate = document.getElementById("startDate");
    startDate.value = getTodayDate();
    startDate.setAttribute("min", startDate.value);

    var endDate = document.getElementById("endDate");
    endDate.value = getTodayDatePlusOneDay();
    endDate.setAttribute("min", endDate.value);

    function myFunction() {
        if (window.pageYOffset >= sticky) {
            navbar.classList.add("sticky");
        } else {
            navbar.classList.remove("sticky");
        }
    }

    function getTodayDate() {
        n = new Date();
        return moment(n).format('YYYY-MM-DD');
    }

    function getTodayDatePlusOneDay() {
        n = new Date();
        n.setDate(n.getDate() + 1)
        return moment(n).format('YYYY-MM-DD');
    }

    function getDatePlusOneDay(date) {
        n = new Date(date);
        n.setDate(n.getDate() + 1);
        return moment(n).format('YYYY-MM-DD');
    }

    function getSelectedDate() {
        var value = document.getElementById("startDate").value;
        endDate.setAttribute("min", getDatePlusOneDay(value));
        endDate.value = getDatePlusOneDay(value);
    }

    var roomType = document.getElementById("type");
    var separateRoom = document.getElementById("separateRoom");

    function disableCheckbox() {
        var selectIndex = roomType.selectedIndex;
        var selectValue = roomType.options[selectIndex].text;
        if (selectValue == "Economy family" || selectValue == "Lux family") {
            separateRoom.checked = "checked";
            separateRoom.hidden = true;
        } else separateRoom.hidden = false;
    }

</script>
</body>
</html>