<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Menu Item List</title>
<link rel="stylesheet" href="style/style.css">
<script src="js/script.js"></script>
</head>
<body>
    <!-- header section starts here  -->
    <header id="admin-header" class="admin-header">
        <div class="header-container">
            <div id="left-header" class="left-header">
                <h1 id="page-title"> truyum</h1>
            </div>
            <div id="middle-header">
                <img src="images/knife-logo.png" alt="logo" id="header-logo-icon">
            </div>
            <nav id="right-header-navigation">
                <a href="show-menu-list-customer">sign up</a>
                <!-- <a href="show-cart?userId=1">Cart</a> -->
            </nav>
        </div>
    </header>
    <!-- main section starts here -->
    <main id="page-content">
        <div class= "container" style="overflow-x: auto;">
            <div class="space"></div>
            <table class="menu-table" id="menu-table">
                <caption class= "table-caption">Login</caption>
                <tbody id="menu-table-body">
			
				<form:form name="menuItemForm" modelAttribute="loginModel" method="post"  action="login">
                <tr class="form-group-name">
                    <td><form:label path="userName">Name</form:label></td>
                    <td><form:input path="userName" id="name" required="required"/></td>
                    <td><form:errors path="userName" ></form:errors></td>
                </tr>
                <tr class="form-group-name">
         
                        <td><form:label path="password" type="text" class="detials-label" >Password </form:label><br/></td>
                        <td><form:input type="password" id="field-price" path="password" required="required"/></td>
                        <td><form:errors path="password" ></form:errors></td>
                    </tr>
			<tr>
				<td style="color:red">${status}</td>
			</tr>
		<tr><td><input type="submit" value="submit" id="submit-button"></td></tr>
		</form:form>
                </tbody>
            </table>
            <div class="space"></div>
        </div>
    </main>
    <!-- footer section starts here-->
    <footer id="page-footer">
        <span class="page-copyrights">Copyright &copy; 2021</span>
    </footer>
    
</body>
</html>