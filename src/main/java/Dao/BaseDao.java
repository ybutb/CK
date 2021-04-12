package Dao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseDao {
    private final JedisPool jedisPool = RedisConnector.getJedisPool();
    private static final String SUFFIX = ":*";

    public Map<String, String> insert(String userKey, String userValue) {
        this.getConnection().set(userKey, userValue);
        String value = this.getConnection().get(userKey);
        Map<String, String> result = new HashMap<>();
        result.put(userKey, value);

        return result;
    }

    public Map<String, String> insert(String key, String field, String value) {
        this.getConnection().hset(key, field, value);
        return this.getConnection().hgetAll(key);
    }

    public Map<String, String> fetchMap(String key) {
        return this.getConnection().hgetAll(key);
    }

    public String fetch(String key) {
        return this.getConnection().get(key);
    }

    public Set<String> findKeys(String prefix) {
        return this.getConnection().keys(prefix+SUFFIX);
    }

    private Jedis getConnection() {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis;
        } catch (Exception e) { // TODO: handle multithreading waiting for connection to be available.
            e.printStackTrace();
            throw e;
        }
    }
}