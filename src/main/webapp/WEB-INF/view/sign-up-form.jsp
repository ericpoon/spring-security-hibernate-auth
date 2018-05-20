<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sign up</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
<h3>Register as a new user</h3>

<%-- form:form provides security support --%>
<form:form action="${pageContext.request.contextPath}/register/proceed" modelAttribute="user">

    <%--<c:if test="${param.error != null}">--%>
        <%--<i class="failed">Authentication failed. Invalid user name or password.</i>--%>
    <%--</c:if>--%>

    <%--<c:if test="${param.logout != null}">--%>
        <%--<i>You have just logged out.</i>--%>
    <%--</c:if>--%>

    <p>User name: <form:input path="username"/></p>
    <p>Password: <form:password path="password"/></p>

    <input type="submit" value="Sign up"/>
</form:form>
</body>
</html>
