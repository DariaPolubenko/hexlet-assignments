package exercise.dto.posts;

import java.util.List;
import java.util.Map;

import exercise.model.Post;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// BEGIN
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EditPostPage {
    private long id;
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;
}
// END
