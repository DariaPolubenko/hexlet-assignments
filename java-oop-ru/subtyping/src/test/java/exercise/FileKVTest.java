package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void Test1() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.set("key2", "value2");
        assertThat(storage.get("key", "default")).isEqualTo("value");

        storage.unset("key");
        assertThat(storage.get("key", "def")).isEqualTo("def");
        assertThat(storage.toMap()).isEqualTo(Map.of("key2", "value2"));
    }

}
