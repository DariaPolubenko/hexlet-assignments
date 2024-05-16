package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV KeyValueStorage implements KeyValueStorage {
    private Map<String, String> storage;

    public KeyValueStorage(Map<String, String> initialValue) {
        this.storage = initialValue;
    }

    public void set(String key, String value) {
        storage.put(key, value);
    }

    public void unset(String key) {
        storage.remove(key);
    }

    public String get(String key, String defaultValue) {
            return storage.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return storage;
    }
}
// END
