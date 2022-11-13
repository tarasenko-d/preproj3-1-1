<#import "ui.ftl" as ui/>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<div>
    <fieldset>
        <legend>Авторизуйтесь</legend>
        <form action="/login" method="POST">
            <@ui.formInput id="t2" name="username" label="Логин"/> <br/>
            <@ui.formInput id="t3" name="password" label="Пароль"/> <br/>
            <input type="submit" value="Войти"/>
        </form>
    </fieldset>
    <a href="/registration"> Зарегистрироваться </a>
</div>
</body>
</html>