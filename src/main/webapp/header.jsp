<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.jspServletPoc.util.DBConnectionUtil"%>
<%@ page import="com.jspServletPoc.model.User"%>
<%@ page import="com.jspServletPoc.dao.UserDao"%>


<%
	//String id = request.getParameter("userid");
	String userName = "suresh@painsclinic.com";
	Connection connection = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HeaderPage</title>
</head>
<body>
	<%
		UserDao dao = new UserDao();
		connection = DBConnectionUtil.getConnection();
		User user = dao.getUserRequiredDetails(connection, userName);
		
	%>	
	<h1 style="background-color:powderblue;"><%out.print("Welcome " +user.getFirst_name() + " " + user.getLast_name());%></h1>
</body>
</html>



