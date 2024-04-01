<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enomy-Finances | Dashboard</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="css/tables.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container mx-auto">
	<div class="mb-3">
        <h3>Welcome to Your Dashboard!</h3>
        <hr>
    </div>
    <div class="row border rounded-3 p-3 mb-4">
        <div class="col-2 border-none rounded-circle align-self-stretch text-center fs-1 d-flex align-items-center justify-content-center bg-primary bg-gradient text-white">
         	<span><i class="bx bx-user" ></i></span>
        </div>
        <div class="col-8 p-5">
        <h2><%= request.getAttribute("firstName") %> <%= request.getAttribute("lastName") %></h2>
        <hr>
        <p>${roleName}</p>
        </div>
   	</div>
	
</div>
<div class="mx-auto justify-content-center">
<hr>
	 <div class="justify-content-center">
        <div class="mb-4">
        	<sec:authorize access="hasRole('User')">
        	<div class="box table-box mx-auto">
                <div class="currency-conversion">
                	<h2>Currency Conversions History</h2>
	                <div class="table-row default">
	                    <div class="table-cell">
	                        <p>Transaction ID</p>
	                    </div>
	                    <div class="table-cell">
	                        <p>From Currency</p>
	                    </div>
	                    <div class="table-cell">
	                        <p>To Currency</p>
	                    </div>
	                    <div class="table-cell">
	                        <p>Amount</p>
	                    </div>
	                    <div class="table-cell">
	                        <p>Converted Amount</p>
	                    </div>
	                    <div class="table-cell">
	                        <p>Fee</p>
	                    </div>
	                    <div class="table-cell">
	                        <p>Final Amount</p>
	                    </div>
	                </div>
	                <!-- Loop through recent purchases -->
	                <c:forEach items="${savedConversions}" var="conversion">
		                <div class="table-row">
		                    <div class="table-cell">
		                        <p>${conversion.transactionId}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${conversion.fromCurrency}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${conversion.toCurrency}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${conversion.amount} ${conversion.fromCurrency}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${conversion.convertedAmount} ${conversion.toCurrency}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${conversion.fee} ${conversion.toCurrency}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${conversion.finalAmount} ${conversion.toCurrency}</p>
		                    </div>
		                </div>
	                </c:forEach>
                </div>
            </div>
            
            <div class="box table-box mx-auto">
                <div class="transaction-list">
	                <h2>Recent Transactions</h2>
		                <div class="table-row default">
		                    <div class="table-cell">
		                        <p>Investment Number</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>Investment Type</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>Initial Lump Sum</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>Monthly Investment</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>1-Year Return</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>5-Year Return</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>10-Year Return</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>1-Year Profit</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>5-Year Profit</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>10-Year Profit</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>1-Year Fees</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>5-Year Fees</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>10-Year Fees</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>1-Year Taxes</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>5-Year Taxes</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>10-Year Taxes</p>
		                    </div>
		                </div>
	                <!-- Loop through recent purchases -->
	                <c:forEach var="investment" items="${userInvestments}">
		                <div class="table-row">
		                    <div class="table-cell">
		                        <p>${investment.investmentId}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.investmentType}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.initialLumpSum} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.monthlyInvestment} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.oneYearReturn} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.fiveYearsReturn} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.tenYearsReturn} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.oneyeartotalprofit} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.fiveyeartotalprofit} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.tenyeartotalprofit} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.oneyeartotalfees} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.fiveyeartotalfees} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.tenyeartotalfees} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.oneyeartotaltaxes} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.fiveyeartotaltaxes} GBP</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${investment.tenyeartotaltaxes} GBP</p>
		                    </div>
		                </div>
	                </c:forEach>
                </div>
            </div>
            </sec:authorize>
            <sec:authorize access="hasRole('Admin')">
            <div class="box table-box mx-auto">
                <div class="transaction-list">
	                <h2>Accounts</h2>
		                <div class="table-row default">
		                    <div class="table-cell">
		                        <p>Account IDr</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>Full Name</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>Phone Number</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>User Email</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>Password</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>Actions</p>
		                    </div>
		                    
		                </div>
	                <!-- Loop through recent purchases -->
	                <c:forEach var="user" items="${user}">
		                <div class="table-row">
		                    <div class="table-cell">
		                        <p>${user.userId}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${user.firstName} ${user.lastName}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${user.phoneNumber}</p>
		                    </div>
		                    <div class="table-cell">
		                        <p>${user.email}</p>
		                    </div>
		                    <div class="table-cell" style="overflow: hidden">
		                        <p>${user.password}</p>
		                    </div>
		                    <div class="table-cell">
								&nbsp;&nbsp;&nbsp;
								<a href="delete?id=${user.userId}"onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
		                    </div>
		                </div>
	                </c:forEach>
                </div>
            </div>
            
            </sec:authorize>
            
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>