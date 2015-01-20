<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add zipCode page</title>
</head>
<body>
<h1>Add strategy page</h1>
<p>Here you can add a new strategy.</p>
<form:form method="POST" commandName="strategy" action="${pageContext.request.contextPath}/strategy/add.html">
<table>
<tbody>
 <tr>
  <td>Name:</td>
  <td><form:input path="name" /></td>
 </tr>
 <tr>
  <td>Type:</td>
  <td><form:input path="type" /></td>
 </tr>
 <tr>
  <td><input type="submit" value="Add" /></td>
  <td></td>
 </tr>
</tbody>
</table>
</form:form>
 
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>