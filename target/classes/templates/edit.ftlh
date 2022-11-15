<#import "ui.ftl" as ui/>

<!DOCTYPE html>
<html>
<head>
    <title>Изменение</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .header{
            float: top;
            height: 40px;
            width: 100%;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #ffffff;
            overflow-x: hidden;
            padding-top: 20px;
            color: #000000;
        }

        .header a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 16px;
            color: #000000;
            display: block;
        }

        .sidenav {
            float: left;
            height: 100%;
            width: 160px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #ffffff;
            overflow-x: hidden;
            padding-top: 20px;
            color: #000000;
        }

        .sidenav a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 16px;
            color: #000000;
            display: block;
        }

        .sidenav a:hover {
            color: #000000;
        }

        .main {
            margin-left: 160px; /* Same as the width of the sidenav */
            font-size: 14px; /* Increased text to enable scrolling */
            padding: 0px 10px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }

    </style>

</head>
<body>

<div class="header">
    <a>UserMail</a>
</div>

<div class="sidenav">
    <a href="/list">Admin</a> <br>
    <a href="/user">User</a>
</div>

<div class="main">
    <legend>Add user</legend>
        <form name="user" action="edit" method="POST">
            <@ui.formInput id="t2" name="login" label="Логин" value="${userToEdit.getLogin()}"/> <br/>
            <@ui.formInput id="t3" name="password" label="Пароль" value="${userToEdit.getPassword()}"/> <br/>
            <@ui.formInput id="t4" name="age" label="Возраст" value="${userToEdit.getAge()}"/> <br/>
            <@ui.formInput id="t1" name="id" label="" value="${userToEdit.getId()}" type="hidden" /> <br/>
            <input type="submit" value="Save" />
        </form>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</div>
</body>
</html>