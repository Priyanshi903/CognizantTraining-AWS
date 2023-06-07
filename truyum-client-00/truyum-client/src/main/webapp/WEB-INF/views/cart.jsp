<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <a href="show-menu-list-customer">Menu</a>
                <a href="show-cart?userId=1">Cart</a>
            </nav>
        </div>
    </header>
    <!-- main section starts here -->
    <main id="page-content">
        <div class= "container" style="overflow-x: auto;">
            <div class="space"></div>
            <table class="menu-table" id="menu-table">
                <caption class= "table-caption">Cart</caption>
                <c:if test="${removeCartItemStatus }">
                <caption style="color:red">Item removed from Cart Successfully </caption>
               	</c:if> 
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Free Delivery</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody id="cart-table-body">
					<c:forEach items="${cart}" var="item">
						<tr>
							<td> ${item.name } </td>
							<td> ${item.freeDelivery } </td>
							<td> ${item.price } </td>
							<td> ${item.category } </td>
							<td> <a href="remove-cart?menuItemId=${item.id}&userId=1">Delete</a> </td>
							
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td>Total</td>
						<td>${total }</td>
						<td></td>
						<td></td>
					</tr>
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