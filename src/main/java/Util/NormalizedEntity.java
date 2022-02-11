package Util;

import java.util.HashMap;

public class NormalizedEntity {
    private String key;
    public HashMap<String, String> propValueMap;

    public NormalizedEntity(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public HashMap<String, String> getPropValueMap() {
        return propValueMap;
    }

    public void addProperty(String prop, String value) {
        this.propValueMap.put(prop, value);
    }
}
