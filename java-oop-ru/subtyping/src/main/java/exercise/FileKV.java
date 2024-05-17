package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String filePath;

    public FileKV(String filePath, Map<String, String> initialValue) {
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(initialValue));
    }

    public void set(String key, String value) {
        var content = Utils.readFile(filePath);
        var data = Utils.unserialize(content);
        data.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    public void unset(String key) {
        var content = Utils.readFile(filePath);
        var data = Utils.unserialize(content);
        data.remove(key);
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    public String get(String key, String defaultValue) {
        var content = Utils.readFile(filePath);
        var data = Utils.unserialize(content);
        return data.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        var content = Utils.readFile(filePath);
        var data = Utils.unserialize(content);
        return data;
    }
}
// END
