<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Title page</title>
    <link rel="stylesheet" href="resources/fonts/fonts.css?v=202">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css?v=202">
</head>
<body>
<div id="container">
    <header>
        <nav class="head">
            <h1 class="title">Система управления студентами и их успеваемостью</h1>
            <div class="login">



                <div><a href="/login">Login</a></div>


            </div>
        </nav>
    </header>
    <main>
        <section class="menu_title">
            <a href="/students">Студенты</a>
            <a href="/disciplines">Дисциплины</a>
            <a href="/terms">Семестры</a>
        </section>
    </main>
    <footer>
        <div>&copy; 2022 Goldstein Corp.</div>
    </footer>
</div>
</body>
</html>
