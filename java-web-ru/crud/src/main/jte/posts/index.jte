@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page
@param int pageNumber
@param int size

@template.layout.page(
content = @`
    @if(page.getPosts().isEmpty())
        <p>Пока нет ни одного поста</p>
    @else
        @for(var post : page.getPosts())
            <div>
                <p class="fw-light"><a href="${NamedRoutes.postsPath(post.getId())}">${post.getName()}</a></p>
            </div>
        @endfor
    @endif
    <div>
        @if (pageNumber > 1)
        <a href="${NamedRoutes.postsPath()}?page=${pageNumber - 1}" class="btn btn-outline-primary rounded-1 fw-light">Назад</a>
        @endif
        @if(pageNumber <= size)
            <a href="${NamedRoutes.postsPath()}?page=${pageNumber + 1}" class="btn btn-outline-primary rounded-1 fw-light">Вперед</a>
        @endif
    </div>
`)

