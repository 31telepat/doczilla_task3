<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
    <h3>Edit Student</h3>
    <form method="post" action="update">
        <table>
                    <input type="hidden" name="id" value="<c:out value='${student.id}'/>"/>
            <tr>

            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="name" value="<c:out value='${student.name}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Surname</th>
                <td>
                    <input type="text" name="surname" value="<c:out value='${student.surname}'/>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Save</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
