<%@ page import="com.university.entities.Student" %>
<%@ page import="com.university.objects.UniversityFacade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    studentsList
</p>
<table>
    <thead>
    <tr>
        <%--<th class="hidden">id</th>--%>
        <th>
            id
        </th>
        <th>
            fio
        </th>
        <th>
            groupNumber
        </th>
        <th>
            field1
        </th>
        <th>
            field2
        </th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("entityArray");

        for(Student student : list) {
    %>
        <tr>
            <%--<td class="hidden idField">${student.id}</td>--%>
            <td><%=student.getId()%></td>
            <td><%=student.getFio()%></td>
            <td><%=student.getGroupNumber()%></td>
            <td><%=student.getScolarship()%></td>
            <td><%=student.getDateEnter()%></td>
        </tr>

    <%
        }
    %>
    </tbody>
</table>




</body>
</html>
