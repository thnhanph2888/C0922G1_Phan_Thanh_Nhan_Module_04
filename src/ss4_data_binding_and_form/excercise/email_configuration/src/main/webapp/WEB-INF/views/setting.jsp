<%--
  Created by IntelliJ IDEA.
  User: nhand
  Date: 2/2/2023
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="submit" method="post" modelAttribute="config">
    <form:hidden path="id" value="${config.id}"/>
    <div>
        <span>Languages</span>
        <form:select path="languages" items="${languages}" multiple="false" />
    </div>
    <div>
        <span>Page size</span>
        <form:select path="pageSize" items="${pageSizes}" multiple="false"/>
    </div>
    <div>
        <span> Spams filter:</span>
        <form:checkbox path="spamsFilter"/> enable spams filter
    </div>
    <div>
        <form:textarea path="signature"/>
    </div>
    <div>
        <input type="submit" value="update">
        <input type="reset" value="cancel">
    </div>
</form:form>
</body>
</html>
