package exercise;

import exercise.dto.users.UsersPage;
import exercise.model.User;
import exercise.dto.users.UserPage;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import java.util.List;


public final class App {
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var users = new UsersPage(USERS);
            ctx.render("users/index.jte", model("users", users));
        });


        app.get("/users/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();

            var user = USERS.stream()
                    .filter(current -> current.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));

            var userPage = new UserPage(user);
            ctx.render("users/show.jte", model("user", userPage));
        });


        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /users/5");
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
