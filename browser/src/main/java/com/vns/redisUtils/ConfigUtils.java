package com.vns.redisUtils;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class ConfigUtils {
	private static Logger logger=(Logger) LoggerFactory.getLogger(ConfigUtils.class);

    public static boolean redisSwitch;
    public static int maxIdle;
    public static int active;
    public static boolean testOnBorrow;
    public static boolean testOnReturn;
    public static String ip;
    public static int port;
    public static String key;
    public static String password;
    public static int timeout;
    public static int fail_count=0;

    static{
        Properties props=new Properties();
        try {
            props.load(JedisUtils.class.getResourceAsStream("/redis.properties"));

            redisSwitch=Boolean.valueOf(props.getProperty("redis.switch"));
            maxIdle=Integer.valueOf(props.getProperty("jedis.pool.maxIdle"));
            testOnBorrow=Boolean.valueOf(props.getProperty("jedis.pool.testOnBorrow"));
            testOnReturn=Boolean.valueOf(props.getProperty("jedis.pool.testOnReturn"));
            ip=String.valueOf(props.getProperty("redis.ip"));
            port=Integer.valueOf(props.getProperty("redis.port"));
            password=String.valueOf(props.getProperty("redis.password"));
            key=String.valueOf(props.getProperty("redis.key"));
            timeout=Integer.valueOf(props.getProperty("jedis.pool.timeout"));
            active=Integer.valueOf(props.getProperty("jedis.pool.maxActive"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
