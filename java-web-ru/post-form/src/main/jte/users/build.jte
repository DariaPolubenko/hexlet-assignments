@template.layout.page(
content = @`
    <form action="/users" method="post">
        <div class="mb-3">
            <label>
                <input type="text" class="form-control" placeholder="Имя" name="firstName"/>
            </label>
        </div>
        <div class="mb-3">
            <label>
                <input type="text" class="form-control" placeholder="Фамилия" required name="lastName"/>
            </label>
        </div>
        <div class="mb-3">
            <label>
                <input type="email" class="form-control" placeholder="Email" required name="email"/>
            </label>
        </div>
        <div class="mb-3">
            <label>
                <input type="password" class="form-control" placeholder="Пароль" required name="password"/>
            </label>
        </div>
        <input type="submit" class="btn btn-primary mb-3" value="Добавить"/>
    </form>
`
)