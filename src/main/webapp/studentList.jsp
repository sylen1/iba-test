<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Date of birth</th>
            <th>Sex</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <th style="font-weight: normal;">${student.id}</th>
                <th style="font-weight: normal;">${student.firstName}</th>
                <th style="font-weight: normal;">${student.lastName}</th>
                <th style="font-weight: normal;"><fmt:formatDate value="${student.dateOfBirth}" pattern="dd.MM.yyyy "/></th>
                <th style="font-weight: normal;">${student.sex}</th>
                <th><a href="/student/${student.id}">Detail</a></th>
                <th><a href="/edit/${student.id}">Edit</a></th>
                <th><a href="/remove?id=${student.id}">Remove</a></th>
            </tr>
        </c:forEach>
    </table>
    <br>
    <b><a href="/create">Add student</a></b>
</body>
</html>
