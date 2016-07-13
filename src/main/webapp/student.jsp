<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><b>First name:</b></p>
<p>${student.firstName}</p>
<p><b>Last name:</b></p>
<p>${student.lastName}</p>
<p><b>Date of birth:</b></p>
<p><fmt:formatDate value="${student.dateOfBirth}" pattern="dd.MM.yyyy "/></p>
<p><b>Sex:</b></p>
<p>${student.sex}</p>
</body>
</html>
