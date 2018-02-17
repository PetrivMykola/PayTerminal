<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>New Payment</title>
</head>
<body>

<h1>Create New Payment</h1>

<form:form action="/payment/save" method="post" modelAttribute="payment">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
            </td>
        </tr>
        <tr>
            <td>Payment_Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td>Amount:</td>
            <td><form:input path="amount" /></td>
        </tr>

        <tr>
            Users:
            <select name="userId">
                <c:forEach items="${userList}" var="user">
                    <option value="${user.id}"> ${user.lastName} </option>
                </c:forEach>
            </select> <br>

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
