<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<h2>List of cities</h2>



<table>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
        <th>Age</th>
    </tr>

    <#list userList as user>
        <tr>
            <td> ${user.getId()}</td>
            <td> ${user.getLogin()}</td>
            <td> ${user.getPassword()}</td>
            <td> ${user.getAge()}</td>

        </tr>
    </#list>
</table>

</body>
</html>