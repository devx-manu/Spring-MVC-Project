<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ page import="dto.Student" %>   <!-- change package if needed -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student</title>
</head>
<body>

<%
    Student std = (Student) request.getAttribute("data");
%>

<h2>Student Details</h2>

<% if(std != null) { %>
    ID: <%= std.getId() %> <br><br>
    Name: <%= std.getName() %> <br><br>
    Email: <%= std.getEmail() %> <br><br>
<% } else { %>
    <p>No student data found.</p>
<% } %>

</body>
</html>