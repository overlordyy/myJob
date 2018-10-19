package com.vns.redisUtils;

import org.mybatis.caches.redis.SerializeUtil;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import ch.qos.logback.classic.Logger;

public class JedisUtils {
	 	private static Logger logger=(Logger) LoggerFactory.getLogger(JedisUtils.class);

	    private static String ADDR_ARRAY = "127.0.0.1";
	    private static JedisPool jedisPool = null;

	    //访问密码
	    private static String AUTH = "";

	    //可用连接实例的最大数目，默认值为8；
	    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	    private static int MAX_ACTIVE = 500;

	    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	    private static int MAX_IDLE = 100;

	    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	    private static int MAX_WAIT = 10 * 1000;

	    private static int TIMEOUT = 10 * 1000;//超时时间

	    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	    private static boolean TEST_ON_BORROW = true;

	    //Redis的端口号
	    private static int PORT = 6379;
	    
	    /**
	     * 初始化Redis连接池
	     */
	    private static void initialPool() {
	        try {
	            JedisPoolConfig config = new JedisPoolConfig();
	            config.setMaxTotal(ConfigUtils.active);
	            config.setMaxIdle(ConfigUtils.maxIdle);
	            config.setMaxWaitMillis(1500);
	            config.setTestOnBorrow(true);//使用时进行扫描，确保都可用
	            config.setTestWhileIdle(true);//Idle时进行连接扫描
	            config.setTestOnReturn(true);//还回线程池时进行扫描

                jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[0], PORT, TIMEOUT);

	        } catch (Exception e) {
	            logger.error("First create JedisPool error : " + e);
	            try {
	                //如果第一个IP异常，则访问第二个IP
	                JedisPoolConfig config = new JedisPoolConfig();
	                config.setMaxTotal(MAX_ACTIVE);
	                config.setMaxIdle(MAX_IDLE);
	                config.setMaxWaitMillis(MAX_WAIT);
	                config.setTestOnBorrow(TEST_ON_BORROW);
	                jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[1], PORT, TIMEOUT, AUTH);
	            } catch (Exception e2) {
	                logger.error("Second create JedisPool error : " + e2);
	            }
	        }
	    }

	    /**
	     * 在多线程环境同步初始化
	     */
	    private static synchronized void poolInit() {
	        if (jedisPool == null) {
	            initialPool();
	        }
	    }


	    /**
	     * 同步获取Jedis实例
	     *
	     * @return Jedis
	     */
	    public synchronized static Jedis getJedis() {
	        if (jedisPool == null) {
	            poolInit();
	        }

	        Jedis jedis = null;
	        try {
	            if (jedisPool != null) {
	                jedis = jedisPool.getResource();
	            }
	        } catch (Exception e) {
	            logger.error("Get jedis Error : " + e.getMessage(), e);
	        } finally {
	            returnResource(jedis);//归还到Redis池里面
	        }
	        return jedis;
	    }

	    /**
	     * 释放jedis资源
	     *
	     * @param jedis
	     */
	    public static void returnResource(final Jedis jedis) {
	        if (jedis != null && jedisPool != null) {
	            jedisPool.returnResource(jedis);
	        }
	    }

	    /**
	     * 关闭连接池
	     */
	    public static void closePool() {
	        if (jedisPool != null) {
	            jedisPool.close();
	        }
	    }

	    /**
	     * 获取String值
	     *
	     * @param key
	     * @return value
	     */
	    public synchronized static String getString(String key) {
	        if (getJedis() == null || !getJedis().exists(key)) {
	            return null;
	        }
	        return getJedis().get(key);
	    }

}
