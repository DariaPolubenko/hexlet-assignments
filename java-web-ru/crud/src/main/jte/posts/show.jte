@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <a href="${NamedRoutes.postsPath()}">Все посты</a>
    <div>
    <h1>${page.getPost().getName()}</h1>
    <p>${page.getPost().getBody()}</p>
    </div>
`
)