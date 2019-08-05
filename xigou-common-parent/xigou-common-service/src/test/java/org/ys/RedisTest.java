package org.ys;

import cn.itsource.basic.util.RedisUtils;
import redis.clients.jedis.Jedis;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = RedisUtils.INSTANCE.getSource();
        jedis.set("username", "siliangzai");
        String username = jedis.get("username");
        System.out.println(username);
    }
}
