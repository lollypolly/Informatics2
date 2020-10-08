<%@ page import="ru.itis.database.DAO" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 08.10.2020
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Polina</title>
</head>
<body>
<h1 form class="form_title">Приветики, давай зарегистрируемся</h1>
<form action="/signUp" method="post">
    <div id="subscribe" class="animate form">
        <form  action="/signUp" autocomplete="on">
            <h1> Sign up </h1>
            <p>
                <label for="username_signup" class="you_name" data-icon="u">Your username</label>
                <input id="username_signup" name="username" required="required" type="text" placeholder="writeyournamehere" />
            </p>
            <p>
                <label for="email_signup" class="you_email" data-icon="e" > Your email</label>
                <input id="email_signup" name="email" required="required" type="text" placeholder="email@mail.com"/>
            </p>
            <p>
                <label for="password_signup" class="you_passwd" data-icon="p">Your password </label>
                <input id="password_signup" name="password" required="required" type="password" placeholder="eg. X8df!90EO"/>
            </p>
            <p>
                <label for="password_signup_confirm" class="you_passwd" data-icon="p">Please confirm your password </label>
                <input id="password_signup_confirm" name="password_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
            </p>
            <p class="sign_in button">
                <input type="submit" value="Sign up"/>
            </p>
            <p class="change_link">
                Already a member ?
                <a href="/login.html" class="to_subscribe"> Go and log in </a>
            </p>
        </form>
    </div>
    </div>
    </div>

</form>
<h2>Список Пользователей</h2>
<p><%=DAO.dao.find()%></p>
</body>
</html>
