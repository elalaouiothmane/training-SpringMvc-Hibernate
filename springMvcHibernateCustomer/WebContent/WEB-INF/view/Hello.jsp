<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customers Management </title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
<div id="wrapper">
<div id="header">
<h2>Customers Management Spring MVC/Hibernate</h2>
</div>
</div>
<div id="container">
<div id="content">
 <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'"
     class="add-button"/>
   


<table>
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Action</th>

</tr>

<c:forEach var="cst" items="${customers}">
  <c:url var="LinkUpdate" value="/customer/showFormForUpdate">
  <c:param name="customerId" value="${cst.id}"></c:param>
  </c:url>
  
  <c:url var="LinkDelete" value="/customer/delete">
  <c:param name="customerId" value="${cst.id}"></c:param>
  </c:url>
  <tr>
  <td>${cst.firstname}</td>
  <td>${cst.lastname}</td>
  <td>${cst.email}</td>
  <td><a href="${LinkUpdate}">Update</a>
  |
  <a href="${LinkDelete}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
  
  </td>
  </tr>
  

</c:forEach>


</table>


</div>

</div>




</body>




</html>