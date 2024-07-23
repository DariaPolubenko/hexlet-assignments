@import exercise.dto.users.UsersPage
@param UsersPage users

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Пользователи</title>
</head>
<body>
@if(users.getUsers().isEmpty())
    <p>Пока не добавлено ни одного курса</p>
@else
    @for(var user : users.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}"> ${user.getFirstName()} ${user.getLastName()}</a></h2>
            <table>
                <tr>
                    <td>${user.getEmail()}</td>
                </tr>
            </table>
        </div>
    @endfor
@endif
</body>
</html>
