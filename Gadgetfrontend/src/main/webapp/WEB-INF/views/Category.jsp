<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>


<form action="InsertCategory" method="post">
<table cellspacing="3" align="center">
	<tr bgcolor="orange"><td colspan="2"><center>Enter Category Detail</center></td></tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" id="catName"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><input type="text" name="catDesc" id="catDesc"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Insert Category"/></center>
		</td>
	</tr>
</table>
</form>

<table align="center" cellspacing="2" border="1">
	<tr bgcolor="orange">
		<td colspan="4"><center>Category Details</center></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Category ID</td>
		<td>Category Name </td>
		<td>Category Desc </td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${categories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>/
			<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>	
	</c:forEach>
	
</table>


</body>
</html>
