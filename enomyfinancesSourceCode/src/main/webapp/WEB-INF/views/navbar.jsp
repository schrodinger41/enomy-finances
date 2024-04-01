<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar navbar-expand-lg d-flex flex-column align-items-center w-100 pb-0 shadow-sm border" style="z-index: 1000; position: sticky; top: 0; background-color: white">
    <div class="container">
        <a href="/enomyfinancesSourceCode/" class="navbar-brand fs-3 fw-bold" ><span><i class='bx bx-credit-card'></i></span> <span class="text-primary">Enomy</span> Finances</a>

        <div class="ms-auto d-flex gap-3">
            <sec:authorize access="isAuthenticated()">
		        <form:form action="logout" method="post">
			        <button type="submit" class="btn btn-danger ms-auto">Logout</button>
			    </form:form>
			    <!--<a href="/enomyfinancesSourceCode/logout" class="btn btn-danger ms-auto">Logout</a>-->
		    </sec:authorize>
		    <sec:authorize access="not isAuthenticated()">
		        <a href="login" class="btn btn-outline-primary ms-auto ">Login</a>
		        <a href="register" class="btn btn-primary ms-auto ">Register</a>
		    </sec:authorize>
        </div>
    </div>
    <div class="container border-top pt-2 px-0 mt-2 mb-0">
        <ul class="navbar-nav d-flex justify-content-center gap-3">
            <li class="nav-item">
                <a class="nav-link fw-semibold" href="/enomyfinancesSourceCode/">Home</a>
            </li>
            <sec:authorize access="hasRole('User')">
                <li class="nav-item">
                    <a class="nav-link fw-semibold" href="currencyconversionpage">Currency Conversion</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-semibold" href="investmentspage">Investments</a>
                </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link fw-semibold" href="<%= request.getContextPath() %>/dashboard">Dashboard</a>
                </li>
            </sec:authorize>
        </ul>
    </div>
</div>


