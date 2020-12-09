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
    <title>Customer info</title>
</head>
<body style="background-image: url('images/gears.jpg')">
<div id="navbarLogin">
    <a style="display: block" style="width:auto;">Admin</a>
</div>

<div class="header">
    <h1>Claverton</h1>
    <p>Hotel and restaurant</p>
</div>
<div id="navbar">
    <a href="CustomersSettingsServlet">Customers</a>
    <a class="active" href="javascript:void(0)">Rooms</a>
    <a href="AdminsSettingsServlet">Admins</a>
</div>
<div class="container" style="background-color: rgba(255,255,255,0.98)">
    <div class="table-responsive">
        <h5 class="font-weight-bold text-center">${customer.firstName} ${customer.lastName}</h5><br>
        <table class="table table-striped table-bordered text-center border-dark">
            <thead>
            <tr class="border-dark">
                <td class="border-dark">First name</td>
                <td class="border-dark">Last name</td>
                <td class="border-dark">Country</td>
                <td class="border-dark">City/State/Province</td>
                <td class="border-dark">Email</td>
                <td class="border-dark">Contact number</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="border-dark">${customer.firstName}</td>
                <td class="border-dark">${customer.lastName}</td>
                <td class="border-dark">${customer.country}</td>
                <td class="border-dark">${customer.city}</td>
                <td class="border-dark">${customer.email}</td>
                <td class="border-dark">${customer.contactNumber}</td>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
