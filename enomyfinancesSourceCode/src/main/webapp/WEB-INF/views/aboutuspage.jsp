<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enomy-Finances | About Us</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/aboutus.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<!-- About Us Section -->
<div class="container mt-5">
    <h1 class="text-center mb-4">About Us</h1>
    <div class="introduction">
	    <!-- Introduction -->
	    <p>
	        Enomy-Finances is a leading organization in the financial sector, providing expert advice and services
	        related to mortgages, savings, and investments. Our dedicated team assesses clients' financial situations
	        to offer valuable insights on budgeting and debt consolidation.
	    </p>
	    <p>
	        Our services include providing access to savings and investment opportunities, as well as managing
	        investment portfolios. With a commitment to excellence, we strive to meet the financial needs of our clients
	        and contribute to their financial success.
	    </p>
	</div>
	
    <div class="row">
    	
        <!-- Mission Column -->
        <div class="col-md-4">
            <div class="text-center mb-5">
	            <div class="val">
	                <h2 class="mb-3">Our Mission</h2>
	                <p>
	                    At Enomy-Finances, our mission is to empower individuals and businesses by providing sound financial
	                    advice and innovative solutions. We aim to be a trusted partner in our clients' financial journey,
	                    helping them achieve their goals and secure a stable financial future.
	                </p>
	            </div>
	        </div>
        </div>
		
        <!-- Vision Column -->
        <div class="col-md-4">
            <div class="text-center mb-5">
	            <div class="val">
	                <h2 class="mb-3">Our Vision</h2>
	                <p>
	                    Our vision is to be a leader in the financial industry, recognized for our integrity, expertise,
	                    and unwavering commitment to client success. We aspire to create a positive impact on the financial
	                    well-being of our clients and contribute to the growth and prosperity of the communities we serve.
	                </p>
	            </div>
	        </div>
        </div>
		
        <!-- Achievements Column -->
        <div class="col-md-4">
            <div class="text-center mb-5">
	            <div class="val">
	                <h2 class="mb-3">Our Achievements</h2>
	                <p>
	                    Over the years, Enomy-Finances has achieved significant milestones in the financial sector. Our team's
	                    dedication and client-focused approach have led to numerous success stories. We take pride in our
	                    achievements and remain committed to delivering excellence in every aspect of our services.
	                </p>
	            </div>
	        </div>
        </div>
    </div>
</div>


<!-- Contact Us Section -->
<div class="contactUs">
	<div class="title">
		<h2>Get in Touch with Us</h2>
	</div>
	<div class="box">
		<div class="contact form">
			<h3>Send a Message</h3>
			<form>
				<div class="formBox">
					<div class="row50">
						<div class="inputBox">
							<span>First Name</span>
							<input type="text" placeholder="First Name">
						</div>
						<div class="inputBox">
							<span>Last Name</span>
							<input type="text" placeholder="Last Name">
						</div>
					</div>
					<div class="row50">
						<div class="inputBox">
							<span>Email</span>
							<input type="email" placeholder="123@email.com">
						</div>
						<div class="inputBox">
							<span>Phone Number</span>
							<input type="text" placeholder="1234 567 89">
						</div>
					</div>
					<div class="row100">
						<div class="inputBox">
							<span>Message</span>
							<textarea placeholder="Write your message here..."></textarea>
						</div>
					</div>
					<div class="row100">
						<div class="inputBox">
							<input type="submit" value="Send">
						</div>
					</div>
				</div>
			</form>
		</div>
			
		<div class="contact info">
			<h3>Contact Info</h3>
			<div class="infoBox">
				<div>
					<span><ion-icon name="location"></ion-icon></span>
					<p>4325 S Meridian St, Indianapolis, IN 46217<br>United States</p>
				</div>
				<div>
					<span><ion-icon name="mail"></ion-icon></span>
					<a href="mailto:1234@gmail.com">1234@gmail.com</a>
				</div>
				<div>
					<span><ion-icon name="call"></ion-icon></span>
					<a href="tel:123456789">1234 567 89</a>
				</div>
				<ul class="sci">
					<li><a href="#"><ion-icon name="logo-facebook"></ion-icon></a></li>
					<li><a href="#"><ion-icon name="logo-twitter"></ion-icon></a></li>
					<li><a href="#"><ion-icon name="logo-instagram"></ion-icon></a></li>
					<li><a href="#"><ion-icon name="logo-youtube"></ion-icon></a></li>
				</ul>
			</div>
		</div>
		
		<div class="contact map">
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d49117.61132481373!2d-86.19496225423484!3d39.6980605343033!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x886b5a36a1fff98f%3A0x19f6117befe0f3fe!2sAMC%20Indianapolis%2017!5e0!3m2!1sen!2sph!4v1708010614228!5m2!1sen!2sph" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>
	</div>
</div>




<jsp:include page="footer.jsp"></jsp:include>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>