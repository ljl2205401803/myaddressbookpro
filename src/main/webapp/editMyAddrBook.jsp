<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <center>
     <font color="red">${message}</font>
	<form action="editMyAddrBook.action" method="POST">
		<table border="1">
			<tr>
				<td colspan="2"><h1>Add New Contact Details</h1></td>
			</tr>
			<tr>
				<td>firstName:
					<!-- 使用隐藏表单域存储id -->
					<input type="hidden" name="id" value="${myAddrBook.id}"/>
				</td>
				<td><input type="text" name="firstName" value="${myAddrBook.firstName}"/></td>
			</tr>
			<tr>
				<td>lastName:</td>
				<td><input type="text" name="lastName" value="${myAddrBook.lastName}"/></td>
			</tr>
			<tr>
				<td>jobTitle:</td>
				<td><input type="text" name="jobTitle" value="${myAddrBook.jobTitle}"/></td>
			</tr>
			<tr>
				<td>department:</td>
				<td><input type="text" name="department" value="${myAddrBook.department}"/></td>
			</tr>
			<tr>
				<td>mobile:</td>
				<td><input type="text" name="mobile" value="${myAddrBook.mobile}"/></td>
			</tr>
			<tr>
				<td>offPh:</td>
				<td><input type="text" name="offPh" value="${myAddrBook.offPh}"/></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" name="email" value="${myAddrBook.email}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"/></td>
				<td><input type="reset" value="Cancel"/>
					<a href="javascript:history.go(-1);">返回</a>
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>