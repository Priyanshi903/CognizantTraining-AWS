<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Menu Item List</title>
<link rel="stylesheet" href="style/style.css">
<script src="js/script.js"></script>
</head>
<body>
    <!-- header section starts here  -->
    <header id="admin-header" class="admin-header">
        <div class="header-container">
            <div id="left-header" class="left-header">
                <h1 id="page-title">truyum</h1>
            </div>
            <div id="middle-header">
		<a href="show-menu-list-admin">
                	<img src="images/knife-logo.png" alt="logo" id="header-logo-icon">
	    	</a>        
	    </div>
            <nav id="right-header-navigation">
                <a href="show-menu-list-admin">Menu</a>
            </nav>
        </div>
    </header>
    <!-- main section starts here -->
    <main id="page-content">
        <div class= "container" style="overflow-x: auto;">
            <div class="space"></div>
            <table class="menu-table" id="menu-table">
                <caption class= "table-caption">Menu Items</caption>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Active</th>
                        <th>Date of Launch</th>
                        <th>Category</th>
                        <th>Free Delivery</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody id="menu-table-body">
					<c:forEach items="${menuItemListAdmin}" var="item">
						<tr>
							<td> ${item.name } </td>
							<td> ${item.price } </td>
							<td> ${item.active } </td>
							<td> ${item.dateOfLaunch } </td>
							<td> ${item.category } </td>
							<td> ${item.freeDelivery } </td>
							<td> <a href="show-edit-menu-item?menuItemId=${item.id}">Edit</a> </td>
						</tr>
					</c:forEach>
					<tr>
						<td>
							<a href="create-menu-item"><button class="submit-button1"> Create</button></a>
						</td>
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