<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
    <h3>Edit Student</h3>
    <form method="post" action="update">
        <table border="1">
                    <input type="hidden" name="id" value="<c:out value="${student.id}"/>"/>
            <tr>

            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="Name" value="<c:out value="${student.name}"/>"/>
                </td>
            </tr>
            <tr>
                <th>Surname</th>
                <td>
                    <input type="text" name="Surname" value="<c:out value="${student.surname}"/>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Edit">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
