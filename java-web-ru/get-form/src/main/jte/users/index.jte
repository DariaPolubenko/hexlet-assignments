@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" required name="term" value="${page.getTerm()}">
        <input type="submit" value="Искать">
    </form>
    @if(!page.getUsers().isEmpty())
        <table class="table table-striped">
            @for(var user : page.getUsers())
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                    <td>
                        <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                    </td>
                </tr>
            @endfor
        </table>
    @endif
`
)