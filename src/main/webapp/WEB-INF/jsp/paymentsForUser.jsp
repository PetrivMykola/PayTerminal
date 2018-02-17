<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Show Payments For User</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
    <div class="well"><h1 align="center" style="color: rebeccapurple">Payments
        for ${user.firstName} ${user.lastName}</h1></div>
    <br>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Payment_Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Amount</th>
            <th colspan=2> Action</th>
        </tr>
        </thead>
        <c:forEach items="${payments}" var="payment">
            <tr>
                <td><c:out value="${payment.id}"/></td>
                <td><c:out value="${payment.name}"/></td>
                <td><c:out value="${payment.address}"/></td>
                <td><c:out value="${payment.amount}"/></td>
                <td><a href="<c:out value='/payment/edit/${payment.id}'/>">Update</a></td>
                <td><a href="<c:out value='/payment/remove/${payment.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div class="text-center">
    <a href="/user/list" class="btn btn-primary" role="button">List Users</a>
    <a href="/home" class="btn btn-primary" role="button">Main Manu</a>
</div>

</body>
</html>
