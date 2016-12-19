<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="resources/css/dialog.css">
</head>
<body>
    <div class="search">


        <form class="search_form" id="search_form" action="students" method="post">


            <input type="text" id="search_string" class="search-text" name="searchData" placeholder="enter for search"/>

            <input type="submit" id="btnSearch" value="Search" class="button" />

            <div class="dropdown">
                <select id="search_select" class="select_search" name="searchCriteria" >
                    <option value="fio">FIO</option>
                    <option value="groupNumber">GroupNumber</option>
                </select>
            </div>

        </form>

        <div class="clear"></div>

    </div>
</body>
</html>

