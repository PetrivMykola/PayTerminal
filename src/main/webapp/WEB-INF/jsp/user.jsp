<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Show All Users</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
    <div class="well"><h1 align="center" style="color: rebeccapurple">User</h1></div>
    <br>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>User_Id</th>
            <th>First_Name</th>
            <th>Last_Name</th>
        </tr>
        </thead>
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
            </tr>
        </tbody>
    </table>

</div>
<div class="text-center">
<a href="/home" class="btn btn-primary" role="button">Main Manu</a>
</div>


</body>
</html>