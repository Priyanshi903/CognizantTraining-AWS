<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin Menu Item List</title>
    <link rel="stylesheet" href="style/style.css">
    <script src="js/script.js"></script></head>
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
                <a href="show-menu-list-admin">Menu</a>
            </nav>
        </div>
    </header>
    <!-- main section starts here -->
    <main id="edit-menu-content">
        <div id="edit-menu-container">
            <h2 id="edit-title">Edit Menu Item</h2>
            <form:form name="menuItemForm" method="post" modelAttribute="menuItem" action="edit-menu-item" onsubmit="return validateMenuItemForm()">
            	<form:hidden path="id" />
                <div class="form-group-name">
                    <form:label path="name">Name</form:label><br/>
                    <form:input path="name" id="name" required="required"/>
                    <form:errors path="name" ></form:errors>
                </div>
                <div class="form-group-details">
                    <div class="details-price">
                        <form:label path="price" class="detials-label" >Price (Rs.)</form:label><br/>
                        <form:input  id="field-price" path="price"  placeholder="0.0" required="required"/>
                        <form:errors path="price" ></form:errors>
                    </div>
                    <div class="details-active">
                        <form:label path="active" class="detials-label">Active</form:label><br/>
                        <form:radiobutton id="field-active-yes" path="active" value="Yes" /> <label for="yes">Yes</label>&nbsp;&nbsp;
                        <form:radiobutton id="field-active-no" path="active" value="No" /> <label for="yes">No</label>
                    	<form:errors path="active"></form:errors>
                    </div>
                    <div class="details-date">
                        <form:label path="dateOfLaunch" class="details-label">Date of Launch</form:label><br/>
                        <form:input type="date" id="field-date" path="dateOfLaunch" required="required" />
                    	<form:errors path="dateOfLaunch"></form:errors>
                    </div>
                    <div class="details-category">
                        <form:label path="category" class="detials-label-name">Category</form:label><br/>
                        <form:select path="category" id="field-category">
                            <form:option path="Main Course" value="Main Course">Main Course</form:option>
                            <form:option path="Starters" value="Starters">Starters</form:option>
                            <form:option path="Dessert" value="Dessert">Dessert</form:option>
                            <form:option path="Drinks" value="Drinks">Drinks</form:option>
                        </form:select>
                    </div>
                 </div>
                <div>
                    <div class="details-delivery">
                        <form:checkbox id="field-delivery" path="freeDelivery" value="Yes" />
                        <form:label path="freeDelivery">Free Delivery</form:label>
                    </div>
                     <input type="submit" value="submit" id="submit-button">	
					
					<!-- <form:button value="submit" id="submit-button" >submit</form:button> -->
				</div>
			</form:form>
		</div>
	
                
    </main>
    <!-- footer section starts here-->
    <footer id="page-footer">
        <span class="page-copyrights">Copyright &copy; 2021</span>
    </footer>
    
</body>
</html>