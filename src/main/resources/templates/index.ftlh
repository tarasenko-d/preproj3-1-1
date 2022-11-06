<#import "ui.ftl" as ui/>

<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<h2>List of users</h2>
<div>
    <fieldset>
        <legend>Add user</legend>
        <form name="user" action="save" method="POST">
            <@ui.formInput id="t2" name="login" label="Логин"/> <br/>
            <@ui.formInput id="t3" name="password" label="Пароль"/> <br/>
            <@ui.formInput id="t4" name="age" label="Возраст"/> <br/>
            <input type="submit" value="Save" />
        </form>
    </fieldset>
</div>


<table>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
        <th>Age</th>
        <th>Change</th>
    </tr>

    <#list userList as user>
        <tr>
            <td> ${user.getId()}</td>
            <td> ${user.getLogin()}</td>
            <td> ${user.getPassword()}</td>
            <td> ${user.getAge()}</td>
            <td>
                <a href="/edit?id=${user.getId()}">Edit</a>

                <a href="/delete?id=${user.getId()}">Delete</a>
            </td>

        </tr>
    </#list>
</table>

<form name="age" action="kids" method="GET">
<label> Найти пользователей до </label>
<input type="text" name="age" value="">
<input type="submit" value="Save" />
</form>
</body>
</html>