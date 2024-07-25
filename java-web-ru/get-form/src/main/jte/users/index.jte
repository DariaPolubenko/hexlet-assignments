@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <div class="mb-3">
            <input type="search" class="form-control" name="term" value="${page.getTerm()}">
            <input type="submit" class="btn btn-primary" style="margin-top: 15px" value="Искать">
        </div>
    </form>
    @if(!page.getUsers().isEmpty())
        <table class="table table-borderless">
            @for(var user : page.getUsers())
                <tr class="table-light">
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