<%@ page import="com.university.entities.Group" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="resources/css/dialog.css">

</head>
<body>
<div class="header">
    <%@ include file="/WEB-INF/templates/header.jsp" %>
</div>


<div id="wrap">

    <div class="content">
        <%@ include file="/WEB-INF/templates/left-menu.jsp" %>

        <div class="right-content">

            <p class="list">
                Group List
            </p>


            <table class="table">
                <thead>
                <tr>
                    <th>
                        GroupNumber
                    </th>
                    <th>
                        Department
                    </th>

                </tr>
                </thead>
                <tbody>
                <%
                    List<Group> list = (List<Group>) request.getAttribute("entityArray");

                    for (Group group : list) {
                %>
                <tr>
                    <td>
                        <%=group.getGroupNumber()%>
                    </td>
                    <td>
                        <%=group.getDepartment()%>
                    </td>
                    <td>
                        <%=group.getNumbers()%>
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

<%@ include file="/WEB-INF/templates/footer.jsp" %>
</body>
</html>
