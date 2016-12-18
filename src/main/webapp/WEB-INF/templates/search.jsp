<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <div class="search">


        <form styleClass="search_form" id="search_form">


            <input type="submit" class="button-text"></input>


            <inputText  id="search_string" styleClass="search-text"/>

            <commandButton id="btnSearch" value="#{msg.search}" styleClass="button" />

            <div class="dropdown">
                <select id="search_select" styleClass="select_search" name="searchCriteria">
                    <option value="FIO">FIO</option>
                    <option value="GroupNumber">GroupNumber</option>
                </select>
            </div>

            <script language="javascript">
                document.getElementById("search_form:search_string").setAttribute("placeholder","#{msg.search_student}");
            </script>

        </form>

        <div class="clear"></div>

    </div>
</body>
</html>

