<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <style>
        #table{
        width: 50%;
        border-collapse: collapse;
        }
        td{
        padding: 3px;
        border: 1px solid black;
        }
    </style>
</head>
<body>

    <h4>Create new student</h4>
    <form id="#form1" method="post" action="insert">
        <label><input type="text" name="name" value="Enter name"></label>
        <label><input type="text" name="surname" value="Enter surname"></label>
        <label><input type="text" name="patronymic" value="Enter patronymic"></label>
        <label><input type="date" name="dateOfBorn"></label>
        <label><input type="text" name="nameOfGroup" value="Enter group"></label>
        <input type="submit" value="save" />
    </form>

    <h3>You can view list of students</h3>
    <table id="table">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>patronymic</th>
            <th>date of born</th>
            <th>group</th>
            <th>delete</th>
            <th>edit</th>
        </tr>

        <c:forEach var="student" items="${requestScope.studentList}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.surname}"/></td>
                <td><c:out value="${student.patronymic}"/></td>
                <td><c:out value="${student.dateOfBorn}"/></td>
                <td><c:out value="${student.nameOfGroup}"/></td>
                <td><a href="delete?id=<c:out value='${student.id}' />">delete</a></td>
                <td><a href="edit?id=<c:out value='${student.id}' />">edit</a></td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
