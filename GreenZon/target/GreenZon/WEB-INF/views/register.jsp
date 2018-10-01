<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value='/registeruser' var="url"></c:url>
<style>
body {
	background: #C5E1A5;
}

form {
	width: 60%;
	margin: 30px auto;
	background: #efefef;
	padding: 60px 120px 80px 120px;
	text-align: center;
	-webkit-box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
	box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	position: relative;
	margin: 40px 0px;
}

input {
	width: 100%;
	padding: 10px;
	background: transparent;
	border: none;
	outline: none;
}

.line-box {
	position: relative;
	width: 100%;
	height: 2px;
	background: #BCBCBC;
}

.line {
	position: absolute;
	width: 0%;
	height: 2px;
	top: 0px;
	left: 50%;
	transform: translateX(-50%);
	background: #8BC34A;
	transition: ease .6s;
}

input:focus+.line-box .line {
	width: 100%;
}

.label-txt {
	position: absolute;
	top: -1.6em;
	padding: 10px;
	font-family: sans-serif;
	font-size: .8em;
	font-color: 32A611;
	letter-spacing: 1px;
	color: rgb(120, 120, 120);
	transition: ease .3s;
}

.label-active {
	top: -3em;
}

button {
	display: inline-block;
	padding: 12px 24px;
	background: rgb(220, 220, 220);
	font-weight: bold;
	color: rgb(120, 120, 120);
	border: none;
	outline: none;
	border-radius: 3px;
	cursor: pointer;
	transition: ease .3s;
}

button:hover {
	background: #8BC34A;
	color: #ffffff;
}
</style>

<c:if test="${errstatus}">
	<span class="alert alert-danger">Failed to process the data</span>
</c:if>
<c:if test="${succstatus}">
	<span class="alert alert-danger">Registration Successful Login
		to Continue</span>
</c:if>
<form:form modelAttribute="customer" action="${url}" method="post">
	<label> <form:input type="text" placeholder="Enter name"
			name="uname" path="name"/> <form:errors
			path="name" cssStyle="color:red" ></form:errors>
		<div class="line-box">
			<div class="line"></div>
		</div>
	</label>
	<form:input type="text" placeholder="Enter E-Mail Id" name="email"
		path="emailid" />
	<form:errors path="emailid" cssStyle="color:red"></form:errors>
	<div class="line-box">
		<div class="line"></div>
	</div>
	<br>
	<br>
	
	<form:input type="text" placeholder="Enter Phone Number" name="phno"
		path="phoneNo" />
	<form:errors path="phoneNo" cssStyle="color:red"></form:errors>
	<div class="line-box">
		<div class="line"></div>
	</div>
	<br>
	<br>

	<form:input type="text" placeholder="Enter Password" name="password"
		path="password" />
	<form:errors path="password" cssStyle="color:red"></form:errors>
	<div class="line-box">
		<div class="line"></div>
	</div>
	

	<button type="submit">submit</button>
</form:form>