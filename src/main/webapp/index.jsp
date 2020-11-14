<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<%--    <script type="text/javascript" src="../javascript/jquery/search_jquery.ui.datepicker.js"></script>--%>
    <link rel="stylesheet" href="styleMain.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main page</title>
</head>
<body>
<div id="navbarLogin">
    <a onclick="document.getElementById('LoginModal').style.display='block'" style="width:auto;">Login</a>
    <a onclick="document.getElementById('SignInModal').style.display='block'" style="width:auto;">Sign in</a>
</div>

<div class="header">
    <h1>Claverton</h1>
    <p>Hotel and restaurant</p>
</div>

<div id="SignInModal" class="modal">

    <form class="modal-content animate" action="/action_page.php" method="post">
        <div class="imgcontainer">
            <span onclick="document.getElementById('SignInModal').style.display='none'" class="closeSigInButton" title="Close Modal">&times;</span>
            <img src="images/loginPicture.png" alt="Avatar" class="avatar">
        </div>

        <div class="container">
            <label for="uname" style="display: block; text-align: center;"><b>Name</b></label>
            <input type="text" placeholder="Enter Username" name="uname" required>

            <label for="psw" style="display: block; text-align: center;"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>
            <button type="submit" style="  background-color: orange; color: purple; padding: 14px 20px;
             margin: 8px 0; border: none; cursor: pointer; font-size: 17px; font-weight: bold;
              width: 100%;">Sign in</button>

            <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
    </form>
</div>

<%--<button onclick="document.getElementById('LoginModal').style.display='block'" style="width:auto;">Sign Up</button>--%>

<div id="LoginModal" class="modal">
    <form class="modal-content animate" action="/action_page.php" method="post">
        <div class="imgcontainer">
            <span onclick="document.getElementById('LoginModal').style.display='none'" class="closeLoginButton" title="Close Modal">&times;</span>
        </div>

        <div class="container">
            <h1 style="display: block; text-align: center;">Login</h1>
            <p style="display: block; text-align: center;">Please fill in this form to create an account.</p>
            <hr>
            <label for="email" style="display: block; text-align: center;"><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" required>

            <label for="psw" style="display: block; text-align: center;"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>

            <label for="psw-repeat" style="display: block; text-align: center;"><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required>

            <label>
                <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
            </label>

            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="button" onclick="document.getElementById('LoginModal').style.display='none'" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Sign Up</button>
            </div>
        </div>
    </form>
</div>

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
    // Get the modal
    var modalSignIn = document.getElementById('SignInModal');
    var modalLogin = document.getElementById('LoginModal');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modalSignIn ) {
            modalSignIn.style.display = "none";
        }
        if (event.target == modalLogin ) {
            modalLogin.style.display = "none";
        }
    }

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