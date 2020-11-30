<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%--    <script type="text/javascript" src="../javascript/jquery/search_jquery.ui.datepicker.js"></script>--%>
    <link rel="stylesheet" href="styleMain.css">
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/momentjs/2.5.1/moment.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main page</title>
</head>
<body>
<jsp:include page="../index.jsp"/>
<div class="view_content">
    <table class="table-bordered border-dark">
        <thead>
        <tr class="border-dark">
            <td class="border-dark">Room</td>
            <td class="border-dark">Amount of Persons</td>
            <td class="border-dark">Amount of Children</td>
            <td class="border-dark">Amount of rooms</td>
            <td class="border-dark">Type</td>
            <td class="border-dark">USD/Night</td>
            <td class="border-dark"></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${rooms}">
            <tr>
                <td class="border-dark"><img src='${item.imageSrc}' width="150" height="110"></td>
                <td class="border-dark">${item.amountOfAdults}</td>
                <td class="border-dark">${item.amountOfChildren}</td>
                <td class="border-dark">${item.amountOfRooms}</td>
                <td class="border-dark">${item.type}</td>
                <td class="border-dark">${item.priceForOneNight}</td>
                <td class="border-dark">
                    <form action="BookFormServlet" method="get">
                        <input type="date" id="endDate" name="endDate" hidden>
                        <input type="hidden" id="priceForOneNight" name="priceForOneNight" value="${item.priceForOneNight}">
                        <input type="hidden" id="roomNumber" name="roomNumber" value="${item.number}">
                        <input type="submit" value="Book" class="button">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
