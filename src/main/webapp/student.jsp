<%@ page import="com.university.entities.Student" %>
<%@ page import="com.university.objects.StudentFacade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/dialog.css">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
</head>
<body>
<div class="header">
    <%@ include file="/WEB-INF/templates/header.jsp"%>
</div>


<div id="wrap">

    <div class="content">
        <%@ include file="/WEB-INF/templates/left-menu.jsp"%>

        <div class="right-content">


            <%  String note ="Add New Student";
                String action = "add";
                int id = 0;
                String fio = "";
                String groupNumber = "";
                String scolarship = "";

                String button = "Create";
            %>
            <% if( request.getAttribute("wherefrom") == "studentEdit") {
                note = "Edit Student";
                action = "edit";

                Student student = (Student)(request.getAttribute("student"));
                id = student.getId();
                fio = student.getFio();
                groupNumber = String.valueOf(student.getGroupNumber());
                scolarship = String.valueOf(student.getScolarship());
                button = "Save";
            } %>
            <p class="list">
                <%=note%>
            </p>

                <form class="form-vertical" name="newCar" action= "<%=action%>"  method="POST">
                    <input type = "hidden" name = "id" value="<%=id%>">

                    <div class="form-group">
                        <label for="wrap">FIO:</label>
                        <input type="text-area" class="form-control" name="fio" value="<%=fio%>" size="40"/>
                    </div>
                    <div class="form-group">
                        <label>GroupNumber:</label>
                        <input type="text-area" name="groupNumber" value="<%=groupNumber%>" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Scolarship:</label>
                        <input type="text-area" name="scolarship" value="<%=scolarship%>" class="form-control">
                    </div>

                    <button type="submit" class="btn btn-primary"><%=button%></button>

                </form>


            <div class="clear"></div>

        </div>
    </div>

    <div class="footer_blank"></div>

</div>

<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>
