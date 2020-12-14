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
    <title>Contacts</title>
</head>
<body>
<jsp:include page="home.jsp"/>

<div id="navbar">
    <a href="ViewRoomsServlet">Rooms</a>
    <a href="index.jsp">Booking</a>
    <a class="active" href="javascript:void(0)">Contact</a>
</div>
<div class="container" style="background-color: rgba(255,255,255,0.9)">
    <div class="row">
        <div class="container w-50 p-3">
            <h3>
                +375 (17) 209-90-62
            </h3>
            <h3>
                +375 (17) 209-90-74
            </h3><br>
            <h3>
                clavertonhotel@gmail.com
            </h3>
        </div>
    </div>
</div>
</body>
</html>