<%@page import="dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% List<Student> list=(List<Student>) request.getAttribute("data"); %>

<% if(list==null)
	{
	%> <p>No records present</p>
	<% 
	}
		else {%>
<table border="">
	
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Delete</th>
<th>Update</th>
</tr>

<%for(Student s: list){ %>
	<tr>
		<td><%=s.getId() %> </td>
		<td><%=s.getName() %> </td>
		<td><%=s.getEmail() %> </td>
		<td><%=s.getPassword() %> </td>
		<td> <a href="delete?id=<%= s.getId() %>">delete</a></td>
		<td> <a href="Update.jsp?id=<%=s.getId()%>&&name=<%=s.getName()%>&&email=<%=s.getEmail()%>&&password=<%=s.getPassword()%>">Edit</a></td>
	</tr>
  <% }

%>
</table>
<%} %>
</body>
</html>