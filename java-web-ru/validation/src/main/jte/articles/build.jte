@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif
<form action="/articles" method="post">
    <div>
        <label>
            <input type="text" required name="title" value="${page.getTitle()}" />
        </label>
    </div>
    <div>
        <label>
            <input type="text" required name="content" value="${page.getContent()}" />
           <!-- <textarea name="content" cols="20" rows="10"></textarea> -->
        </label>
    </div>
    <input type="submit" value="Опубликовать"/>
</form>
`
)
