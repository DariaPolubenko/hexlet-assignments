@import exercise.dto.users.UserPage
@param UserPage user

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
<div class="col-lg-8 mx-auto p-4 py-md-5">
    <main>
        <p>Имя: ${user.getUser().getFirstName()}</p>
        <p>Фамилия: ${user.getUser().getLastName()}</p>
        <p>Email: ${user.getUser().getEmail()}</p>
    </main>
</div>
</body>
</html>
