<head>
<title>Welcome to Enomy-Finances </title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<div class="d-flex align-items-center position-relative" style="height: 90vh; overflow: hidden;">
  	<div class="position-absolute" style="z-index: -1; min-width: 100%">
    	<img src="images/background.jpg" alt="Your Image Description" style="width: 100%; height: auto;">
	</div>
    	
	
  	<div class="d-flex flex-column justify-content-center container">
  		<div class="text-center" style="color: white">
  			<h1>WELCOME TO ENOMY-FINANCES</h1>
  		</div>
	    <div class="d-flex justify-content-center gap-4">
		    <% if( (Boolean) session.getAttribute("isLogin") == null) { %>
	   			<a href="register" class="btn btn-primary input-group-text">Sign up for Enomy-Finances</a>
	      		<a href="login" class="btn btn-outline-primary w-25 text-white fw-bold">I have an account</a>
	    <% } else { %>
	      	
	    <% } %>
		   
	    </div>
 	</div>
</div>
<style>
.course{
    width: 80%;
    margin: auto;
    text-align: center;
    padding-top: 100px;
}
h1{
    font-size: 50px;
    font-weight: 600;
}

h2{
    font-size: 36px;
    font-weight: 600;
    
}
p{
    color:#777;
    font-size: 14px;
    font-weight: 300;
    line-height: 22px;
    padding: 10px;
}
.row{
    margin-top: 5%;
    display: flex;
    justify-content: space-between;
}
.course-col{
    flex-basis: 31%;
    background: #fff3f3;
    border-radius: 10px;
    margin-bottom: 5%;
    padding: 20px 12px;
    box-sizing: border-box;
    text-align: justify;
}
h3{
    text-align: center;
    font-weight: 600;
    margin: 10px 0;  
}
h4{
    text-align: center;
    font-weight: 600;
    margin: 10px 0;  
}
.course-col:hover{
    box-shadow: 0 0 20px 0px rgba(0,0,0,0.2);
}
.campus{
    width: 80%;
    margin: auto;
    text-align: center;
    padding-top: 50px;
}
.campus p {
	font-size: 19px;
}
.campus-col{
    flex-basis: 32%;
    border-radius: 10px;
    margin-bottom: 30px;
    position: relative;

}
.campus-col img{
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 10px;
}
.layer{
    background: transparents;
    height: 100%;
    width: 100%;
    position: absolute;
    top: 0;
    left: 0;
    transition:0.5s;
    border-radius: 10px;
}
.layer:hover{
    background: rgba(226,0,0,0.7);
}
.layer h3{
    width: 100%;
    font-weight: 500;
    color: #fff;
    font-size: 26px;
    bottom: 0;
    left: 50%;
    transform: translateX(-50%);
    position: absolute;
    opacity: 0;
    transition: 0.5s;
}
.layer:hover h3{
    bottom: 49%;
    opacity: 1;
}
.cta{
    margin: 100px auto;
    width: 80%;
    background-image: linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7)),url(images/offices.jpg);
    background-position: center;
    background-size: cover;
    border-radius: 10px;
    text-align: center;
    padding: 100px 0;
}
.cta h2{
    color: #fff;
    margin-bottom: 40px;
    padding: 0;
}
.footer{
    width: 60%;
    margin: auto;
    text-align: center;
    padding: 30px 0;
}
.footer h3{
    margin-bottom: 25px;
    margin-top: 20px;
    font-weight: 600;
}

.footer p {
	font-size: 19px;
}
</style>
<body>
        <section class="campus">
            <h2>AVAILABLE SERVICES</h2>
            <p>Below are some of the services available in Enomy-Finances</p>
            <div class="row">
                <div class="campus-col">
                   	<img src="images/currencyconversion.jpg">
	               
	                    <div class="layer">
	                        <h3>Currency Converter</h3>
	                    </div> 
                </div>
                <div class="campus-col">
                    <img src="images/savingsandinvestments.jpg">
                    
                    	<div class="layer">
                        	<h3>Savings and Investments Opportunities</h3>
                    	</div>
                </div>
                <div class="campus-col">
                    <img src="images/investmentplans.jpg">
                    
                    	<div class="layer">
                        	<h3>Investment Plans</h3>
                    	</div>
                </div>
                
            </div>
            <section class="cta">
                <h2>Empowering Financial Futures, One Transaction at a Time.</h2>
            </section>
        </section>
        <section class="footer">
            <h3>ABOUT US</h3>
            <p>
		Enomy Finance is a premier online financial management platform, 
		dedicated to empowering users to take control of their finances. We provide a user-friendly interface for budgeting, 
		expense tracking, and achieving financial goals. With Enomy Finance, managing your money becomes simple and effective, 
		ensuring a secure and seamless financial journey.
            </p>
           
       
        </section> 
        <br>
        <br>
        <br>
	<jsp:include page="footer.jsp"></jsp:include>