package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    public static void index(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var pageNumbers = PostRepository.getSize() / 5;
        var postLists = PostRepository.findAll(pageNumber, 5);
        var page = new PostsPage(postLists);
        ctx.render("posts/index.jte", model("page", page, "pageNumber", pageNumber, "size", pageNumbers));
    }

    // END
}
