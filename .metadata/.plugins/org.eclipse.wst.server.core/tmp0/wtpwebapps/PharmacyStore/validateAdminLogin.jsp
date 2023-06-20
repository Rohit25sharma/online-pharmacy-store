<%@page import="com.pharmacystore.pojo.Admin"%>
<%@page import="com.pharmacystore.daoimpl.AdminDaoImpl"%>
<%@page import="com.pharmacystore.dao.AdminDao"%>
		<jsp:useBean id="admin" 
class="com.pharmacystore.pojo.Admin" scope="page"> 
		</jsp:useBean>
		<jsp:setProperty property="*" name="admin"/>
<%
		AdminDao daoImpl = new AdminDaoImpl();
		if(daoImpl.checkAdmin(admin)){
			session.setAttribute("ADMIN", 
					admin.getUserid());
			response.sendRedirect("adminhome.jsp");
		}
		else{
			response.sendRedirect("AdminLogin_Error.jsp");
		}	
%>