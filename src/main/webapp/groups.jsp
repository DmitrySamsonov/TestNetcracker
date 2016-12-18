<%@ page import="com.university.entities.Group" %>
<%@ page import="com.university.objects.StudentFacade" %>
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
<p>
    <a href="students">STUDENTS</a></p>
<p>
    <a href="groups">GROUPS</a>
</p>


<table>
    <thead>
    <tr>
        <%--<th class="hidden">id</th>--%>
        <th>
            id
        </th>
        <th>
            groupNumber
        </th>
        <th>
            department
        </th>

    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Group> list = (ArrayList<Group>) request.getAttribute("entityArray");

        for(Group group : list) {
    %>
    <tr>
        <%--<td class="hidden idField">${student.id}</td>--%>
        <td><%=group.getId()%></td>
        <td><%=group.getGroupNumber()%></td>
        <td><%=group.getDepartment()%></td>
    </tr>



    <%
        }
    %>
    </tbody>
</table>




</body>
</html>
