package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = StringUtils.capitalize(ctx.formParam("firstName"));
        var lastName = StringUtils.capitalize(ctx.formParam("lastName"));
        var email = ctx.formParam("email").trim().toLowerCase();;
        var password = ctx.formParam("password");
        var encryptedPassword = Security.encrypt(password);
        var token = Security.generateToken();

        var user = new User(firstName, lastName, email, encryptedPassword, token);
        UserRepository.save(user);

        ctx.cookie("token", String.valueOf(user.getToken()));
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var token = ctx.cookie("token");

        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));

        if (token.equals(user.getToken())) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
            return;
        }
        ctx.redirect(NamedRoutes.buildUserPath());
    }
    // END
}
