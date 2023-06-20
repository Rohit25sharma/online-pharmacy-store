<%@page import="com.pharmacystore.daoimpl.UserDaoImpl"%>
<%@page import="com.pharmacystore.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
<%
		String uid = request.getParameter("txtUid");
		String pass = request.getParameter("txtPassword");
%>
		<jsp:useBean id="user" 
		class="com.pharmacystore.pojo.User">
			<jsp:setProperty property="userid" value="<%=uid %>" name="user"></jsp:setProperty>
			<jsp:setProperty property="password" value="<%=pass %>" name="user"></jsp:setProperty>
		</jsp:useBean>

<%
		UserDao daoImpl = new UserDaoImpl();
		if(daoImpl.checkUser(user)){
			session.setAttribute("USER", uid);
			response.sendRedirect("userhome.jsp");
		}
		else{
			response.sendRedirect("UserLogin_Error.jsp");
		}	
%>
</div>	
</body>
</html>