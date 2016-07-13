<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student" action="/form">
    <p>First name:</p>
    <p><form:input path="firstName" type="text" /></p>
    <p>Last name:</p>
    <p><form:input path="lastName" type="text" /></p>
    <p>Date of birth:</p>
    <p><form:input path="dateOfBirth" type="text" /></p>
    <p>Sex: </p>
    <select name="sex">
        <c:forEach items="${sexes}" var="var">
            <option value="${var}">${fn:toLowerCase(var)}</option>
        </c:forEach>
    </select>
    <p><form:button type="submit">Submit</form:button></p>
</form:form>
</body>
</html>
