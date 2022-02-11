package Dao;

import Services.RedisClient;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseDao {
    protected static final Gson GSON = new Gson();
    final private RedisClient client = new RedisClient();

    public Map<String, String> insert(String userKey, String userValue) {
       return this.client.insert(userKey, userValue);
    }

    public Map<String, String> insert(String key, String field, String value) {
        return this.client.insert(key, field, value);
    }

    protected Map<String, String> fetchMap(String key) {
        return this.client.fetchMap(key);
    }

    public String fetch(String key) {
        return this.client.fetch(key);
    }

    public Set<String> findKeys(String prefix) {
        return this.client.findKeys(prefix);
    }

    public Set<Map<String, String>> fetchAll(String key) {
        return this.findKeys(key).stream().map(this::fetchMap).collect(Collectors.toSet());
    }
}