<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="student" action="/edit/${student.id}">
    <p>First name:</p>
    <p><form:input path="firstName" type="text" /><span style="color: red;"><form:errors path="firstName"/></span></p>
    <p>Last name:</p>
    <p><form:input path="lastName" type="text" /><span style="color: red;"><form:errors path="lastName"/></span></p>
    <p>Date of birth:</p>
    <p><form:input path="dateOfBirth" type="text" /><span style="color: red;"><form:errors path="dateOfBirth"/></span></p>
    <p>Sex: </p>
    <select name="sex">
        <c:forEach items="${sexes}" var="var">
            <option value="${var}" ${var == student.sex ? 'selected' : ''}>${fn:toLowerCase(var)}</option>
        </c:forEach>
    </select>
    <p><form:button type="submit">Submit</form:button></p>
</form:form>
</body>
</html>
