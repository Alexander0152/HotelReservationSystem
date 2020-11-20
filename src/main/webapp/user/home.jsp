<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/19/2020
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styleMain.css">
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <title>Title</title>
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

    <%--    <form class="modal-content animate" action="/action_page.php" method="post">--%>
    <form class="modal-content animate"  method="post">
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

<%--            <label>--%>
<%--                <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me--%>
<%--            </label>--%>

            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="button" onclick="document.getElementById('LoginModal').style.display='none'" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Sign Up</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
