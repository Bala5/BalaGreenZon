
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
tr:nth-child(even) {
	background-color: #fbf2ad
}

tr:nth-child(odd) {
	background-color: #b0bf35
}


.linesa{
    border-bottom: 8px solid #225378;
    width:100%;
    position:relative;
    
}
.linesa:before {
    content:"";
    position:absolute;
    height:12px;
    width:50%;
    background:green;
    left:25%;
    margin-top:-2px;
}

</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').dataTable({
			"pagingType" : "full_numbers",
			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ],
			"ordering" : true,
		});
	});
</script>
<div class="container" align="center">

	<c:if test="${errstatus}">
		<span class="alert alert-danger form-control">Failed to process
			the data</span>
	</c:if>
	<c:if test="${succstatus}">
		<span class="alert alert-danger form-control"> Added Successfully </span>
	</c:if>
	<form:form modelAttribute="category" action="categoryadd" method="post">
		<c:if test="${editmode}">
			<form:input type="text" class="form-control"
				placeholder="Enter Category name" name="cname" path="catid"
				readonly="true" />

		</c:if>
		<form:input type="text" class="form-control"
			placeholder="Enter Category name" name="cname" path="categoryName" />
		<form:errors path="categoryName" cssStyle="color:red"></form:errors>
		<button type="submit">submit</button>
	</form:form>
	<div class="line text-center">
		<div class="linesa"></div>
	</div>
	<div class="table-responsive" style="padding-top: 20px">
		<table id="table_id" name="table_id" class="display" style="padding-top: 20px">
			<thead>
				<tr>
					<th>CATEGORY ID</th>
					<th>CATEGORY NAME</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${catlist}" var="l">
					<tr>
						<td>${l.catid}</td>
						<td>${l.categoryName}</td>
						<td><a class='btn btn-success btn-xs'
							href="editcat?catid=${l.catid}"><span
								class="glyphicon glyphicon-edit"></span> Edit</a></td>
						<td><a class='btn btn-danger btn-xs'
							href="removecat?catid=${l.catid}"><span
								class="glyphicon glyphicon-trash"></span> Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<!-- <ul class="list-group"> -->
<%-- 	<c:forEach items="${catlist}" var="c"> --%>
<%-- 		<li class="list-group-item">${c.categoryName}</li> --%>
<%-- 	</c:forEach> --%>
<!-- </ul> -->
