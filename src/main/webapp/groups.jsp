<%@ page import="com.university.entities.Group" %>
<%@ page import="com.university.objects.StudentFacade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>

    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="resources/css/dialog.css">
</head>
<body>
    <div class="header">
        <%@ include file="/WEB-INF/templates/header.jsp"%>
    </div>


    <div id="wrap">

        <div class="content">
            <%@ include file="/WEB-INF/templates/left-menu.jsp"%>

            <div class="right-content">

                <p>
                    <h2>Group List</h2>
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

                <div class="clear"></div>

            </div>
        </div>

        <div class="footer_blank"></div>

    </div>

    <%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>
