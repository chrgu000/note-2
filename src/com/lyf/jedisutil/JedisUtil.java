//package com.lyf.jedisutil;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//import com.alibaba.fastjson.JSON;
//import com.dyuproject.protostuff.LinkedBuffer;
//import com.dyuproject.protostuff.ProtostuffIOUtil;
//import com.dyuproject.protostuff.runtime.RuntimeSchema;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.exceptions.JedisDataException;
//
///**
// * jedis的帮助工具 本类map依赖fastjson,对象与集合使用protostuff序列化框架 jedis版本2.9.0
// * protostuff相关版本1.0.8 fastjson版本1.2.32 使用maven自动添加依赖
// *
// * @author Mirren
// *
// */
//public class JedisUtil {
//	private static final int DEFAULT_SETEX_TIMEOUT = 60 * 60;// setex的默认时间
//
//	/**
//	 * 添加一个字符串值,成功返回1,失败返回0
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public static int set(String key, String value) {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			if (jedis.set(key, value).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//
//	}
//
//	/**
//	 * 缓存一个字符串值,成功返回1,失败返回0,默认缓存时间为1小时,以本类的常量DEFAULT_SETEX_TIMEOUT为准
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public static int setEx(String key, String value) {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			if (jedis.setex(key, DEFAULT_SETEX_TIMEOUT, value).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 缓存一个字符串值,成功返回1,失败返回0,缓存时间以timeout为准,单位秒
//	 *
//	 * @param key
//	 * @param value
//	 * @param timeout
//	 * @return
//	 */
//	public static int setEx(String key, String value, int timeout) {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			if (jedis.setex(key, timeout, value).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 添加一个指定类型的对象,成功返回1,失败返回0
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public static <T> int set(String key, T value) {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			byte[] data = enSeri(value);
//			if (jedis.set(key.getBytes(), data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 缓存一个指定类型的对象,成功返回1,失败返回0,默认缓存时间为1小时,以本类的常量DEFAULT_SETEX_TIMEOUT为准
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public static <T> int setEx(String key, T value) {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			byte[] data = enSeri(value);
//			if (jedis.setex(key.getBytes(), DEFAULT_SETEX_TIMEOUT, data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 缓存一个指定类型的对象,成功返回1,失败返回0,缓存时间以timeout为准,单位秒
//	 *
//	 * @param key
//	 * @param value
//	 * @param timeout
//	 * @return
//	 */
//	public static <T> int setEx(String key, T value, int timeout) {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			byte[] data = enSeri(value);
//			if (jedis.setex(key.getBytes(), timeout, data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 将一个数值+1,成功返回+后的结果,失败返回null
//	 *
//	 * @param key
//	 * @return
//	 * @throws JedisDataException
//	 */
//	public static Long incr(String key) throws JedisDataException {
//		if (isValueNull(key)) {
//			return null;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			return jedis.incr(key);
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 将一个数值-1,成功返回-后的结果,失败返回null
//	 *
//	 * @param key
//	 * @return
//	 * @throws JedisDataException
//	 */
//	public static Long decr(String key) throws JedisDataException {
//		if (isValueNull(key)) {
//			return null;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			return jedis.decr(key);
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 添加一个List集合成功返回1,失败返回0
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 * @throws IOException
//	 * @throws RuntimeException
//	 */
//	public static <T> int setList(String key, List<T> value) throws RuntimeException, IOException {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			byte[] data = enSeriList(value);
//			if (jedis.set(key.getBytes(), data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 缓存一个List<T>集合,成功返回1,失败返回0,默认缓存时间为1小时,以本类的常量DEFAULT_SETEX_TIMEOUT为准
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 * @throws IOException
//	 * @throws RuntimeException
//	 */
//
//	public static <T> int setExList(String key, List<T> value) throws RuntimeException, IOException {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			byte[] data = enSeriList(value);
//			if (jedis.setex(key.getBytes(), DEFAULT_SETEX_TIMEOUT, data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 缓存一个List<T>集合,成功返回1,失败返回0,缓存时间以timeout为准,单位秒
//	 *
//	 * @param key
//	 * @param value
//	 * @param timeout
//	 * @return
//	 * @throws IOException
//	 * @throws RuntimeException
//	 */
//	public static <T> int setExList(String key, List<T> value, int timeout) throws RuntimeException, IOException {
//		if (isValueNull(key, value)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			byte[] data = enSeriList(value);
//			if (jedis.setex(key.getBytes(), timeout, data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 添加一个Map<K, V>集合,成功返回1,失败返回0
//	 *
//	 * @param key
//	 * @param value
//	 * @param timeout
//	 * @return
//	 */
//	public static <K, V> int setMap(String key, Map<K, V> value) {
//		if (value == null || key == null || "".equals(key)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			String data = JSON.toJSONString(value);
//			if (jedis.set(key, data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 缓存一个Map<K, V>集合,成功返回1,失败返回0,默认缓存时间为1小时,以本类的常量DEFAULT_SETEX_TIMEOUT为准
//	 *
//	 * @param key
//	 * @param value
//	 * @param timeout
//	 * @return
//	 */
//	public static <K, V> int setExMap(String key, Map<K, V> value) {
//		if (value == null || key == null || "".equals(key)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			String data = JSON.toJSONString(value);
//			if (jedis.setex(key, DEFAULT_SETEX_TIMEOUT, data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 缓存一个Map<K, V>集合,成功返回1,失败返回0,缓存时间以timeout为准,单位秒
//	 *
//	 * @param key
//	 * @param value
//	 * @param timeout
//	 * @return
//	 */
//	public static <K, V> int setExMap(String key, Map<K, V> value, int timeout) {
//		if (value == null || key == null || "".equals(key)) {
//			return 0;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			String data = JSON.toJSONString(value);
//			if (jedis.setex(key, timeout, data).equalsIgnoreCase("ok")) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 获取一个字符串值
//	 *
//	 * @param key
//	 * @return
//	 */
//	public static String get(String key) {
//		if (isValueNull(key)) {
//			return null;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			return jedis.get(key);
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 获得一个指定类型的对象
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public static <T> T get(String key, Class<T> clazz) {
//		if (isValueNull(key)) {
//			return null;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//
//			byte[] data = jedis.get(key.getBytes());
//			T result = deSeri(data, clazz);
//			return result;
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 获得一个List<T>的集合,
//	 *
//	 * @param key
//	 *            键
//	 * @param clazz
//	 *            返回集合的类型
//	 * @return
//	 * @throws IOException
//	 */
//	public static <T> List<T> getList(String key, Class<T> clazz) throws IOException {
//		if (isValueNull(key)) {
//			return null;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			byte[] data = jedis.get(key.getBytes());
//			List<T> result = deSeriList(data, clazz);
//			return result;
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 获得一个Map<v,k>的集合
//	 *
//	 * @param key
//	 * @param v
//	 * @param k
//	 * @return
//	 */
//	public static <K, V> Map<K, V> getMap(String key, Class<K> k, Class<V> v) {
//		if (key == null || "".equals(key)) {
//			return null;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			String data = jedis.get(key);
//			@SuppressWarnings("unchecked")
//			Map<K, V> result = (Map<K, V>) JSON.parseObject(data);
//			return result;
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	/**
//	 * 删除一个值
//	 *
//	 * @param key
//	 */
//	public static void del(String key) {
//		if (key == null || "".equals(key)) {
//			return;
//		}
//		Jedis jedis = null;
//		try {
//			jedis = JedisPoolUtil.getJedis();
//			jedis.del(key);
//		} finally {
//			JedisPoolUtil.closeJedis(jedis);
//		}
//	}
//
//	// --------------------------公用方法区------------------------------------
//	/**
//	 * 检查值是否为null,如果为null返回true,不为null返回false
//	 *
//	 * @param obj
//	 * @return
//	 */
//	private static boolean isValueNull(Object... obj) {
//		for (int i = 0; i < obj.length; i++) {
//			if (obj[i] == null || "".equals(obj[i])) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	/**
//	 * 序列化一个对象
//	 *
//	 * @param value
//	 * @return
//	 */
//	private static <T> byte[] enSeri(T value) {
//		@SuppressWarnings("unchecked")
//		RuntimeSchema<T> schema = (RuntimeSchema<T>) RuntimeSchema.createFrom(value.getClass());
//		byte[] data = ProtostuffIOUtil.toByteArray(value, schema,
//				LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
//		return data;
//	}
//
//	/**
//	 * 反序列化一个对象
//	 *
//	 * @param t
//	 * @return
//	 */
//	private static <T> T deSeri(byte[] data, Class<T> clazz) {
//		if (data == null || data.length == 0) {
//			return null;
//		}
//		RuntimeSchema<T> schema = RuntimeSchema.createFrom(clazz);
//		T result = schema.newMessage();
//		ProtostuffIOUtil.mergeFrom(data, result, schema);
//		return result;
//	}
//
//	/**
//	 * 序列化List集合
//	 *
//	 * @param list
//	 * @return
//	 * @throws IOException
//	 */
//	private static <T> byte[] enSeriList(List<T> list) throws RuntimeException, IOException {
//		if (list == null || list.size() == 0) {
//			throw new RuntimeException("集合不能为空!");
//		}
//		@SuppressWarnings("unchecked")
//		RuntimeSchema<T> schema = (RuntimeSchema<T>) RuntimeSchema.getSchema(list.get(0).getClass());
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		ProtostuffIOUtil.writeListTo(out, list, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
//		byte[] byteArray = out.toByteArray();
//		return byteArray;
//	}
//
//	/**
//	 * 反序列化List集合
//	 *
//	 * @param data
//	 * @param clazz
//	 * @return
//	 * @throws IOException
//	 */
//	private static <T> List<T> deSeriList(byte[] data, Class<T> clazz) throws IOException {
//		if (data == null || data.length == 0) {
//			return null;
//		}
//		RuntimeSchema<T> schema = RuntimeSchema.createFrom(clazz);
//		List<T> result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(data), schema);
//		return result;
//	}
//
//}
