  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Enomy-Finances | Currency Conversion Module</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <style>
        .converter-section {
        	padding-top: 50px;
        }
        .result {
            padding-top: 10px;
        }
        .fee-table-container {
           margin: 0;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="converter-section">
    <div class="d-flex justify-content-center">
        <div class="container-fluid">
            <div class="row">
                <!-- Fee Table on the Left -->
                <div class="col-md-6">
                    <div class="px-5 py-2">
                        <h2>Fee Table</h2>
                        <p class="text-danger">Please note: The fees listed below are subject to change based on market conditions.</p>
		                    <table class="table">
		                        <thead>
		                            <tr>
		                                <th>Initial currency</th>
		                                <th>Amount</th>
		                                <th>Fee</th>
		                            </tr>
		                        </thead>
		                        <tbody>
		                            <tr>
		                                <td rowspan="2">Up to 500</td>
		                                <td>Up to 500</td>
		                                <td>3.5%</td>
		                            </tr>
		                            <tr>
		                                <td>Over 500</td>
		                                <td>2.7%</td>
		                            </tr>
		                            <tr>
		                                <td rowspan="3">Over 1500</td>
		                                <td>Over 1500</td>
		                                <td>2.0%</td>
		                            </tr>
		                            <tr>
		                                <td>Over 2500</td>
		                                <td>1.5%</td>
		                            </tr>
		                        </tbody>
		                    </table>
                    </div>
                </div>

                <!-- Form (Inputs and Show Results) on the Right -->
                <div class="col-md-6">
                    <div class="px-5 py-2">
                        <h1>Currency Converter</h1>
                        <p class="text-muted">Use the currency converter to estimate the converted amount based on the selected currencies and amount.</p>
                        <form:form action="currencyconversion" method="post">
                            <div class="mb-3">
                                <label for="fromCurrency" class="form-label">From Currency</label>
                                <select class="form-select" id="fromCurrency" name="fromCurrency" required>
                                    <option value="GBP">GBP - British Pound Sterling</option>
                                    <option value="USD">USD - US Dollar</option>
                                    <option value="EUR">EUR - Euro</option>
                                    <option value="BRL">BRL - Brazilian Real</option>
                                    <option value="JPY">JPY - Japanese Yen</option>
                                    <option value="TRY">TRY - Turkish Lira</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="amount" class="form-label">Amount</label>
                                <input type="number" class="form-control" id="amount" name="amount" required>
                            </div>
                            <div class="mb-3">
                                <label for="toCurrency" class="form-label">To Currency</label>
                                <select class="form-select" id="toCurrency" name="toCurrency" required>
                                    <option value="GBP">GBP - British Pound Sterling</option>
                                    <option value="USD">USD - US Dollar</option>
                                    <option value="EUR">EUR - Euro</option>
                                    <option value="BRL">BRL - Brazilian Real</option>
                                    <option value="JPY">JPY - Japanese Yen</option>
                                    <option value="TRY">TRY - Turkish Lira</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Convert</button>
                        </form:form>
                   
                        
                        <div class="result">
                            <% if(request.getAttribute("conversionSuccess") != null) { %>
							    <h2>Conversion Result</h2>
							    <p><%= request.getAttribute("amount") %> <%= request.getAttribute("fromCurrency") %> is equal to <%= request.getAttribute("formattedConvertedAmount") %> <%= request.getAttribute("toCurrency") %></p>
							    <p>Final Converted Amount: <%= request.getAttribute("formattedFinalConvertedAmount") %> <%= request.getAttribute("toCurrency") %></p>
							    <p>Conversion Fee: <%= request.getAttribute("fee") %> <%= request.getAttribute("toCurrency") %></p>
							   
						   
						        <form:form action="saveconversion" method="post">
                                    <input type="hidden" name="amount" value="<%= request.getAttribute("amount") %>">
                                    <input type="hidden" name="fromCurrency" value="<%= request.getAttribute("fromCurrency") %>">
                                    <input type="hidden" name="toCurrency" value="<%= request.getAttribute("toCurrency") %>">
                                    <button type="submit" class="btn btn-primary save-button" id="saveButton">Save Conversion</button>
                                </form:form>
                               	<% if (request.getAttribute("saveSuccess") != null && (Boolean) request.getAttribute("saveSuccess")) { %>
    								<p>Conversion saved successfully!</p>
								<% } else if (request.getAttribute("invalidAmount") != null && (Boolean) request.getAttribute("invalidAmount")) { %>
								    <p>Invalid amount. Please enter a value between 300 and 5000.</p>
								<% } else if (request.getAttribute("invalidAmountFormat") != null && (Boolean) request.getAttribute("invalidAmountFormat")) { %>
								    <p>Invalid amount format. Please enter a valid number.</p>
								<% } %>

	                        <% } else if (request.getAttribute("invalidAmount") != null && (Boolean) request.getAttribute("invalidAmount")) { %>
							    <p>Invalid amount. Please enter a value between 300 and 5000.</p>
							<% } else if (request.getAttribute("invalidAmountFormat") != null && (Boolean) request.getAttribute("invalidAmountFormat")) { %>
							    <p>Invalid amount format. Please enter a valid number.</p>
							
                        </div>
                    <% } %>
         
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
    
    
    
    
    
    
    
    
    
    
    
    

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
