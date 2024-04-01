<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Back</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
	<style>
	@import url('https://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900&display=swap');
html,body {
    font-family: 'Raleway', sans-serif; 
    background: #ffdde0; 
}
.welcome-page ._header {
    background: black;
    padding: 100px 30px;
    text-align: center;
    background: black url(https://codexcourier.com/images/main_page.jpg) center/cover no-repeat;
}
.welcome-page ._header .logo {
    max-width: 200px;
    margin: 0 auto 50px;
}
.welcome-page ._header .logo img {
    width: 100%;
}
.welcome-page ._header h1 {
    font-size: 65px;
    font-weight: 800;
    color: white;
    margin: 0;
}
.welcome-page ._body {
    margin: -70px 0 30px;
}
.welcome-page ._body ._box {
    margin: auto;
    max-width: 80%;
    padding: 50px;
    background: white;
    border-radius: 3px;
    box-shadow: 0 0 35px rgba(10, 10, 10,0.12);
    -moz-box-shadow: 0 0 35px rgba(10, 10, 10,0.12);
    -webkit-box-shadow: 0 0 35px rgba(10, 10, 10,0.12);
}
.welcome-page ._body ._box h2 {
    font-size: 32px;
    font-weight: 600;
    color: #4ab74a;
}
.welcome-page ._footer {
    text-align: center;
    padding: 50px 30px;
}

.welcome-page ._footer .btn {
    background: #4ab74a;
    color: white;
    border: 0;
    font-size: 14px;
    font-weight: 600;
    border-radius: 0;
    letter-spacing: 0.8px;
    padding: 20px 33px;
    text-transform: uppercase;
}
</style>
<jsp:include page="header.jsp"></jsp:include>
<div class="welcome-page">
    <div class="_header">
        
        <h1>Welcome Back!</h1>
    </div>
    <div class="_body">
        <div class="_box">
            <h2>
                <strong>Log In Successful</strong> 
            </h2>
            
             <p>Welcome back. We're delighted to have you back as a valued member of our community. Thank you for choosing us again.</p>
	        
			<a href="/enomyfinancesSourceCode/" class="btn btn-primary">Go to Home Page</a>
        </div>
        
    </div>
  
</div>


<br>
<br>
<br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>