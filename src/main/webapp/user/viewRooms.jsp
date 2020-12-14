<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/21/2020
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link rel="stylesheet" href="styleViewRooms.css">
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
        <title>Rooms catalog </title>
    </head>
</head>
<body style="background-image: url('images/more.jpg')">

<jsp:include page="home.jsp"/>
<div id="navbar">
    <a class="active" href="ViewRoomsServlet">Rooms</a>
    <a href="index.jsp">Booking</a>
    <a href="ContactsServlet">Contacts</a>
</div>

<img id="Economy" img src="images/Economy1.jpg" alt="Economy" style="left: 120px; top: 350px;" width="660" height="426"
     onclick="increaseImage(id)">
<img id="Lux " img src="images/Lux.jpg" alt="Lux" style="left: 120px; top: 876px;" width="660" height="409"
     onclick="increaseImage(id)">
<img id="Vip" img src="images/Vip.jpg" alt="Vip" style="left: 120px; top: 1385px;" width="660" height="430"
     onclick="increaseImage(id)">
<img id="President" img src="images/President.jpg" alt="President"
     style="left: 120px; padding-bottom: 15px; top: 1915px;" width="660" height="420" onclick="increaseImage(id)">
<div class="content">
    <div class="text-blockEconomy">
        <h>Economy</h>
        <p>As our smallest budget rooms, the Economy bedrooms are suited for single occupancy or short-stay
            double occupancy as they have limited space and storage.</p>
        <p>Economy rooms are perfect for guests who want to live comfortably , but for less money . The
            comfort is the same as the standard rooms but the rooms are a bit smaller .</p>
        <p>The rooms are equipped with one or two single beds.</p>
        <p style="padding-top: 130px; font-weight: bold;">USD 25.00 - 35.00/Night</p>
    </div>
    <div class="text-blockLux">
        <h>Lux</h>
        <p>All our Lux rooms are elegantly furnished with handmade furniture include luxury en-suite
            facilities with complimentary amenities pack, flat screen LCD TV, tea/coffee making facilities,
            fan, hairdryer and the finest pure white linen and towels. Our Deluxe king size room has a seating
            area, ample storage, digital safe, minibar and luxurious duck down bedding. This room can also be
            configured with an extra roll-away bed for families of 3.</p>
        <p>All rooms features air conditioning, a flat-screen TV with satellite channels, a microwave, an
            electric tea pot, a shower, free toiletries and a closet. The rooms come with a private bathroom,
            while selected rooms also feature a kitchenette with a fridge.</p>
        <p style="padding-top: 80px; font-weight: bold;">USD 71.00 - 160.00/Night</p>
    </div>
    <div class="text-blockVip">
        <h>Vip</h>
        <p>Our VIP room is designed with class and comfort to offer top standard accommodation to those
            seeking bigger space, king size bed, affordable luxury and maximum comfort. Its luminous design
            evokes the feeling of warmth and luxury. There is a cozy seating area with upholstered lounge
            sofa and table where guests can relax with a nice flat screen television and DVD player with
            variety of Hollywood movies. For added convenience, there is a table with a work/computer desk
            equipped with desktop, monitor and in-room internet access Wi-Fi for personal or business use.</p>
        <p>Our Deluxe Twin/Large Double also provides views over beautiful city. It has a seating area,
            digital safe, minibar and luxurious duck down bedding.</p>
        <p style="padding-top: 120px; font-weight: bold;">USD 180.00 - 330.00/Night</p>
    </div>
    <div class="text-blockPresident">
        <h>President</h>
        <p>Our Presidential Suite has been carefully decorated with the highest attention to detail and
            optimised for Business and Leisure use, ensuring that Corporate Executives’ or Luxury Connoisseurs’
            requirements will be fully met to the degree that they have been accustomed.</p>
        <p>Amongst the exclusive
            facilities of the Presidential Suite, there is a fully equipped business office in the living
            room equipped with Laptop, Fax machine and Printer (on request), a Private Bar corner in the living
            room, an elegant dining area with its own service room as well as Luxury Bath Amenities, a Multi
            functional Coffee Machine, a fully stocked mini bar which is daily refilled, a Mini Hi-Fi System and
            an I-pod docking station.
        </p>
        <p>In terms of in-room entertainment, the master bedroom is equipped with a large 37’ LCD TV while the
            living room with an even larger 42’ LCD TV with numerous satellite channels, Video on Demand with a wide
            choice of films and complimentary wireless Internet access.
        </p>
        <p style="padding-top: 45px; font-weight: bold;">USD 5000.00/Night</p>
    </div>
</div>

<!-- The Modal -->
<div id="myModal" class="imageModal">
    <span class="close" style="color: #f1f1f1; font-size: 40px;">&times;</span>
    <img class="imageModal-content" style="left: 455px; top: 200px;" id="img01">
    <div id="caption"></div>
</div>


<script>
    function increaseImage(id) {

        // Get the modal
        var modal = document.getElementById("myModal");

        // Get the image and insert it inside the modal - use its "alt" text as a caption
        var img = document.getElementById(id);
        var modalImg = document.getElementById("img01");
        var captionText = document.getElementById("caption");
        img.onclick = function () {
            modal.style.display = "block";
            modalImg.src = this.src;
            captionText.innerHTML = this.alt;
        }

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks on <span> (x), close the modal
        span.onclick = function () {
            modal.style.display = "none";
        }
    }

    window.onscroll = function () {
        myFunction()
    };

    var navbar = document.getElementById("navbar");
    var sticky = navbar.offsetTop;

    function myFunction() {
        if (window.pageYOffset >= sticky) {
            navbar.classList.add("sticky");
        } else {
            navbar.classList.remove("sticky");
        }
    }
</script>
</body>
</html>
