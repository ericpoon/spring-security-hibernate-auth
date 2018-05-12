<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
<h3>Login to the system</h3>

<%-- form:form provides security support --%>
<form:form action="${pageContext.request.contextPath}/authentication" method="POST">

    <c:if test="${param.error != null}">
        <i class="failed">Authentication failed. Invalid user name or password.</i>
    </c:if>

    <p>User name: <input type="text" name="username"/></p>
    <p>Password: <input type="password" name="password"/></p>

    <input type="submit" value="Login"/>
</form:form>
</body>
</html>
