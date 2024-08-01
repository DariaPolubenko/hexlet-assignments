package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var currentUser = ctx.sessionAttribute("currentUser");
        var page = new MainPage(currentUser);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = Security.encrypt(ctx.formParam("password"));
        var user = UsersRepository.findByName(name).orElse(null);

        if (user != null && password.equals(user.getPassword())) {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var error = "Wrong username or password";
            var page = new LoginPage(name, error);
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
