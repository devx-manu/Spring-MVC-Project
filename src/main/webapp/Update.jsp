<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="update" method="post">

<input type="number" name="id" value="<%=request.getParameter("id")%>" hidden=""><br>
<br>
<input type="text" name="name" value="<%=request.getParameter("name")%>"><br>
<br>
<input type="text" name="email" value="<%=request.getParameter("email")%>"><br>
<br>
<input type="password" name="password" value="<%=request.getParameter("password")%>"><br>
<br>
<button>Submit</button>

</form>
</body>
</html>