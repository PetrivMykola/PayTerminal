<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>

<h1>Update  User</h1>

<form:form action="/person/save" method="post" modelAttribute="person">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"></form:hidden>
            </td>
        </tr>
        <tr>
            <td><form:label path="firstName">First_Name:</form:label></td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><form:label  path="lastName">Last_Name:</form:label></td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save Changes" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

