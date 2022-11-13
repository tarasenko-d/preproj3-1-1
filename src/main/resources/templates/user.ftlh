
<!DOCTYPE html>
<html>
<head>
    <title>User</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<div>
    <fieldset> <tr>
            <legend>Ваша страница</legend>
            <label>${user.getLogin()}</label>   <td> ${user.getLogin()}</td> <br>
            <label>${user.getPassword()}</label>  <td> ${user.getPassword()}</td> <br>
            <label>${user.getAge()}</label>   <td> ${user.getAge()}</td> <br>

    </fieldset>
</div>
</body>
</html>