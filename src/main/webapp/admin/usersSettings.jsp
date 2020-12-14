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
    <title>Customers settings</title>
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
    <a class="active" href="ViewRoomsServlet">Users</a>
    <a href="BackToRoomsSettingsServlet">Rooms</a>
    <a href="EmployeesSettingsServlet">Employees</a>
    <a href="HistoryServlet">History</a>
</div>
<div class="container" style="background-color: rgba(255,255,255,0.98)">
    <div class="table-responsive">
        <h5 class="font-weight-bold text-center">Customers</h5><br>
        <input class="form-control" type="text" placeholder="Enter user name" id="search-text" onkeyup="tableSearch()">
        <table class="table table-striped table-bordered text-center border-dark" id="info-table">
            <thead>
            <tr class="border-dark">
                <td class="border-dark">User name</td>
                <td class="border-dark">User email</td>
                <td class="border-dark"></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${customers}">
                <tr>
                    <td class="border-dark">${item.name}</td>
                    <td class="border-dark">${item.email}</td>
                    <td class="border-dark">
                        <form action="BanCustomerServlet" method="post">
                            <input type="hidden" id="email" name="email" value="${item.email}">
                            <button value="Ban" id="btnBan" class="button btn-primary btn-sm font-weight-bold">Ban user
                            </button>
                        </form>
                        <form action="MakeUserAnEmployeeServlet" method="post">
                            <input type="hidden" id="userEmail" name="userEmail" value="${item.email}">
                            <button value="Ban" id="btnMakeEmployee" class="button btn-primary btn-sm font-weight-bold">
                                Make an employee
                            </button>
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
