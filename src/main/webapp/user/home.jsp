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
    <form class="modal-content animate" action="SignInServlet" method="post">
        <div class="imgcontainer">
            <span onclick="document.getElementById('SignInModal').style.display='none'" class="closeSigInButton"
                  title="Close Modal">&times;</span>
            <img src="images/loginPicture.png" style="position: relative" alt="Avatar" class="avatar">
        </div>
        <div class="container text-center">
            <label for="signInEmail" style="display: block; text-align: center;"><b>Email</b></label>
            <input type="email" class="form-control p-4" placeholder="Enter Email" id="signInEmail" name="signInEmail"
                   required>
            <label for="signInPassword" style="display: block; text-align: center;"><b>Password</b></label>
            <input type="password" class="form-control p-4" placeholder="Enter Password" id="signInPassword"
                   name="signInPassword" required>
            <button type="submit" class="btn btn-success btn-lg">Sign in
            </button>
            <br><br>
            <p class="text-info text-left">Don't have an account? You can create it now:</p>
            <button onclick="switchToLogiModal()" class="btn btn-info">Create an account
            </button>
        </div>
    </form>
</div>
<div id="LoginModal" class="modal">
    <form class="modal-content animate" action="LoginServlet" method="post" onsubmit="return checkPasswords()">
        <div class="imgcontainer">
            <span onclick="document.getElementById('LoginModal').style.display='none'" class="closeLoginButton"
                  title="Close Modal">&times;</span>
        </div>
        <div class="container text-center">
            <h1 style="display: block; text-align: center;">Login</h1>
            <p style="display: block; text-align: center;">Please fill in this form to create an account.</p>
            <hr>
            <label for="loginName" style="display: block; text-align: center;"><b>Name</b></label>
            <input type="text" id="loginName" placeholder="Enter name" name="loginName" required>

            <label for="loginEmail" style="display: block; text-align: center;"><b>Email</b></label>
            <input type="text" id="loginEmail" placeholder="Enter Email" name="loginEmail" required>

            <label for="loginPassword" style="display: block; text-align: center;"><b>Password</b></label>
            <input type="password" id="loginPassword" placeholder="Enter Password" name="loginPassword" required>

            <label for="repeateLoginPassword" style="display: block; text-align: center;"><b>Repeat Password</b></label>
            <input type="password" id="repeateLoginPassword" placeholder="Repeat Password" name="repeateLoginPassword"
                   required>

            <button type="submit" class="btn btn-success btn-lg">Login
            </button>
        </div>
    </form>
</div>
<div id="UserAlreadyExistModal" class="modal">
    <form class="modal-content animate">
        <div class="imgcontainer">
            <span onclick="document.getElementById('UserAlreadyExistModal').style.display='none'" class="closeLoginButton"
                  title="Close Modal">&times;</span>
        </div>
        <div class="container text-center">
            <h1 style="display: block; text-align: center;">Error</h1>
            <p style="display: block; text-align: center;">Such user already exist.</p>
            <hr>
        </div>
    </form>
</div>
<div id="NosuchUserModal" class="modal">
    <form class="modal-content animate">
        <div class="imgcontainer">
            <span onclick="document.getElementById('NosuchUserModal').style.display='none'" class="closeLoginButton"
                  title="Close Modal">&times;</span>
        </div>
        <div class="container text-center">
            <h1 style="display: block; text-align: center;">Error</h1>
            <p style="display: block; text-align: center;">No such user, please try again or create an account!</p>
            <hr>
        </div>
    </form>
</div>
<div id="wrongSignInPasswordModal" class="modal">
    <form class="modal-content animate">
        <div class="imgcontainer">
            <span onclick="document.getElementById('wrongSignInPasswordModal').style.display='none'" class="closeLoginButton"
                  title="Close Modal">&times;</span>
        </div>
        <div class="container text-center">
            <h1 style="display: block; text-align: center;">Error</h1>
            <p style="display: block; text-align: center;">Wrong password, please try again!</p>
            <hr>
        </div>
    </form>
</div>
<div id="banModal" class="modal">
    <form class="modal-content animate">
        <div class="imgcontainer">
            <span onclick="document.getElementById('banModal').style.display='none'" class="closeLoginButton"
                  title="Close Modal">&times;</span>
        </div>
        <div class="container text-center">
            <h1 style="display: block; text-align: center;">Error</h1>
            <p style="display: block; text-align: center;">You are banned on this site and can't book rooms!</p>
            <hr>
        </div>
    </form>
</div>
<script>
    function switchToLogiModal() {
        document.getElementById('LoginModal').style.display = 'block';
        document.getElementById('SignInModal').style.display = 'none'
    }

    function checkPasswords() {
        var psw1 = document.getElementById('loginPassword');
        var psw2 = document.getElementById('repeateLoginPassword');
        if (psw1.value != psw2.value) {
            alert("Passwords dont't match!");
            return false;
        }
    }
</script>
</body>
</html>
