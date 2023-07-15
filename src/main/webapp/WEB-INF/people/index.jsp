<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.07.2023
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<ul>
    <h1>${people}</h1>
    <c:forEach var="person" items="${people}">
        <c:out value="${person.name}" />,
        <c:out value="${person.age}" />
    </c:forEach>
</ul>
<div th:each="person : ${people}">
</div>
</body>
</html>
