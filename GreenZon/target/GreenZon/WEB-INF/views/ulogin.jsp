<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" style="padding-left: 25%; padding-right: 25%">
	<c:if test="${lerrstatus}">
		<span class="alert alert-danger form-control">Username Or Password Incorrect</span>
	</c:if>
	<form class="form-signin" action="perform_login" method="POST">
		<span id="reauth-email" class="reauth-email"></span> <input
			type="email" id="usename" class="form-control"
			placeholder="Email address" required autofocus name="usename">
		<input type="password" id="userpassword" class="form-control"
			placeholder="Password" required name="userpassword">
		<button class="btn btn-lg btn-primary btn-block btn-success"
			type="submit">Sign in</button>
	</form>
</div>
<div class="modal fade" id="myModal2" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<h2>Forget Password</h2>
				<div class="imgcontainer">
					<img src="resources/image/pass.jpg" alt="Avatar" class="avatar">
				</div>
			</div>
			<div class="modal-body">
				<form class="form-signin">
					<p>Enter your email address we will send you the password.</p>
					<input type="email" name="email" id="email"
						class="form-control input-lg" placeholder="Email address"
						tabindex="4" class="form-control">
					<button class="btn btn-lg btn-primary btn-block btn-success"
						type="submit">Submit</button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

