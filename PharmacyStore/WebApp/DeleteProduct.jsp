<%@page import="com.pharmacystore.dao.ProductDao"%>
<%@page import="com.pharmacystore.daoimpl.ProductDaoImpl"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int pid = Integer.parseInt(
			request.getParameter("productid"));

	ProductDao daoImpl = new ProductDaoImpl();
	
	if(daoImpl.deleteProduct(pid))
	{
		response.sendRedirect("Delete_Success.jsp");
	}
	else
	{
		response.sendRedirect("Delete_Failure.jsp");
	}
%>
</body>
</html>