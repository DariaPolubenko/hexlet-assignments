@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
    <title>Hexlet Javalin Example</title>
</head>
<body class="container">
    @if(page.getError() != null)
        <ul>
            <li>${page.getError()}</li>
        </ul>
    @endif
<form action="${NamedRoutes.loginPath()}" method="post">
    <div class="mb-3">
        <label>
            <input type="text" class="form-control" placeholder="Имя" name="name" />
        </label>
    </div>
    <div class="mb-3">
        <label>
            <input type="password" class="form-control" placeholder="Пароль" name="password" />
        </label>
    </div>
    <div class="mb-3">
        <label>
            <input type="submit" class="btn btn-primary mb-3" value="Отправить"/>
        </label>
    </div>
</form>
</body>
</html>
