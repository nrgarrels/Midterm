<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action="navigationServlet">
<table>
<c:forEach items = "${requestScope.allCarParts}" var = "currentcar">
<tr>
<td><input type = "radio" name="id" value="${currentcarpart.id}"> </td>
<td>${currentcarpart.partName}</td>
<td>${currentcarpart.partNumber}</td>
</tr>
</c:forEach>
</table>
<input type ="submit" value = "add" name="doThisToCarPart">
</form>
</body>
</html>