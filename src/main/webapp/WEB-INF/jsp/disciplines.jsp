<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Disciplines List</title>
    <link rel="stylesheet" href="../../resources/fonts/fonts.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
    <script src="../../resources/js/functions.js"></script>
</head>
<body>
<div id="container">
    <header>
        <nav class="head">
            <h1 class="title">Система управления студентами и их успеваемостью</h1>
            <div class="login">


                <div><p>Привет, admin!</p></div>
                <div><a href="/logout">Logout</a></div>



            </div>
        </nav>
    </header>
    <main>
        <section class="content">
            <div class="side_menu">
                <div><a href="/">На главную</a></div>
            </div>
            <div class="main">
                <h2 class="discipline_title">Список дисциплин</h2>
                <div class="discipline_section">
                    <div class="discipline">
                        <table class="list">
                            <tr>

                                <th class="ld_col0"></th>

                                <th class="ld_col1">Наименование дисциплины</th>
                            </tr>

                            <c:forEach items="${disciplines}" var="d">
                            <tr>

                                <td class="l_col0"><label><input name="idDiscipline" type="checkbox" value="${d.id}"></label>
                                <td class="l_col1">${d.discipline}</td>

                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="root_discipline">
                        <div class="button_group2">

                            <form action="/discipline-create">
                                <input class="button_discipline" type="submit" value="Создать дисциплину…">
                            </form>


                            <input class="button_discipline" type="submit" value="Модифицировать выбранную дисциплину…" onclick="modifyDiscipline()">
                            <input class="button_discipline" type="submit" value="Удалить выбранную дисциплину…"
                                   onclick="deleteDisciplines()">

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <footer>
        <div>&copy; 2022 Goldstein Corp.</div>
    </footer>
</div>
</body>
<form action="/discipline-delete"method="post" id="deleteForm">
    <input type="hidden" name="idsHiddenDelete" id="idsHiddenDelete">

</form>

<form action="/discipline-modify"method="get" id="modifyForm">
    <input type="hidden" name="idsHiddenModify" id="idsHiddenModify">
</form>
</html>