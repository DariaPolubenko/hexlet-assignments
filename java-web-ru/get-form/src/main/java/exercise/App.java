package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");

            if (term != null) {
                List<User> filterUsers = new ArrayList<>();

                for (var user : USERS) {
                    var name = user.getFirstName().toLowerCase();
                    var normalizedTerm = term.toLowerCase();

                    if (name.contains(normalizedTerm)) {
                        filterUsers.add(user);
                    }
                }
                var page = new UsersPage(filterUsers, term);
                ctx.render("users/index.jte", model("page", page));

            } else {
                var page = new UsersPage(USERS, null);
                ctx.render("users/index.jte", model("page", page));
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
