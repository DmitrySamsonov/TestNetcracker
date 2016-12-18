<%@ page import="com.university.entities.Student" %>
<%@ page import="com.university.objects.StudentFacade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>

    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="resources/css/dialog.css">
</head>
<body>
    <div class="header">
        <%@ include file="/WEB-INF/templates/header.jsp"%>
    </div>


    <div id="wrap">
        <%@ include file="/WEB-INF/templates/search.jsp"%>

        <div class="content">
            <%@ include file="/WEB-INF/templates/left-menu.jsp"%>

            <div class="right-content">

                <p>
                    studentsList
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
                            FIO
                        </th>
                        <th>
                            GroupNumber
                        </th>
                        <th>
                            Scolarship
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



                <div class="clear"></div>


            </div>
        </div>

        <div class="footer_blank"></div>

    </div>

    <%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>
