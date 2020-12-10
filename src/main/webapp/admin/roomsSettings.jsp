<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
    <title>Rooms settings</title>
</head>
<body style="background-image: url('images/gears.jpg')">
<div id="navbarLogin">
    <a style="text-align: center;">Admin</a>
    <a href="ExitAdminServlet" style="width:auto;">Exit</a>
</div>

<div class="header">
    <h1>Claverton</h1>
    <p>Hotel and restaurant</p>
</div>
<div id="navbar">
    <a href="UsersSettingsServlet">Users</a>
    <a class="active" href="javascript:void(0)">Rooms</a>
    <a href="AdminsSettingsServlet">Admins</a>
</div>
<div class="container" style="background-color: rgba(255,255,255,0.98)">
    <div class="table-responsive">
        <h5 class="font-weight-bold text-center">Rooms</h5><br>
        <input class="form-control" type="text" placeholder="Enter room number" id="search-text" onkeyup="tableSearch()">
        <table class="table table-striped table-bordered text-center border-dark" id="info-table">
            <thead>
            <tr class="border-dark">
                <td class="border-dark">Room number</td>
                <td class="border-dark">Amount of Persons</td>
                <td class="border-dark">Amount of Children</td>
                <td class="border-dark">Amount of rooms</td>
                <td class="border-dark">Type</td>
                <td class="border-dark">USD/Night</td>
                <td class="border-dark"></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${allRooms}">
                <tr>
                    <td class="border-dark">${item.number}</td>
                    <td class="border-dark">${item.amountOfAdults}</td>
                    <td class="border-dark">${item.amountOfChildren}</td>
                    <td class="border-dark">${item.amountOfRooms}</td>
                    <td class="border-dark">${item.type}</td>
                    <td class="border-dark">${item.priceForOneNight}</td>
                    <td class="border-dark">
                        <form action="ShowInfoAboutRoomServlet" method="post">
                            <input type="hidden" id="roomNumber" name="roomNumber" value="${item.number}">
                            <button value="ShowInfo" class="button btn-primary btn-sm font-weight-bold">Show info</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function tableSearch() {
        var phrase = document.getElementById('search-text');
        var table = document.getElementById('info-table');
        var regPhrase = new RegExp(phrase.value, 'i');
        var flag = false;
        for (var i = 1; i < table.rows.length; i++) {
            flag = false;
            for (var j = table.rows[i].cells.length - 1; j >= 0; j--) {
                flag = regPhrase.test(table.rows[i].cells[j].innerHTML);
                if (flag) break;
            }
            if (flag) {
                table.rows[i].style.display = "";
            } else {
                table.rows[i].style.display = "none";
            }

        }
    }
</script>
</body>
</html>
