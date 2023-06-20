<%@page import="com.pharmacystore.dao.CategoryDao"%>
<%@page import="com.pharmacystore.pojo.Category"%>
<%@page import="com.pharmacystore.daoimpl.CategoryDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%
	if(!session.isNew() || session.getAttribute("ADMIN") != null)
	{
		String catName = 
				request.getParameter("categoryname");
	
		CategoryDao daoImpl = new CategoryDaoImpl();
		Category category = new Category();
		category.setCategoryName(catName);
	
		if(daoImpl.addCategory(category)){
			response.sendRedirect("CategoryAdd_Success.jsp");
		}
		else
		{
			response.sendRedirect("CategoryAdd_Failure.jsp");
		}
	}
%>

