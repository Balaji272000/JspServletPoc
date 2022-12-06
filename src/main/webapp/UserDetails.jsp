<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.jspServletPoc.util.DBConnectionUtil"%>
<%@ page import="com.jspServletPoc.dao.UserDao"%>
<jsp:include page="header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserDetails</title>
</head>
<body>
	<table class="table table-striped" border="1" style="background-color:lightcoral;">
		<thead><br>
			<tr>
				<th width="30%">UserName</th>
				<th width="20%">Gender</th>
				<th width="30%">PhoneNumber</th>
				<th width="20%">Status</th>
			</tr>
		</thead>
		<%
			UserDao dao = new UserDao();
			Connection connection = DBConnectionUtil.getConnection();
			ResultSet resultSet = dao.getUserDetails(connection, "suresh@painsclinic.com");
			while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getString("username")%></td>
			<td><%=resultSet.getString("gender")%></td>
			<td><%=resultSet.getString("phone")%></td>
			<td><%=resultSet.getString("status")%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>