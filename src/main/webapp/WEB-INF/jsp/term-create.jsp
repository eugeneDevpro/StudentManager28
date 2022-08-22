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
    <title>Term Creating</title>
    <link rel="stylesheet" href="../../resources/fonts/fonts.css?V=232">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css?V=232">
</head>
<body>
<div id="container">
    <header>
        <nav class="head">
            <h1 class="title">Система управления студентами и их успеваемостью</h1>
            <div class="login">


                <c:choose>
                    <c:when test="${isLogin eq true}">
                        <div><p></p>Привет, ${login}!</p></div>
                        <div><a href="/logout">Logout</a> </div>
                    </c:when>
                    <c:otherwise>
                        <div><a href="/login">Login</a> </div>
                    </c:otherwise>
                </c:choose>


            </div>
        </nav>
    </header>
    <main>
        <section class="content">
            <div class="side_menu">
                <div><a href="/">На главную</a></div>
                <div><a href="/terms">Назад</a></div>
            </div>
            <div class="main">
                <h2>Для создания семестра заполните следующие данные и нажмите кнопку "Создать".</h2>
                <div class="form_cm">
                    <form action="/term-create" method="post">
                        <div class="line5">
                            <div>Длительность (в неделях)</div>
                            <label>
                                <input name="duration" type="text" value="24 недели">
                            </label>
                        </div>
                        <div class="line5">
                            <div>Дисциплины в семестре</div>
                            <label>idsDisc
                                <select multiple="multiple" name="idsDisc">
                                    <c:forEach items="${disciplines}" var="d">
                                    <option value="${d.id}">${d.discipline}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                        <input class="button_cm_term" type="submit" value="Создать">
                    </form>
                </div>
                <c:if test="${error eq 1}">
                    <h4>Поля не должны быть пустыми!</h4>
                </c:if>
            </div>
        </section>
    </main>
    <footer>
        <div>&copy; 2022 Goldstein Corp.</div>
    </footer>
</div>
</body>
</html>