<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/dialog.css">

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

                <%@insert name="books_count"/>

                <ui:insert name="content"/>



                <div class="clear"></div>


            </div>
        </div>

        <div class="footer_blank"></div>

    </div>

    <%@ include file="/WEB-INF/templates/footer.jsp"%>


</body>
</html>




<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui">

<f:view>


</f:view>
</html>
