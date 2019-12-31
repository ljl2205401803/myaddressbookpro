<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
    <form action="deleteMyAddrBookByIdes.action" method="POST" name="myForm">
	<font color="red">${message}</font>
	<table>
		<tr>
			<td colspan="7"><h1>Welcome to My Address Book</h1></td>
		</tr>
	</table>
	<table border="1">
		<tr>
			<th><input type="checkbox" name="selected""/></th>
			<th>firstName</th>
			<th>lastName</th>
			<th>jobTitle</th>
			<th>department</th>
			<th>mobile</th>
			<th>offPh</th>
			<th>email</th>
			<th></th>
		</tr>
		<c:forEach items="${myAddrBookList}" var="myAddrBook">
			<tr>
				<td><input type="checkbox" name="ides" value="${myAddrBook.id}"/></td>
				<td><a href="findMyAddrBookList.action?id=${myAddrBook.id}">${myAddrBook.firstName}</a></td>
				<td>${myAddrBook.lastName}</td>
				<td>${myAddrBook.jobTitle}</td>
				<td>${myAddrBook.department}</td>
				<td>${myAddrBook.mobile}</td>
				<td>${myAddrBook.offPh}</td>
				<td>${myAddrBook.email}</td>
				<td><a href="deleteMyAddrBook.action?id=${myAddrBook.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="editMyAddrBook.jsp">Add new Contact</a>
	<a href="javascript:document.myForm.submit();">Deleted Selected MyAddrBook</a>
	</form>
</center>
</body>
</html>