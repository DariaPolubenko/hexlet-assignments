@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
    @if(page.getName() == null)
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @else
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <p>Пока, ${String.valueOf(page.getName())}</p>
            <div class="mb-3">
            <label>
                <input type="submit" class="btn btn-primary mb-3" value="Выйти"/>
            </label>
            </div>
        </form>
    @endif
    `
)
