<#import "ui.ftl" as ui/>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<div>
    <fieldset>
        <legend>Add user</legend>
        <form name="user" action="/save" method="POST">
            <@ui.formInput id="t2" name="login" label="Логин"/> <br/>
            <@ui.formInput id="t3" name="password" label="Пароль"/> <br/>
            <@ui.formInput id="t4" name="age" label="Возраст"/> <br/>
            <input type="submit" value="Save" />
        </form>
    </fieldset>
</div>
</body>
</html>