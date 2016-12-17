<%@ page import="com.university.entities.Student" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<div>
    hello Guys!
</div>

<%  String action = "ButtonCreate";
    int id = 0;
    String fio = "";
    int groupNumber = 0;
    String scolarship = "";
//    Date dateEnter = "01.01.1970";

    String button = "Create";
%>
<% if( request.getAttribute("wherefrom") == "ButtonEdit") {
    action = "ButtonSave";

    Student student = (Student)(request.getAttribute("car"));
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

        <p> fio <input type="text-area" name="model" value="<%=fio%>" size="40" /> </p>
        <p> groupNumber <input type="text-area" name="country" value="<%=groupNumber%>" size="40" /> </p>
        <p> scolarship <input type="text-area" name="count" value="<%=scolarship%>" size="40" /> </p>

        <input type="submit" value="<%=button%>" />
    </form>
</div>
</body>
</html>
