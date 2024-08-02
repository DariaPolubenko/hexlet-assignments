@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    <h2>Welcome to Hexlet</h2>
    @if(page.getPosts().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        @for(var post : page.getPosts())
            <div>
                <h3><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h3>
                <p>${post.getBody()}</p>
            </div>
        @endfor
    @endif

`
)
