<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Enomy-Finances | Reset Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<style>
		.forgotpassword-section {
		padding-top: 50px;
		padding-bottom: 80px;
		}
	</style>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
<div class="forgotpassword-section">
	<div class="d-flex justify-content-center">
	    <div class="col-5 px-5 py-2 d-flex flex-column justify-content-center">
	        <h1>Reset your password</h1>
	        <p>Enter your email, and we'll find your email. Then you can reset your password.</p>
	
	        <form:form action="forgotpassword" method="post">
	            <div class="form-floating mb-3">
	                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="emailAddress" required>
	                <label for="floatingInput">Email address</label>
	                <div class="invalid-feedback">
	                    Email address should have @ and .
	                </div>
	            </div>
	           <div class="mb-3">
	                    <label for="password" class="form-label">New Password</label>
	                    <input type="password" class="form-control" id="password" name="password" required>
	                    <div class="invalid-feedback">
	                        Password required & must be match
	                    </div>
	                </div>
	                <div class="mb-3">
	                    <label for="passwordConfirmation" class="form-label">New Password Confirmation</label>
	                    <input type="password" class="form-control" id="passwordConfirmation" name="passwordConfirmation" required>
	                    <div class="invalid-feedback">
	                        Password required & must be match
	                    </div>
	                </div>
	                <!-- Display error message if it exists -->
			        <% if (request.getAttribute("error") != null) { %>
			            <div class="alert alert-danger" role="alert">
			                <%= request.getAttribute("error") %>
			            </div>
			        <% } %>
	                <button type="submit" class="btn btn-primary">Update Password</button>
	            </form:form>
	 
	    </div>
	</div>
</div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>