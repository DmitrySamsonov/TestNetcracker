<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="resources/css/dialog.css">
</head>
<body>
    <div class="header">
        <%@ include file="/WEB-INF/templates/header.jsp"%>
    </div>

    <div class="content-wrapper">
        <div class="before-footer">
            <h1 align="center">Error</h1>
            <h3 align="center">
                Sorry, error.
                Error message was: ${errorMessage}
            </h3>
        </div>
    </div>

    <%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>