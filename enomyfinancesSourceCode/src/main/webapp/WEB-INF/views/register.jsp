<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enomy-Finances | Register </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link
     rel="stylesheet"
     href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css"
   />
   <script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
</head>

<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="d-flex justify-content-center">
  <div class="col-5 px-5 py-2 d-flex flex-column justify-content-center">
    <h1>Registration</h1>
    <p>Have an account? <a href="login">Login</a></p>
    <form:form action="enomyfinancesSourceCode/registerprocess" method="post"> 
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <div class="mb-3">
        <label for="firstName" class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstName" name="firstName" required>
      </div>

      <div class="mb-3">
        <label for="lastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastName" name="lastName" required>
      </div>

      <div class="mb-3">
        <label for="emailAddresss" class="form-label">Email address</label>
        <input type="email" class="form-control" id="emailAddress" name="email" required>
      </div>

      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password" required>
      </div>

      <div class="mb-3">
        <label for="passwordConfirmation" class="form-label">Password Confirmation</label>
        <input type="password" class="form-control" id="passwordConfirmation" name="passwordConfirmation" required>
      </div>
      
      <div class="mb-3">
        <label for="phoneNumber" class="form-label">Phone Number</label>
        <input type=number class="form-control" id="phoneNumber" name="phoneNumber" required>
      </div>
       <script>
	   const phoneInputField = document.querySelector("#phoneNumber");
	   const phoneInput = window.intlTelInput(phoneInputField, {
	     utilsScript:
	       "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
	   });
	 </script>
	 
      <button type="submit" class="btn btn-primary w-100">Register</button>
    </form:form>
  </div>
</div>
<br>
<br>
<jsp:include page="footer.jsp"></jsp:include>

</html>