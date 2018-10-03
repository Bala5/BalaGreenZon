<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value='/productdisp' var="url"></c:url>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
* {
    box-sizing: border-box;
}

.zoom {
    transition: transform 5s;
    margin: 0 auto;
}

.zoom:hover {
    -ms-transform: scale(2); /* IE 9 */
    -webkit-transform: scale(2); /* Safari 3-8 */
    transform: scale(2); 
}
/* .thumbnail */
/* { */
/* background-image: linear-gradient(0 , green, yellow); */
/* } */
</style>
<div class="container">
	<div class="row">
		<div class=" col-md-12">
			<c:forEach items="${productlist}" var="m">
				<div class="col-sm-3 col-md-3">
					<div class="thumbnail w3-container w3-center w3-animate-bottom">
						<h4 class="text-center">
							<span class="label label-info">${m.name}</span>
						</h4>
						<img class="zoom" src="resources/productimages/${m.productid}.jpg" height="100"
							width="100">
						<div class="row">
							<div class="text-center">
								<h3>Price: &#8377 ${m.price}/kg</h3>
							</div>
						</div>
						<div class="row">
							<div class="text-center">
								<a href="oneproductdisp?productid=${m.productid}" class="btn btn-success btn-product"><span
									class="glyphicon glyphicon-shopping-cart"></span>View Details</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</div>

