<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css">

</head>
<body>
	<jsp:include page="header.jsp" />
	<c:if test="${homepage==true}">
		<jsp:include page="home.jsp"></jsp:include>
	</c:if>
	<c:if test="${aboutuspage==true}">
		<jsp:include page="aboutus.jsp"></jsp:include>
	</c:if>
	<c:if test="${contactuspage==true}">
		<jsp:include page="contactus.jsp"></jsp:include>
	</c:if>
	<c:if test="${registerpage==true}">
		<jsp:include page="register.jsp"></jsp:include>
	</c:if>
	<c:if test="${addcategorypage==true}">
		<jsp:include page="Category.jsp"></jsp:include>
	</c:if>
	<c:if test="${addproductpage==true}">
		<jsp:include page="Product.jsp"></jsp:include>
	</c:if>
	<%-- 	<jsp:include page="footer.jsp" /> --%>
</body>
</html>