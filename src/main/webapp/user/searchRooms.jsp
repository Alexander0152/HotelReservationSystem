<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page isELIgnored ="false" %>
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
    <table>
        <caption>Rooms</caption>
        <thead>
        <tr>
            <td>id</td>
            <td>number</td>
            <td>type</td>
            <td>price</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${rooms}}">
            <tr>
                <td><img src="images/Economy1.jpg" width="150" height="110"></td>
                <td>Type</td>
                <td>Amount of rooms</td>
                <td>80$</td>
                <td>
                    <form action="TakeBookServlet">
                        <input type="submit" value="Take book" class="button">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
