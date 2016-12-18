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
<p>
    <a href="students">STUDENTS</a></p>
<p>
    <a href="groups">GROUPS</a>
</p>
<p>
    <a href="add">ADD new student</a>
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
            <td>
                <form class="login_form" name="Edit" action="edit" method="GET">

                    <input type = "hidden" name = "id" value="<%=student.getId()%>">

                    <input type="submit" value="Edit" />
                </form>
            </td>
            <td>
                <form class="login_form" name="Delete" action="delete" method="POST">

                    <input type = "hidden" name = "id" value="<%=student.getId()%>">

                    <input type="submit" value="Delete" />
                </form>
            </td>
        </tr>


    <%
        }
    %>
    </tbody>
</table>




</body>
</html>
