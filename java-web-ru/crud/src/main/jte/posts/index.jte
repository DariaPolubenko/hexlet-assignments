@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page
@param int pageNumber

@template.layout.page(
content = @`
    @if(page.getPosts().isEmpty())
        <p>Пока нет ни одного поста</p>
    @else
        @for(var post : page.getPosts())
            <div>
                <h3><a href="${NamedRoutes.postsPath(post.getId())}">${post.getName()}</a></h3>
            </div>
        @endfor
    @endif
    <a href="${NamedRoutes.postsPath() + "?page=" + (pageNumber - 1)}">Назад</a><a href="${NamedRoutes.postsPath() + "?page=" + (pageNumber + 1)}">Вперед</a>
`)

