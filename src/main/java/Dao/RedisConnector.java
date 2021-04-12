package Dao;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnector {
    private final static JedisPool pool;

    private RedisConnector(){}

    static {
        pool = new JedisPool (new JedisPoolConfig(), "localhost");
    }

    public static JedisPool getJedisPool() {
        return pool;
    }
}