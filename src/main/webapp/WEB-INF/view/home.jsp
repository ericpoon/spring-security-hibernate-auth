<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Home Page</h2>
<hr/>
<p>Welcome</p>

<p>User: <security:authentication property="principal.username"/></p>
<p>Role(s): <security:authentication property="principal.authorities"/></p>

<hr/>

<security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/managers">Manager meeting</a>
        (Only for managers)
    </p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/system">System maintenance</a>
        (Only for admins)
    </p>
</security:authorize>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
