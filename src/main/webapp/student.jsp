<%@ page import="com.university.entities.Student" %>
<%@ page import="com.university.objects.StudentFacade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>

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
                <h2>Student</h2>
            </p>
            <%  String action = "add";
                int id = 0;
                String fio = "";
                int groupNumber = 0;
                String scolarship = "";
            //    Date dateEnter = "01.01.1970";

                String button = "Create";
            %>
            <% if( request.getAttribute("wherefrom") == "studentEdit") {
                action = "edit";

                Student student = (Student)(request.getAttribute("student"));
                id = student.getId();
                fio = student.getFio();
                groupNumber = student.getGroupNumber();
                scolarship = student.getScolarship();
            //    dateEnter = student.getDateEnter();
                button = "Save";
            } %>

            <div class="input_div">
                <form class="login_form" name="newCar" action= "<%=action%>"  method="POST">

                    <input type = "hidden" name = "id" value="<%=id%>">

                    <p> fio <input type="text-area" name="fio" value="<%=fio%>" size="40" /> </p>
                    <p> groupNumber <input type="text-area" name="groupNumber" value="<%=groupNumber%>" size="40" /> </p>
                    <p> scolarship <input type="text-area" name="scolarship" value="<%=scolarship%>" size="40" /> </p>

                    <input type="submit" value="<%=button%>" />
                </form>
            </div>


            <div class="clear"></div>

        </div>
    </div>

    <div class="footer_blank"></div>

</div>

<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>
