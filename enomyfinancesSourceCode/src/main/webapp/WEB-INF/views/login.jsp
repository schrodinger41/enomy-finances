<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enomy-Finances | Log In</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<style>
        .login-section {
            padding-top: 52px;
            padding-bottom: 110px;
        }
	</style>
	<%@ page isELIgnored="false" %>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="login-section">
	<div class="d-flex justify-content-center">
	  <div class="col-5 px-5 py-2 d-flex flex-column justify-content-center">
	    <h1>Sign in to your account</h1>
	     <p>Don't have an account yet? <a href="register">Register Now</a></p>
		<!-- successful password reset -->
		<% if (request.getAttribute("message") != null) { %>
		    <div class="alert alert-success" role="alert">
		        <%= request.getAttribute("message") %>
		    </div>
		<% } %>

		<!-- login error here -->
		<% if (request.getAttribute("loginError") != null) { %>
		    <div class="alert alert-danger" role="alert">
		        <%= request.getAttribute("loginError") %>
		    </div>
		<% } %>
	    <form:form action="login" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	      <div class="mb-3">
	        <label for="emailAddress" class="form-label">Email address</label>
	        <input type="email" class="form-control" id="email" name="username" required>
	      </div>
	      <div class="mb-3">
	        <label for="password" class="form-label">Password</label>
	        <input type="password" class="form-control" id="password" name="password" required>
	      </div>
	      <div class="d-flex flex-column">
	      <div class="d-flex">
          <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
            <label class="form-check-label" for="rememberMe">Remember Me</label>
          </div>
           <a href="forgotpassword" class="ms-auto">Forgot password?</a>
        </div>
	        <button type="submit" class="btn btn-primary">Log in</button>
	      </div>
	    </form:form>
	  </div>
	</div>
	
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>