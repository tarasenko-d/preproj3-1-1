<#import "ui.ftl" as ui/>

<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
        .modal {
            position: absolute;
            visibility: hidden;
            opacity: 0;
            transition: .3s;
            top: -1000px;
            right: 0;
            bottom: 0;
            left: 0;
            z-index: 1000;
            background: rgba(0, 0, 0, 0.6);
            display: flex;
            justify-content: center;
            align-items: flex-start;
            overflow-y: scroll;
            padding: 60px 15px;
        }

        .modal_active {
            position: fixed;
            top: 5px;
            visibility: visible;
            opacity: 1;
            transition: .3s;
        }

        .modal__content {
            width: 100%;
            max-width: 500px;
            padding: 50px;
            background: #f9f9f9;
            border-radius: 3px;
            position: relative;
            box-shadow: 0 5px 15px black;
        }

        .modal__close-button {
            background: #ff0000;
            height: 30px;
            width: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
            border: none;
            position: absolute;
            right: 0;
            top: 0;
            background: none;
            cursor: pointer;
            transition: .3s;
            outline: none;
        }

        .modal__close-button:hover {
            transition: .3s;
            transform: rotate(360deg);
        }

        .header {
            float: top;
            height: 60px;
            width: 100%;
            position: fixed;
            z-index: 2;
            top: 0;
            left: 0;
            background-color: #212121;
            overflow-x: hidden;
            padding-top: 20px;
            color: #ffffff;
        }

        .header a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 16px;
            color: #000000;
            display: block;
        }

        .sidenav {
            height: 90%;
            width: 140px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            margin-top: 60px;
            background-color: #ffffff;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .sidenav a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 16px;
            color: #212121;
            display: block;
        }

        .sidenav a:hover {
            color: #1070b9;
        }

        .sidenav a.is-active {
            color: #fff;
            background-color: #1070b9;
        }

        .panel {
            list-style: none;
            margin-bottom: 9px;
            margin-left: 0px;
        }

        .panel a {
            text-decoration: none; /*убираем подчеркивание текста ссылок*/
            background: #d0cece; /*добавляем фон к пункту меню*/
            color: #414141; /*меняем цвет ссылок*/
            padding: 10px; /*добавляем отступ*/
            border-radius: 4px 4px 0px 0px; /*добавляем скругление*/
        }

        .panel a.active {
            color: #1070b9;
            background-color: #eae9e9;
        }

        .main {
            position: absolute;
            margin-left: 150px; /* Same as the width of the sidenav */
            margin-top: 100px; /*More then width of the header */
            font-size: 14px; /* Increased text to enable scrolling */
            padding: 0px 10px;
        }

        .central {
            margin-left: 10px;
        }

        body {
            position: absolute;
            background-color: #ffffff;
        }

        @media screen and (max-height: 450px) {
            .sidenav {
                padding-top: 15px;
            }

            .sidenav a {
                font-size: 18px;
            }
        }

    </style>

</head>
<body>

<div class="header">
    <a>---@mail.ru role: --- </a>
</div>

<div class="main">

    <div class="sidenav">
        <a href="/list" class="is-active">Admin</a> <br>
        <a href="/user">User</a>
    </div>

    <div class="central">

        <h2>Admin panel</h2>

        <div class="panel">
            <a href="/list" class="active">List of users</a>
            <a href="/admin/add">Add user</a>
        </div>

        <div>
            <table id="table-info" class="table table-hover table-striped">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Login</th>
                    <th scope="col">Password</th>
                    <th scope="col">Age</th>
                    <th scope="col">Roles</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>

                <#list userList as user>
                    <tr>
                        <td> ${user.getId()}</td>
                        <td> ${user.getLogin()}</td>
                        <td> ${user.getPassword()}</td>
                        <td> ${user.getAge()}</td>
                        <td> ${user.rolesToString()}</td>
                        <td>
                         <#-- <a class="btn btn-primary" href="/admin/edit?id=${user.getId()}">Edit</a>-->
                          <button class="btn btn-primary callback-button">Edit</button>
                        </td>
                        <td>
                            <a class="btn btn-danger" href="/admin/delete?id=${user.getId()}">Delete</a>
                        </td>
                    </tr>
                </#list>
            </table>
        </div>


        <form name="age" action="kids" method="GET">
            <label> Найти пользователей до </label>
            <input type="text" name="age" value="">
            <input type="submit" value="Поиск"/>
        </form>
    </div>


</div>
<div class="modal">
    <div class="modal__content">
      <button class="modal__close-button close" type="button" aria-label="Close">
            <span aria-hidden="true">&times;</span>
      </button>
          <form name="user" action="/admin/edit" method="POST">
              <label>Логин</label>
              <input type="text" name="login" value=""> <br/>
              <label>Пароль</label>
              <input type="text" name="password" value=""> <br/>
              <label>Возраст</label>
              <input type="text" name="age" value=""> <br/>
              <input type="hidden" name="id" value="">
            <input type="submit" value="Save"/>
        </form>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

    $(function () {
        $('.callback-button').click(function () {

            $('.modal').addClass('modal_active');
        });

        $('.modal__close-button').click(function () {
            $('.modal').removeClass('modal_active');
        });
    });
</script>

</body>
</html>