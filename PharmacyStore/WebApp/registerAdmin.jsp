<%@page import="com.pharmacystore.daoimpl.AdminDaoImpl"%>
<%@page import="com.pharmacystore.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>	
	
	<jsp:useBean id="admin" 
	class="com.pharmacystore.pojo.Admin"
	 scope="page">
	</jsp:useBean>
	
	<jsp:setProperty property="*" name="admin"/>
	
	<%
		AdminDao daoImpl = new AdminDaoImpl();
		if(daoImpl.register(admin)) {
			
			response.sendRedirect("AdminRegistration_Success.jsp");
		}
		else {
			
			response.sendRedirect("AdminRegistration_Failure.jsp");
		}
	%>

















