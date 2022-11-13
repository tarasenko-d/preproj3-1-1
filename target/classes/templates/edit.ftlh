<#import "ui.ftl" as ui/>

<!DOCTYPE html>
<html>
<head>
    <title>Изменение</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<h2>List of users</h2>
<div>
    <fieldset>
        <legend>Add user</legend>
        <form name="user" action="edit" method="POST">
            <@ui.formInput id="t2" name="login" label="Логин" value="${userToEdit.getLogin()}"/> <br/>
            <@ui.formInput id="t3" name="password" label="Пароль" value="${userToEdit.getPassword()}"/> <br/>
            <@ui.formInput id="t4" name="age" label="Возраст" value="${userToEdit.getAge()}"/> <br/>
            <@ui.formInput id="t1" name="id" label="" value="${userToEdit.getId()}" type="hidden" /> <br/>
            <input type="submit" value="Save" />
        </form>
    </fieldset>
</div>
