<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
#p1 {
	color: white;
}

.navbar {
	background-color: #0DDD14;
	border-color: #E7E7E7;
}

.navbar-default .navbar-nav>li>a {
	color: 0DDD14;
}

.navbar-brand {
	padding-top: 0;
	margin: -10;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

.modal-content {
	background-color: C8F9B2;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 4px 15px;
	margin: 3px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #43AF54;
	color: white;
	padding: 6px 8px;
	margin: 3px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.regbtn {
	width: auto;
	padding: 6px 10px;
	background-color: #43AF54;
}

.imgcontainer {
	text-align: center;
	margin: 12px 0 8px 0;
	border-color: C8F9B2;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 10px;
}

span.psw {
	float: right;
	padding-top: 10px;
}

@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

.sign_up_form {
	margin-bottom: 30%;
}
</style>
<nav class="navbar navbar">
	<div class="container-fluid">
		<div class="navbar-header">
			<img src="resources/image/mylogo.jpg" alt="GreenZon" height="60px"
				width="100Px" />
		</div>
		<c:choose>
			<c:when test="${sessionScope.Userlogin==true}">
				<ul class="nav navbar-nav">
					<li><a href="home">Home</a></li>
					<li><a href="contactus">Contact Us</a></li>
					<li><a href="aboutus">About Us</a></li>
					<li><a href="productdisp">Product Display</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a>${sessionScope.username}</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
			</c:when>
			<c:when test="${sessionScope.Userlogin==false}">
			<ul class="nav navbar-nav">
					<li><a href="home">Home</a></li>
					<li><a href="contactus">Contact Us</a></li>
					<li><a href="aboutus">About Us</a></li>
					<li><a href="addcategory">Add Category</a></li>
					<li><a href="addproduct">Add Product</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a>Welcome ${sessionScope.username}</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
					
			</c:when>
			<c:otherwise>
				<ul class="nav navbar-nav">
					<li><a href="home">Home</a></li>
					<li><a href="contactus">Contact Us</a></li>
					<li><a href="aboutus">About Us</a></li>
					<li><a href="productdisp">Product Display</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="register">Register</a></li>
					<li><a href="ulogin">Login</a></li>
				</ul>
			</c:otherwise>
		</c:choose>

	</div>
</nav>

