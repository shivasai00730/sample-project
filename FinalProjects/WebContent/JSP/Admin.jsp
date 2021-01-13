<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Page</title>
</head>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Admin")== null) )
{
%>
<jsp:forward page="/JSP/login.jsp"></jsp:forward>
<%} %>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<center><h2>Admin's Home</h2></center>
 <h2>
Welcome User: <%=request.getAttribute("username") %>
 </h2>
 <div style="text-align: center"><a href="<%=request.getContextPath()%>/lists">Click here to View/Add/Delete User</a></div><br>

<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>