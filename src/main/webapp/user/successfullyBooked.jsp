<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/28/2020
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    </head>
    <title>Success</title>
</head>
<body style="background-image: url('images/notebook.jpg')">
<jsp:include page="home.jsp"/>
<div id="navbar">
    <a href="ViewRoomsServlet">Rooms</a>
    <a class="active" href="index.jsp">Booking</a>
    <a href="javascript:void(0)">Contact</a>
</div>
<div class="container p-lg-5 text-center font-weight-bold text-success" style="background-color: rgba(255,255,255,0.9)">
    <h3>The room booked successfully!</h3>
</div>
</body>
</html>
