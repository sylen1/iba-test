<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
</head>
<body>

<form:form id="student-form" method="post" modelAttribute="student" action="/edit/${student.id}">
    <p>First name:</p>
    <p><form:input path="firstName" name="firstName" type="text" /><span style="color: red;"><form:errors path="firstName"/></span></p>
    <p>Last name:</p>
    <p><form:input path="lastName" name="lastName" type="text" /><span style="color: red;"><form:errors path="lastName"/></span></p>
    <p>Date of birth:</p>
    <p><form:input path="dateOfBirth" name="dateOfBirth" type="text" id="datepicker"/><span style="color: red;"><form:errors path="dateOfBirth"/></span></p>
    <p>Sex: </p>
    <select name="sex">
        <c:forEach items="${sexes}" var="var">
            <option value="${var}" ${var == student.sex ? 'selected' : ''}>${fn:toLowerCase(var)}</option>
        </c:forEach>
    </select>
    <p><form:button type="submit">Submit</form:button></p>
</form:form>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/additional-methods.min.js"></script>
<script src="/js/validation.js"></script>
</body>
</html>
