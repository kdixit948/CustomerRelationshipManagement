<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<title>Customer-List</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>Customer Relationship Management - CRM</h2>
</div>
</div>
<div id="container">
<div id="content">

<!-- Add new Button - Add customer -->
<input type="button" value="Add Customer" 
onClick="window.location.href='showFormForAdd';return false;" class="add-button"/>
<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Action</th>

</tr>

<!-- Loop and print the customers -->
<c:forEach var="item" items="${customers}" 	>

<!-- Contruct an "UPDATE" link with customer id -->
<c:url var="updateLink" value="/customer/showFormForUpdate">
	<c:param name="custid" value="${item.id}"></c:param>
</c:url>

<!-- Contruct an "DELETE" link with customer id -->
<c:url var="deleteLink" value="/customer/delete">
	<c:param name="custid" value="${item.id}"></c:param>
</c:url>
<tr>
<td>${item.firstName}</td>
<td>${item.lastName}</td>
<td>${item.email}</td>
<td>
<a href="${updateLink}">Update</a>
| <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?')))return false">Delete</a>
</td>
</tr>
</c:forEach>
	

</table>
</div>

</div>
</body>

</html>