<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Create New User</h1>

<form:form action="/user/saveUser" method="post" modelAttribute="user">
    <table>
                <form:hidden path="id"/>

        <tr>
            <td>First_Name:</td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td>Last_Name:</td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save Changes" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
