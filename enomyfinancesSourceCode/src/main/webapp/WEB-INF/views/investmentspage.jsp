<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enomy-Finances | Savings and Investments Module</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<style>
	.investment-section {
		margin-bottom: 50px;
	}
	
	p {
		margin-bottom: 0 !important;
	}
</style>
<%@ page isELIgnored="false" %>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
		<div class="investment-section">
			<div class="container mt-5">
			    <div class="row">
			        <!-- Investment Options on the Left -->
			        <div class="col-md-6">
			         <!-- Investment details section -->
						<div class= " mx-auto">
							<h1 class="">Investment Options</h1>
			            	<p class="text-muted">Explore Your Investment Options</p>
							<div class="accordion" id="accordionExample">
							  <div class="accordion-item">
							    <h2 class="accordion-header" id="headingOne">
							      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							      Option 1: Basic Savings Plan
							      </button>
							    </h2>
							    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
							      <div class="accordion-body">
							        <li><b>Maximum investment per year:</b> £20 000 </li>
									<li><b>Minimum monthly investment:</b> £50 </li>
									<li><b>Minimum initial investment lump sum:</b> N/A </li>
									<li><b>Predicted returns per year:</b> 1.2% to 2.4% </li>
									<li><b>Estimated tax:</b> 0% </li>
									<li><b>RBSX group fees per month:</b> 0.25%</li>
							      </div>
							    </div>
							  </div>
							  <div class="accordion-item">
							    <h2 class="accordion-header" id="headingTwo">
							      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
							        Option 2: Savings Plan Plus
							      </button>
							    </h2>
							    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
							      <div class="accordion-body">
							        <li><b>Maximum investment per year:</b> £30 000 </li>
									<li><b>Minimum monthly investment:</b> £50 </li>
									<li><b>Minimum initial investment lump sum:</b> £300 </li>
									<li><b>Predicted returns per year:</b> 3% to 5.5% </li>
									<li><b>Estimated tax:</b> 10% on profits above £12 000 </li>
									<li><b>RBSX group fees per month:</b> 0.3% </li>
							      </div>
							    </div>
							  </div>
							  <div class="accordion-item">
							    <h2 class="accordion-header" id="headingThree">
							      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
							        Option 3: Managed Stock Investments
							      </button>
							    </h2>
							    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
							      <div class="accordion-body">
							        <li><b>Maximum investment per year:</b> Unlimited </li>
									<li><b>Minimum monthly investment:</b> £150 </li>
									<li><b>Minimum initial investment lump sum:</b> £1000 </li>
									<li><b>Predicted returns per year:</b> 4% to 23% </li>
									<li><b>Estimated tax:</b> 10% on profits above £12 000, 20% on profits above £40 000</li>
									<li><b>RBSX group fees per month:</b> 1.3%</li>
							      </div>
							  	</div>
							  </div>
							</div>
						</div>
				    </div>
				
	
	        <!-- Investment Form and Results on the Right -->
	        <div class="col-md-6">
	            <div class="d-flex justify-content-center">
	                <div class="col-10 px-5 py-2 d-flex flex-column justify-content-center">
	                    <h1>Investment Form</h1>
						<p class="text-muted">Start Your Investment Journey</p>
	                     <!-- Form for entering investment details -->
		                <form:form action="showresults" method="post" modelAttribute="investment">
		                    <div class="mb-3">
		                        <label for="investmentType" class="form-label">Investment Type</label>
		                        <select type="text" class="form-select" id="investmentType" name="investmentType" required>
			                        <option value="Basic Savings Plan">Basic Savings Plan</option>
							        <option value="Savings Plan Plus">Savings Plan Plus</option>
							        <option value="Managed Stock Investments">Managed Stock Investments</option>
						        </select>
		                    </div>
		                    <div class="mb-3">
		                        <label for="initialLumpSum" class="form-label">Initial Lump Sum</label>
		                        <input type="number" class="form-control" id="initialLumpSum" name="initialLumpSum" required>
		                    </div>
		                    <div class="mb-3">
		                        <label for="monthlyInvestment" class="form-label">Monthly Investment</label>
		                        <input type="number" class="form-control" id="monthlyInvestment" name="monthlyInvestment" required>
		                    </div>
		                    <button type="submit" class="btn btn-primary w-100">Show Results</button>
		                	<c:if test="${not empty investmentError}">
					            <div class="alert alert-danger" role="alert">
					                ${investmentError}
					            </div>
					        </c:if>
		                </form:form>
		                
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	</div>
	
	<div class="result">
                            <% if (request.getAttribute("showResults") != null && (Boolean) request.getAttribute("showResults")) { %>
                                <div class="container py-2">
                                    <div class="row justify-content-center">
                                        <div class="col-md-10">
                                            <h2 class="text-uppercase mb-4">Investment Results</h2>
                                            <div class="lead fw-normal mb-4">
                                                <table class="table">
                                                    <tbody>						    
										       <tr>
										         <td class="text">${investmentType}</td>						       
										       <tr>
										         <td>Initial Lump Sum:</td>
										         <td>${initialLumpSum}</td>
										         <td>Monthly Investment:</td>
										         <td>${monthlyInvestment}</td>
										       </tr>
											   <tr>
											     <td>Time Frame</td>
											     <td>Returns</td>
											     <td>Total Profit</td>
											     <td>Total Fees Paid</td>
											     <td>Total Taxes Paid</td>
											   </tr>
											   <tr>
											     <td>1 year</td>
											     <td>${formattedOneYearReturn} GBP</td>
											     <td>${formattedOneYearProfit} GBP</td>
											     <td>${formattedOneYearFees} GBP</td>
											     <td>${formattedOneYearTaxes} GBP</td>
											   </tr>
											   <tr>
											     <td>5 years</td>
											     <td>${formattedFiveYearReturn} GBP</td>
											     <td>${formattedFiveYearProfit} GBP</td>
											     <td>${formattedFiveYearFees} GBP</td>
											     <td>${formattedTenYearFees} GBP</td>
											   </tr>
											   <tr>
											     <td>10 years</td>
											     <td>${formattedTenYearReturn} GBP</td>
											     <td>${formattedFiveYearFees} GBP</td>
											     <td>${formattedTenYearFees} GBP</td>
											     <td>${formattedTenYearTaxes} GBP</td>
											   </tr>
											 </tbody>
										</table>
				             		</div> 
				        		</div>
				   			 </div>
						</div>
						       
						       
						       
						       
						    <% } %>
						</div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>