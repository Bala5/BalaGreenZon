<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
	<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
</head>
<body>
	<jsp:include page="header.jsp" />
	<div style="min-height: 500px;">
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
		<c:if test="${ulogin==true}">
			<jsp:include page="ulogin.jsp"></jsp:include>
		</c:if>
		<c:if test="${addcategorypage==true}">
			<jsp:include page="Category.jsp"></jsp:include>
		</c:if>
		<c:if test="${addproductpage==true}">
			<jsp:include page="Product.jsp"></jsp:include>
		</c:if>
		<c:if test="${ProductDisp==true}">
			<jsp:include page="ProductDisp.jsp"></jsp:include>
		</c:if>
		<c:if test="${OneProductDisp==true}">
			<jsp:include page="OneProductDisp.jsp"></jsp:include>
		</c:if>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>