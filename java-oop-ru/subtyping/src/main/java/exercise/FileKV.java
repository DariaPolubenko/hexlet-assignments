package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private Map<String, String> storage;
    private String filePath;

    public FileKV(String filePath, Map<String, String> initialValue) {
        this.filePath = filePath;
        this.storage = new HashMap<>(initialValue);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    public void set(String key, String value) {
        storage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    public void unset(String key) {
        var content = Utils.readFile(filePath);
        var contentMap = Utils.unserialize(content);
        contentMap.remove(key);
        Utils.writeFile(filePath, Utils.serialize(contentMap));
    }

    public String get(String key, String defaultValue) {
        var content = Utils.readFile(filePath);
        var contentMap = Utils.unserialize(content);
        return contentMap.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        var content = Utils.readFile(filePath);
        var contentMap = Utils.unserialize(content);
        return new HashMap<>(contentMap);
    }
}
// END
