<%@ page import="com.university.entities.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="resources/css/dialog.css">

</head>
<body>

<%--TODO так писать нельзя!--%>
<div class="header">
    <%@ include file="/WEB-INF/templates/header.jsp" %>
</div>


<div id="wrap">
        <%@ include file="/WEB-INF/templates/search.jsp"%>

        <div class="content">
            <%@ include file="/WEB-INF/templates/left-menu.jsp"%>

            <div class="right-content">

                <div id="booksForm">

                    <p class="list">
                        Student List
                    </p>
                    <p>
                        <form action="add" method="GET">
                            <input type="submit" class="btn" value="Add New Student" />
                        </form>
                    </p>


                    <table class="table">
                        <thead>
                        <tr>
                            <th>
                                <a href="students?sortBy=Name">Name</a>
                            </th>
                            <th>
                                <a href="students?sortBy=GroupNumber">GroupNumber</a>
                            </th>
                            <th>
                                <a href="students?sortBy=Scolarship">Scolarship</a>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("entityArray");

                            for(Student student : list) {
                        %>
                        <div class="info">
                            <div class="image-info">
                        <tr>
                            <td style="display:none;" type="hidden">${student.id}</td>
                            <td><%=student.getFio()%></td>
                            <td><%=student.getGroupNumber()%></td>
                            <td>
                                <% if(student.getScolarship()!=null){%>
                                     <%=student.getScolarship()%>
                                <%}%>
                            </td>

                            <td>
                                <form class="mr" name="Edit" action="edit" method="GET">

                                    <input type = "hidden" name = "id" value="<%=student.getId()%>">

                                    <input type="submit" class="btn" value="Edit" />
                                </form>
                            </td>
                            <td>
                                <form class="delete-button" name="Delete" action="delete" method="POST">

                                    <input type = "hidden" name = "id" value="<%=student.getId()%>">

                                    <input type="submit" class="btn" value="Delete" />
                                </form>
                            </td>




                        </tr>
                            </div>
                        </div>


                        <%
                            }
                        %>
                        </tbody>
                    </table>


                </div>

                <div class="clear"></div>

            </div>
        </div>

        <div class="footer_blank"></div>

    </div>

    <%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>
